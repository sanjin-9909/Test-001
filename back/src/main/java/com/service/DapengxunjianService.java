package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DapengxunjianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DapengxunjianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DapengxunjianView;


/**
 * 大棚巡检
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
public interface DapengxunjianService extends IService<DapengxunjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DapengxunjianVO> selectListVO(Wrapper<DapengxunjianEntity> wrapper);
   	
   	DapengxunjianVO selectVO(@Param("ew") Wrapper<DapengxunjianEntity> wrapper);
   	
   	List<DapengxunjianView> selectListView(Wrapper<DapengxunjianEntity> wrapper);
   	
   	DapengxunjianView selectView(@Param("ew") Wrapper<DapengxunjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DapengxunjianEntity> wrapper);

   	

}

