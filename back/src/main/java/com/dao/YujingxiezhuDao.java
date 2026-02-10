package com.dao;

import com.entity.YujingxiezhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YujingxiezhuVO;
import com.entity.view.YujingxiezhuView;


/**
 * 预警协助
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface YujingxiezhuDao extends BaseMapper<YujingxiezhuEntity> {
	
	List<YujingxiezhuVO> selectListVO(@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);
	
	YujingxiezhuVO selectVO(@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);
	
	List<YujingxiezhuView> selectListView(@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);

	List<YujingxiezhuView> selectListView(Pagination page,@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);

	
	YujingxiezhuView selectView(@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);
	

}
