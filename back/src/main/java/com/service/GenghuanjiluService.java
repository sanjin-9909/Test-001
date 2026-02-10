package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GenghuanjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GenghuanjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GenghuanjiluView;


/**
 * 更换记录
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface GenghuanjiluService extends IService<GenghuanjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GenghuanjiluVO> selectListVO(Wrapper<GenghuanjiluEntity> wrapper);
   	
   	GenghuanjiluVO selectVO(@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);
   	
   	List<GenghuanjiluView> selectListView(Wrapper<GenghuanjiluEntity> wrapper);
   	
   	GenghuanjiluView selectView(@Param("ew") Wrapper<GenghuanjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GenghuanjiluEntity> wrapper);

   	

}

