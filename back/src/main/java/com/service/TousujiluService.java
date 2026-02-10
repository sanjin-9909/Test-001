package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TousujiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TousujiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TousujiluView;


/**
 * 投诉记录
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface TousujiluService extends IService<TousujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TousujiluVO> selectListVO(Wrapper<TousujiluEntity> wrapper);
   	
   	TousujiluVO selectVO(@Param("ew") Wrapper<TousujiluEntity> wrapper);
   	
   	List<TousujiluView> selectListView(Wrapper<TousujiluEntity> wrapper);
   	
   	TousujiluView selectView(@Param("ew") Wrapper<TousujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TousujiluEntity> wrapper);

   	

}

