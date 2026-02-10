package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuangaijiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuangaijiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuangaijiluView;


/**
 * 灌溉记录
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface GuangaijiluService extends IService<GuangaijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuangaijiluVO> selectListVO(Wrapper<GuangaijiluEntity> wrapper);
   	
   	GuangaijiluVO selectVO(@Param("ew") Wrapper<GuangaijiluEntity> wrapper);
   	
   	List<GuangaijiluView> selectListView(Wrapper<GuangaijiluEntity> wrapper);
   	
   	GuangaijiluView selectView(@Param("ew") Wrapper<GuangaijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuangaijiluEntity> wrapper);

   	

}

