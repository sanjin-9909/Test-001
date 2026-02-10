package com.dao;

import com.entity.ChanliangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChanliangxinxiVO;
import com.entity.view.ChanliangxinxiView;


/**
 * 产量信息
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface ChanliangxinxiDao extends BaseMapper<ChanliangxinxiEntity> {
	
	List<ChanliangxinxiVO> selectListVO(@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);
	
	ChanliangxinxiVO selectVO(@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);
	
	List<ChanliangxinxiView> selectListView(@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);

	List<ChanliangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);

	
	ChanliangxinxiView selectView(@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);
	

}
