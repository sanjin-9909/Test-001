package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuzhangbaoxiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuzhangbaoxiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuzhangbaoxiuView;


/**
 * 故障报修
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface GuzhangbaoxiuService extends IService<GuzhangbaoxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuzhangbaoxiuVO> selectListVO(Wrapper<GuzhangbaoxiuEntity> wrapper);
   	
   	GuzhangbaoxiuVO selectVO(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
   	
   	List<GuzhangbaoxiuView> selectListView(Wrapper<GuzhangbaoxiuEntity> wrapper);
   	
   	GuzhangbaoxiuView selectView(@Param("ew") Wrapper<GuzhangbaoxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuzhangbaoxiuEntity> wrapper);

   	

}

