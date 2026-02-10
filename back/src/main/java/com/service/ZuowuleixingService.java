package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuowuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuowuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuowuleixingView;


/**
 * 作物类型
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface ZuowuleixingService extends IService<ZuowuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuowuleixingVO> selectListVO(Wrapper<ZuowuleixingEntity> wrapper);
   	
   	ZuowuleixingVO selectVO(@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);
   	
   	List<ZuowuleixingView> selectListView(Wrapper<ZuowuleixingEntity> wrapper);
   	
   	ZuowuleixingView selectView(@Param("ew") Wrapper<ZuowuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuowuleixingEntity> wrapper);

   	

}

