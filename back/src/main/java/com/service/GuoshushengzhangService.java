package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuoshushengzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuoshushengzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuoshushengzhangView;


/**
 * 果蔬生长
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface GuoshushengzhangService extends IService<GuoshushengzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuoshushengzhangVO> selectListVO(Wrapper<GuoshushengzhangEntity> wrapper);
   	
   	GuoshushengzhangVO selectVO(@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);
   	
   	List<GuoshushengzhangView> selectListView(Wrapper<GuoshushengzhangEntity> wrapper);
   	
   	GuoshushengzhangView selectView(@Param("ew") Wrapper<GuoshushengzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuoshushengzhangEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GuoshushengzhangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GuoshushengzhangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GuoshushengzhangEntity> wrapper);



}

