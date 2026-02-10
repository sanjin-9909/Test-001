package com.dao;

import com.entity.ShifeijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShifeijiluVO;
import com.entity.view.ShifeijiluView;


/**
 * 施肥记录
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface ShifeijiluDao extends BaseMapper<ShifeijiluEntity> {
	
	List<ShifeijiluVO> selectListVO(@Param("ew") Wrapper<ShifeijiluEntity> wrapper);
	
	ShifeijiluVO selectVO(@Param("ew") Wrapper<ShifeijiluEntity> wrapper);
	
	List<ShifeijiluView> selectListView(@Param("ew") Wrapper<ShifeijiluEntity> wrapper);

	List<ShifeijiluView> selectListView(Pagination page,@Param("ew") Wrapper<ShifeijiluEntity> wrapper);

	
	ShifeijiluView selectView(@Param("ew") Wrapper<ShifeijiluEntity> wrapper);
	

}
