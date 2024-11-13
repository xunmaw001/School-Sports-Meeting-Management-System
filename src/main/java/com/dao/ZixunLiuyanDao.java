package com.dao;

import com.entity.ZixunLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunLiuyanView;

/**
 * 资讯留言 Dao 接口
 *
 * @author 
 */
public interface ZixunLiuyanDao extends BaseMapper<ZixunLiuyanEntity> {

   List<ZixunLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
