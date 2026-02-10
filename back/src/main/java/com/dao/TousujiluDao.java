package com.dao;

import com.entity.TousujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TousujiluVO;
import com.entity.view.TousujiluView;


/**
 * 投诉记录
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface TousujiluDao extends BaseMapper<TousujiluEntity> {
	
	List<TousujiluVO> selectListVO(@Param("ew") Wrapper<TousujiluEntity> wrapper);
	
	TousujiluVO selectVO(@Param("ew") Wrapper<TousujiluEntity> wrapper);
	
	List<TousujiluView> selectListView(@Param("ew") Wrapper<TousujiluEntity> wrapper);

	List<TousujiluView> selectListView(Pagination page,@Param("ew") Wrapper<TousujiluEntity> wrapper);

	
	TousujiluView selectView(@Param("ew") Wrapper<TousujiluEntity> wrapper);
	

}
