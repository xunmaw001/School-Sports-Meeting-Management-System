package com.dao;

import com.entity.SiachenganpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SiachenganpaiView;

/**
 * 赛程安排 Dao 接口
 *
 * @author 
 */
public interface SiachenganpaiDao extends BaseMapper<SiachenganpaiEntity> {

   List<SiachenganpaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
