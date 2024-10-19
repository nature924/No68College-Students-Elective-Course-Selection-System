package com.dao;

import com.entity.XuankeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuankeView;

/**
 * 选课信息 Dao 接口
 *
 * @author 
 */
public interface XuankeDao extends BaseMapper<XuankeEntity> {

   List<XuankeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
