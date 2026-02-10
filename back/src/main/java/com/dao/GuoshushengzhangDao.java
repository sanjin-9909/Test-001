package com.dao;

import com.entity.GuoshushengzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuoshushengzhangVO;
import com.entity.view.GuoshushengzhangView;


/**
 * 果蔬生长
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface GuoshushengzhangDao extends BaseMapper<GuoshushengzhangEntity> {
	
	List<GuoshushengzhangVO> selectListVO(@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);
	
	GuoshushengzhangVO selectVO(@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);
	
	List<GuoshushengzhangView> selectListView(@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);

	List<GuoshushengzhangView> selectListView(Pagination page,@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);

	
	GuoshushengzhangView selectView(@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);



}
