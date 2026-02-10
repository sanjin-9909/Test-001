package com.dao;

import com.entity.GenghuanjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GenghuanjiluVO;
import com.entity.view.GenghuanjiluView;


/**
 * 更换记录
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface GenghuanjiluDao extends BaseMapper<GenghuanjiluEntity> {
	
	List<GenghuanjiluVO> selectListVO(@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);
	
	GenghuanjiluVO selectVO(@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);
	
	List<GenghuanjiluView> selectListView(@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);

	List<GenghuanjiluView> selectListView(Pagination page,@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);

	
	GenghuanjiluView selectView(@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);
	

}
