package com.dao;

import com.entity.BisaixiangmuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BisaixiangmuYuyueView;

/**
 * 项目报名 Dao 接口
 *
 * @author 
 */
public interface BisaixiangmuYuyueDao extends BaseMapper<BisaixiangmuYuyueEntity> {

   List<BisaixiangmuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
