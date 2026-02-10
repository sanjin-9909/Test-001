package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShifeijiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShifeijiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShifeijiluView;


/**
 * 施肥记录
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface ShifeijiluService extends IService<ShifeijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShifeijiluVO> selectListVO(Wrapper<ShifeijiluEntity> wrapper);
   	
   	ShifeijiluVO selectVO(@Param("ew") Wrapper<ShifeijiluEntity> wrapper);
   	
   	List<ShifeijiluView> selectListView(Wrapper<ShifeijiluEntity> wrapper);
   	
   	ShifeijiluView selectView(@Param("ew") Wrapper<ShifeijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShifeijiluEntity> wrapper);

   	

}

