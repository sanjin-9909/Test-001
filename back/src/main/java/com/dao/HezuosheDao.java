package com.dao;

import com.entity.HezuosheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HezuosheVO;
import com.entity.view.HezuosheView;


/**
 * 合作社
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface HezuosheDao extends BaseMapper<HezuosheEntity> {
	
	List<HezuosheVO> selectListVO(@Param("ew") Wrapper<HezuosheEntity> wrapper);
	
	HezuosheVO selectVO(@Param("ew") Wrapper<HezuosheEntity> wrapper);
	
	List<HezuosheView> selectListView(@Param("ew") Wrapper<HezuosheEntity> wrapper);

	List<HezuosheView> selectListView(Pagination page,@Param("ew") Wrapper<HezuosheEntity> wrapper);

	
	HezuosheView selectView(@Param("ew") Wrapper<HezuosheEntity> wrapper);
	

}
