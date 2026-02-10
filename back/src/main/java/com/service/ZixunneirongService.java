package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZixunneirongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZixunneirongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunneirongView;


/**
 * 资讯内容
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
public interface ZixunneirongService extends IService<ZixunneirongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunneirongVO> selectListVO(Wrapper<ZixunneirongEntity> wrapper);
   	
   	ZixunneirongVO selectVO(@Param("ew") Wrapper<ZixunneirongEntity> wrapper);
   	
   	List<ZixunneirongView> selectListView(Wrapper<ZixunneirongEntity> wrapper);
   	
   	ZixunneirongView selectView(@Param("ew") Wrapper<ZixunneirongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunneirongEntity> wrapper);

   	

}

