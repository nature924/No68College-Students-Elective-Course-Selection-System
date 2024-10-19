package com.dao;

import com.entity.XuankexianzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuankexianzhiView;

/**
 * 选课限制 Dao 接口
 *
 * @author 
 */
public interface XuankexianzhiDao extends BaseMapper<XuankexianzhiEntity> {

   List<XuankexianzhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
