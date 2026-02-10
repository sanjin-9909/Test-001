package com.dao;

import com.entity.DapengshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DapengshenqingVO;
import com.entity.view.DapengshenqingView;


/**
 * 大棚申请
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface DapengshenqingDao extends BaseMapper<DapengshenqingEntity> {
	
	List<DapengshenqingVO> selectListVO(@Param("ew") Wrapper<DapengshenqingEntity> wrapper);
	
	DapengshenqingVO selectVO(@Param("ew") Wrapper<DapengshenqingEntity> wrapper);
	
	List<DapengshenqingView> selectListView(@Param("ew") Wrapper<DapengshenqingEntity> wrapper);

	List<DapengshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<DapengshenqingEntity> wrapper);

	
	DapengshenqingView selectView(@Param("ew") Wrapper<DapengshenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DapengshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DapengshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DapengshenqingEntity> wrapper);



}
