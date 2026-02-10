package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TixingjianxiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TixingjianxiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TixingjianxiuView;


/**
 * 提醒检修
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface TixingjianxiuService extends IService<TixingjianxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TixingjianxiuVO> selectListVO(Wrapper<TixingjianxiuEntity> wrapper);
   	
   	TixingjianxiuVO selectVO(@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);
   	
   	List<TixingjianxiuView> selectListView(Wrapper<TixingjianxiuEntity> wrapper);
   	
   	TixingjianxiuView selectView(@Param("ew") Wrapper<TixingjianxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TixingjianxiuEntity> wrapper);

   	

}

