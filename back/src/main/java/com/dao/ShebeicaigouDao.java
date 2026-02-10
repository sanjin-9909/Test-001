package com.dao;

import com.entity.ShebeicaigouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeicaigouVO;
import com.entity.view.ShebeicaigouView;


/**
 * 设备采购
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface ShebeicaigouDao extends BaseMapper<ShebeicaigouEntity> {
	
	List<ShebeicaigouVO> selectListVO(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
	
	ShebeicaigouVO selectVO(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
	
	List<ShebeicaigouView> selectListView(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);

	List<ShebeicaigouView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);

	
	ShebeicaigouView selectView(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);



}
