package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuoshudapengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuoshudapengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuoshudapengView;


/**
 * 果蔬大棚
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface GuoshudapengService extends IService<GuoshudapengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuoshudapengVO> selectListVO(Wrapper<GuoshudapengEntity> wrapper);
   	
   	GuoshudapengVO selectVO(@Param("ew") Wrapper<GuoshudapengEntity> wrapper);
   	
   	List<GuoshudapengView> selectListView(Wrapper<GuoshudapengEntity> wrapper);
   	
   	GuoshudapengView selectView(@Param("ew") Wrapper<GuoshudapengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuoshudapengEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GuoshudapengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GuoshudapengEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GuoshudapengEntity> wrapper);



}

