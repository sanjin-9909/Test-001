package com.dao;

import com.entity.ShebeigoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeigoumaiVO;
import com.entity.view.ShebeigoumaiView;


/**
 * 设备购买
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface ShebeigoumaiDao extends BaseMapper<ShebeigoumaiEntity> {
	
	List<ShebeigoumaiVO> selectListVO(@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);
	
	ShebeigoumaiVO selectVO(@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);
	
	List<ShebeigoumaiView> selectListView(@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);

	List<ShebeigoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);

	
	ShebeigoumaiView selectView(@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);



}
