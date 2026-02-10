package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HezuosheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HezuosheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HezuosheView;


/**
 * 合作社
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface HezuosheService extends IService<HezuosheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HezuosheVO> selectListVO(Wrapper<HezuosheEntity> wrapper);
   	
   	HezuosheVO selectVO(@Param("ew") Wrapper<HezuosheEntity> wrapper);
   	
   	List<HezuosheView> selectListView(Wrapper<HezuosheEntity> wrapper);
   	
   	HezuosheView selectView(@Param("ew") Wrapper<HezuosheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HezuosheEntity> wrapper);

   	

}

