package com.dao;

import com.entity.ZuowuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuowuleixingVO;
import com.entity.view.ZuowuleixingView;


/**
 * 作物类型
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface ZuowuleixingDao extends BaseMapper<ZuowuleixingEntity> {
	
	List<ZuowuleixingVO> selectListVO(@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);
	
	ZuowuleixingVO selectVO(@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);
	
	List<ZuowuleixingView> selectListView(@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);

	List<ZuowuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);

	
	ZuowuleixingView selectView(@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);
	

}
