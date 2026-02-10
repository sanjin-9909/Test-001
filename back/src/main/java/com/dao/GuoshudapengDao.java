package com.dao;

import com.entity.GuoshudapengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuoshudapengVO;
import com.entity.view.GuoshudapengView;


/**
 * 果蔬大棚
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface GuoshudapengDao extends BaseMapper<GuoshudapengEntity> {
	
	List<GuoshudapengVO> selectListVO(@Param("ew") Wrapper<GuoshudapengEntity> wrapper);
	
	GuoshudapengVO selectVO(@Param("ew") Wrapper<GuoshudapengEntity> wrapper);
	
	List<GuoshudapengView> selectListView(@Param("ew") Wrapper<GuoshudapengEntity> wrapper);

	List<GuoshudapengView> selectListView(Pagination page,@Param("ew") Wrapper<GuoshudapengEntity> wrapper);

	
	GuoshudapengView selectView(@Param("ew") Wrapper<GuoshudapengEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshudapengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshudapengEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshudapengEntity> wrapper);



}
