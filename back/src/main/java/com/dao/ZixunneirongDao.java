package com.dao;

import com.entity.ZixunneirongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZixunneirongVO;
import com.entity.view.ZixunneirongView;


/**
 * 资讯内容
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface ZixunneirongDao extends BaseMapper<ZixunneirongEntity> {
	
	List<ZixunneirongVO> selectListVO(@Param("ew") Wrapper<ZixunneirongEntity> wrapper);
	
	ZixunneirongVO selectVO(@Param("ew") Wrapper<ZixunneirongEntity> wrapper);
	
	List<ZixunneirongView> selectListView(@Param("ew") Wrapper<ZixunneirongEntity> wrapper);

	List<ZixunneirongView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunneirongEntity> wrapper);

	
	ZixunneirongView selectView(@Param("ew") Wrapper<ZixunneirongEntity> wrapper);
	

}
