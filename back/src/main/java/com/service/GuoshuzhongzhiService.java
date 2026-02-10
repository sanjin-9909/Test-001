package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuoshuzhongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuoshuzhongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuoshuzhongzhiView;


/**
 * 果蔬种植
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface GuoshuzhongzhiService extends IService<GuoshuzhongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuoshuzhongzhiVO> selectListVO(Wrapper<GuoshuzhongzhiEntity> wrapper);
   	
   	GuoshuzhongzhiVO selectVO(@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);
   	
   	List<GuoshuzhongzhiView> selectListView(Wrapper<GuoshuzhongzhiEntity> wrapper);
   	
   	GuoshuzhongzhiView selectView(@Param("ew") Wrapper<GuoshuzhongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuoshuzhongzhiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GuoshuzhongzhiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GuoshuzhongzhiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GuoshuzhongzhiEntity> wrapper);



}

