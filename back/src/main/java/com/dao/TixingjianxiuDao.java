package com.dao;

import com.entity.TixingjianxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TixingjianxiuVO;
import com.entity.view.TixingjianxiuView;


/**
 * 提醒检修
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface TixingjianxiuDao extends BaseMapper<TixingjianxiuEntity> {
	
	List<TixingjianxiuVO> selectListVO(@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);
	
	TixingjianxiuVO selectVO(@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);
	
	List<TixingjianxiuView> selectListView(@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);

	List<TixingjianxiuView> selectListView(Pagination page,@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);

	
	TixingjianxiuView selectView(@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);
	

}
