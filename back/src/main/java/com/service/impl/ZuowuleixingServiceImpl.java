package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuowuleixingDao;
import com.entity.ZuowuleixingEntity;
import com.service.ZuowuleixingService;
import com.entity.vo.ZuowuleixingVO;
import com.entity.view.ZuowuleixingView;

@Service("zuowuleixingService")
public class ZuowuleixingServiceImpl extends ServiceImpl<ZuowuleixingDao, ZuowuleixingEntity> implements ZuowuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuowuleixingEntity> page = this.selectPage(
                new Query<ZuowuleixingEntity>(params).getPage(),
                new EntityWrapper<ZuowuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuowuleixingEntity> wrapper) {
		  Page<ZuowuleixingView> page =new Query<ZuowuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZuowuleixingVO> selectListVO(Wrapper<ZuowuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuowuleixingVO selectVO(Wrapper<ZuowuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuowuleixingView> selectListView(Wrapper<ZuowuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuowuleixingView selectView(Wrapper<ZuowuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
