package com.dao;

import com.entity.GuangaijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuangaijiluVO;
import com.entity.view.GuangaijiluView;


/**
 * 灌溉记录
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface GuangaijiluDao extends BaseMapper<GuangaijiluEntity> {
	
	List<GuangaijiluVO> selectListVO(@Param("ew") Wrapper<GuangaijiluEntity> wrapper);
	
	GuangaijiluVO selectVO(@Param("ew") Wrapper<GuangaijiluEntity> wrapper);
	
	List<GuangaijiluView> selectListView(@Param("ew") Wrapper<GuangaijiluEntity> wrapper);

	List<GuangaijiluView> selectListView(Pagination page,@Param("ew") Wrapper<GuangaijiluEntity> wrapper);

	
	GuangaijiluView selectView(@Param("ew") Wrapper<GuangaijiluEntity> wrapper);
	

}
