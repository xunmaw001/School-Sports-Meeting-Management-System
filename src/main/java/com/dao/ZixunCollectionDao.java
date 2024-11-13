package com.dao;

import com.entity.ZixunCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunCollectionView;

/**
 * 资讯收藏 Dao 接口
 *
 * @author 
 */
public interface ZixunCollectionDao extends BaseMapper<ZixunCollectionEntity> {

   List<ZixunCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
