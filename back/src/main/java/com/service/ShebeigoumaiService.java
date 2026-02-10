package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeigoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeigoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeigoumaiView;


/**
 * 设备购买
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface ShebeigoumaiService extends IService<ShebeigoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeigoumaiVO> selectListVO(Wrapper<ShebeigoumaiEntity> wrapper);
   	
   	ShebeigoumaiVO selectVO(@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);
   	
   	List<ShebeigoumaiView> selectListView(Wrapper<ShebeigoumaiEntity> wrapper);
   	
   	ShebeigoumaiView selectView(@Param("ew") Wrapper<ShebeigoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeigoumaiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShebeigoumaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShebeigoumaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShebeigoumaiEntity> wrapper);



}

