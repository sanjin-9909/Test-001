package com.dao;

import com.entity.JishurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JishurenyuanVO;
import com.entity.view.JishurenyuanView;


/**
 * 技术人员
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface JishurenyuanDao extends BaseMapper<JishurenyuanEntity> {
	
	List<JishurenyuanVO> selectListVO(@Param("ew") Wrapper<JishurenyuanEntity> wrapper);
	
	JishurenyuanVO selectVO(@Param("ew") Wrapper<JishurenyuanEntity> wrapper);
	
	List<JishurenyuanView> selectListView(@Param("ew") Wrapper<JishurenyuanEntity> wrapper);

	List<JishurenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JishurenyuanEntity> wrapper);

	
	JishurenyuanView selectView(@Param("ew") Wrapper<JishurenyuanEntity> wrapper);
	

}
