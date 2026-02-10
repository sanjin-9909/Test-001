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


import com.dao.BaofeishenqingDao;
import com.entity.BaofeishenqingEntity;
import com.service.BaofeishenqingService;
import com.entity.vo.BaofeishenqingVO;
import com.entity.view.BaofeishenqingView;

@Service("baofeishenqingService")
public class BaofeishenqingServiceImpl extends ServiceImpl<BaofeishenqingDao, BaofeishenqingEntity> implements BaofeishenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaofeishenqingEntity> page = this.selectPage(
                new Query<BaofeishenqingEntity>(params).getPage(),
                new EntityWrapper<BaofeishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaofeishenqingEntity> wrapper) {
		  Page<BaofeishenqingView> page =new Query<BaofeishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BaofeishenqingVO> selectListVO(Wrapper<BaofeishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaofeishenqingVO selectVO(Wrapper<BaofeishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaofeishenqingView> selectListView(Wrapper<BaofeishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaofeishenqingView selectView(Wrapper<BaofeishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
