package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaofeishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaofeishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaofeishenqingView;


/**
 * 报废申请
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface BaofeishenqingService extends IService<BaofeishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaofeishenqingVO> selectListVO(Wrapper<BaofeishenqingEntity> wrapper);
   	
   	BaofeishenqingVO selectVO(@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);
   	
   	List<BaofeishenqingView> selectListView(Wrapper<BaofeishenqingEntity> wrapper);
   	
   	BaofeishenqingView selectView(@Param("ew") Wrapper<BaofeishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaofeishenqingEntity> wrapper);

   	

}

