package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShujuchakanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShujuchakanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujuchakanView;


/**
 * 数据查看
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public interface ShujuchakanService extends IService<ShujuchakanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShujuchakanVO> selectListVO(Wrapper<ShujuchakanEntity> wrapper);
   	
   	ShujuchakanVO selectVO(@Param("ew") Wrapper<ShujuchakanEntity> wrapper);
   	
   	List<ShujuchakanView> selectListView(Wrapper<ShujuchakanEntity> wrapper);
   	
   	ShujuchakanView selectView(@Param("ew") Wrapper<ShujuchakanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShujuchakanEntity> wrapper);

   	

}

