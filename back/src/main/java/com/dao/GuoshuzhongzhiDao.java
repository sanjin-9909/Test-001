package com.dao;

import com.entity.GuoshuzhongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuoshuzhongzhiVO;
import com.entity.view.GuoshuzhongzhiView;


/**
 * 果蔬种植
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface GuoshuzhongzhiDao extends BaseMapper<GuoshuzhongzhiEntity> {
	
	List<GuoshuzhongzhiVO> selectListVO(@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);
	
	GuoshuzhongzhiVO selectVO(@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);
	
	List<GuoshuzhongzhiView> selectListView(@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);

	List<GuoshuzhongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);

	
	GuoshuzhongzhiView selectView(@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);



}
