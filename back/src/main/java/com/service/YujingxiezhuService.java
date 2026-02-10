package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YujingxiezhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YujingxiezhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YujingxiezhuView;


/**
 * 预警协助
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface YujingxiezhuService extends IService<YujingxiezhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YujingxiezhuVO> selectListVO(Wrapper<YujingxiezhuEntity> wrapper);
   	
   	YujingxiezhuVO selectVO(@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);
   	
   	List<YujingxiezhuView> selectListView(Wrapper<YujingxiezhuEntity> wrapper);
   	
   	YujingxiezhuView selectView(@Param("ew") Wrapper<YujingxiezhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YujingxiezhuEntity> wrapper);

   	

}

