
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 排课信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/paike")
public class PaikeController {
    private static final Logger logger = LoggerFactory.getLogger(PaikeController.class);

    private static final String TABLE_NAME = "paike";

    @Autowired
    private PaikeService paikeService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChengjiService chengjiService;//学生成绩
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiaoshiService jiaoshiService;//教师
    @Autowired
    private KechengService kechengService;//课程信息
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private XuankeService xuankeService;//选课信息
    @Autowired
    private XuankexianzhiService xuankexianzhiService;//选课限制
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        params.put("paikeDeleteStart",1);params.put("paikeDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = paikeService.queryPage(params);

        //字典表数据转换
        List<PaikeView> list =(List<PaikeView>)page.getList();
        for(PaikeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PaikeEntity paike = paikeService.selectById(id);
        if(paike !=null){
            //entity转view
            PaikeView view = new PaikeView();
            BeanUtils.copyProperties( paike , view );//把实体数据重构到view中
            //级联表 课程信息
            //级联表
            KechengEntity kecheng = kechengService.selectById(paike.getKechengId());
            if(kecheng != null){
            BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "jiaoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKechengId(kecheng.getId());
            }
            //级联表 教师
            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(paike.getJiaoshiId());
            if(jiaoshi != null){
            BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "jiaoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiaoshiId(jiaoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PaikeEntity paike, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,paike:{}",this.getClass().getName(),paike.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教师".equals(role))
            paike.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PaikeEntity> queryWrapper = new EntityWrapper<PaikeEntity>()
            .eq("kecheng_id", paike.getKechengId())
            .eq("jieke_types", paike.getJiekeTypes())
            .eq("xueqi_types", paike.getXueqiTypes())
            .eq("xingqi_types", paike.getXingqiTypes())
            .eq("paike_address", paike.getPaikeAddress())
            .eq("jiaoshi_id", paike.getJiaoshiId())
            .eq("paike_delete", paike.getPaikeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PaikeEntity paikeEntity = paikeService.selectOne(queryWrapper);
        if(paikeEntity==null){
            paike.setPaikeDelete(1);
            paike.setCreateTime(new Date());
            paikeService.insert(paike);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PaikeEntity paike, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,paike:{}",this.getClass().getName(),paike.toString());
        PaikeEntity oldPaikeEntity = paikeService.selectById(paike.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教师".equals(role))
//            paike.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            paikeService.updateById(paike);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PaikeEntity> oldPaikeList =paikeService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<PaikeEntity> list = new ArrayList<>();
        for(Integer id:ids){
            PaikeEntity paikeEntity = new PaikeEntity();
            paikeEntity.setId(id);
            paikeEntity.setPaikeDelete(2);
            list.add(paikeEntity);
        }
        if(list != null && list.size() >0){
            paikeService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PaikeEntity> paikeList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PaikeEntity paikeEntity = new PaikeEntity();
//                            paikeEntity.setKechengId(Integer.valueOf(data.get(0)));   //课程 要改的
//                            paikeEntity.setShangkeTime(sdf.parse(data.get(0)));          //上课时间 要改的
//                            paikeEntity.setXiakeTime(sdf.parse(data.get(0)));          //结束时间 要改的
//                            paikeEntity.setJiekeTypes(Integer.valueOf(data.get(0)));   //第几节 要改的
//                            paikeEntity.setXueqiTypes(Integer.valueOf(data.get(0)));   //学期 要改的
//                            paikeEntity.setXingqiTypes(Integer.valueOf(data.get(0)));   //周次 要改的
//                            paikeEntity.setPaikeAddress(data.get(0));                    //上课地点 要改的
//                            paikeEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            paikeEntity.setPaikeDelete(1);//逻辑删除字段
//                            paikeEntity.setCreateTime(date);//时间
                            paikeList.add(paikeEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        paikeService.insertBatch(paikeList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

