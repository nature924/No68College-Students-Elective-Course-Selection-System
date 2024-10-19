package com.dao;

import com.entity.PaikeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PaikeView;

/**
 * 排课信息 Dao 接口
 *
 * @author 
 */
public interface PaikeDao extends BaseMapper<PaikeEntity> {

   List<PaikeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
