package com.dao;

import com.entity.KechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KechengView;

/**
 * 课程信息 Dao 接口
 *
 * @author 
 */
public interface KechengDao extends BaseMapper<KechengEntity> {

   List<KechengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
