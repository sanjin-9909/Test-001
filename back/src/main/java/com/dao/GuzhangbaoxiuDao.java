package com.dao;

import com.entity.GuzhangbaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuzhangbaoxiuVO;
import com.entity.view.GuzhangbaoxiuView;


/**
 * 故障报修
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface GuzhangbaoxiuDao extends BaseMapper<GuzhangbaoxiuEntity> {
	
	List<GuzhangbaoxiuVO> selectListVO(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
	
	GuzhangbaoxiuVO selectVO(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
	
	List<GuzhangbaoxiuView> selectListView(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);

	List<GuzhangbaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);

	
	GuzhangbaoxiuView selectView(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
	

}
