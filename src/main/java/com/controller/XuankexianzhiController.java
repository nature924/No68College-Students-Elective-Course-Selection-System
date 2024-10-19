
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
 * 选课限制
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuankexianzhi")
public class XuankexianzhiController {
    private static final Logger logger = LoggerFactory.getLogger(XuankexianzhiController.class);

    private static final String TABLE_NAME = "xuankexianzhi";

    @Autowired
    private XuankexianzhiService xuankexianzhiService;


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
    private PaikeService paikeService;//排课信息
    @Autowired
    private XuankeService xuankeService;//选课信息
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
        CommonUtil.checkMap(params);
        PageUtils page = xuankexianzhiService.queryPage(params);

        //字典表数据转换
        List<XuankexianzhiView> list =(List<XuankexianzhiView>)page.getList();
        for(XuankexianzhiView c:list){
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
        XuankexianzhiEntity xuankexianzhi = xuankexianzhiService.selectById(id);
        if(xuankexianzhi !=null){
            //entity转view
            XuankexianzhiView view = new XuankexianzhiView();
            BeanUtils.copyProperties( xuankexianzhi , view );//把实体数据重构到view中
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
    public R save(@RequestBody XuankexianzhiEntity xuankexianzhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuankexianzhi:{}",this.getClass().getName(),xuankexianzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuankexianzhiEntity> queryWrapper = new EntityWrapper<XuankexianzhiEntity>()
            .eq("xuankexianzhi_number", xuankexianzhi.getXuankexianzhiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuankexianzhiEntity xuankexianzhiEntity = xuankexianzhiService.selectOne(queryWrapper);
        if(xuankexianzhiEntity==null){
            xuankexianzhi.setCreateTime(new Date());
            xuankexianzhiService.insert(xuankexianzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuankexianzhiEntity xuankexianzhi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuankexianzhi:{}",this.getClass().getName(),xuankexianzhi.toString());
        XuankexianzhiEntity oldXuankexianzhiEntity = xuankexianzhiService.selectById(xuankexianzhi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            xuankexianzhiService.updateById(xuankexianzhi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuankexianzhiEntity> oldXuankexianzhiList =xuankexianzhiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xuankexianzhiService.deleteBatchIds(Arrays.asList(ids));

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
            List<XuankexianzhiEntity> xuankexianzhiList = new ArrayList<>();//上传的东西
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
                            XuankexianzhiEntity xuankexianzhiEntity = new XuankexianzhiEntity();
//                            xuankexianzhiEntity.setXuankexianzhiNumber(Integer.valueOf(data.get(0)));   //选课数量 要改的
//                            xuankexianzhiEntity.setKaishiTime(sdf.parse(data.get(0)));          //开始时间 要改的
//                            xuankexianzhiEntity.setJieshuTime(sdf.parse(data.get(0)));          //结束时间 要改的
//                            xuankexianzhiEntity.setCreateTime(date);//时间
                            xuankexianzhiList.add(xuankexianzhiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xuankexianzhiService.insertBatch(xuankexianzhiList);
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

