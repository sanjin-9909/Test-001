package com.dao;

import com.entity.DapengxunjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DapengxunjianVO;
import com.entity.view.DapengxunjianView;


/**
 * 大棚巡检
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface DapengxunjianDao extends BaseMapper<DapengxunjianEntity> {
	
	List<DapengxunjianVO> selectListVO(@Param("ew") Wrapper<DapengxunjianEntity> wrapper);
	
	DapengxunjianVO selectVO(@Param("ew") Wrapper<DapengxunjianEntity> wrapper);
	
	List<DapengxunjianView> selectListView(@Param("ew") Wrapper<DapengxunjianEntity> wrapper);

	List<DapengxunjianView> selectListView(Pagination page,@Param("ew") Wrapper<DapengxunjianEntity> wrapper);

	
	DapengxunjianView selectView(@Param("ew") Wrapper<DapengxunjianEntity> wrapper);
	

}
