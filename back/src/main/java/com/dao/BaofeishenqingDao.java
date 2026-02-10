package com.dao;

import com.entity.BaofeishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaofeishenqingVO;
import com.entity.view.BaofeishenqingView;


/**
 * 报废申请
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface BaofeishenqingDao extends BaseMapper<BaofeishenqingEntity> {
	
	List<BaofeishenqingVO> selectListVO(@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);
	
	BaofeishenqingVO selectVO(@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);
	
	List<BaofeishenqingView> selectListView(@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);

	List<BaofeishenqingView> selectListView(Pagination page,@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);

	
	BaofeishenqingView selectView(@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);
	

}
