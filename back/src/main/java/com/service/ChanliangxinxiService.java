package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChanliangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChanliangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanliangxinxiView;


/**
 * 产量信息
 *
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public interface ChanliangxinxiService extends IService<ChanliangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChanliangxinxiVO> selectListVO(Wrapper<ChanliangxinxiEntity> wrapper);
   	
   	ChanliangxinxiVO selectVO(@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);
   	
   	List<ChanliangxinxiView> selectListView(Wrapper<ChanliangxinxiEntity> wrapper);
   	
   	ChanliangxinxiView selectView(@Param("ew") Wrapper<ChanliangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChanliangxinxiEntity> wrapper);

   	

}

