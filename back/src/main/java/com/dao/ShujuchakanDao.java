package com.dao;

import com.entity.ShujuchakanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShujuchakanVO;
import com.entity.view.ShujuchakanView;


/**
 * 数据查看
 * 
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface ShujuchakanDao extends BaseMapper<ShujuchakanEntity> {
	
	List<ShujuchakanVO> selectListVO(@Param("ew") Wrapper<ShujuchakanEntity> wrapper);
	
	ShujuchakanVO selectVO(@Param("ew") Wrapper<ShujuchakanEntity> wrapper);
	
	List<ShujuchakanView> selectListView(@Param("ew") Wrapper<ShujuchakanEntity> wrapper);

	List<ShujuchakanView> selectListView(Pagination page,@Param("ew") Wrapper<ShujuchakanEntity> wrapper);

	
	ShujuchakanView selectView(@Param("ew") Wrapper<ShujuchakanEntity> wrapper);
	

}
