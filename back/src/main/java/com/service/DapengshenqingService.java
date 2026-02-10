package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DapengshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DapengshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DapengshenqingView;


/**
 * 大棚申请
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface DapengshenqingService extends IService<DapengshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DapengshenqingVO> selectListVO(Wrapper<DapengshenqingEntity> wrapper);
   	
   	DapengshenqingVO selectVO(@Param("ew") Wrapper<DapengshenqingEntity> wrapper);
   	
   	List<DapengshenqingView> selectListView(Wrapper<DapengshenqingEntity> wrapper);
   	
   	DapengshenqingView selectView(@Param("ew") Wrapper<DapengshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DapengshenqingEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<DapengshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<DapengshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<DapengshenqingEntity> wrapper);



}

