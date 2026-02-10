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


import com.dao.TixingjianxiuDao;
import com.entity.TixingjianxiuEntity;
import com.service.TixingjianxiuService;
import com.entity.vo.TixingjianxiuVO;
import com.entity.view.TixingjianxiuView;

@Service("tixingjianxiuService")
public class TixingjianxiuServiceImpl extends ServiceImpl<TixingjianxiuDao, TixingjianxiuEntity> implements TixingjianxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TixingjianxiuEntity> page = this.selectPage(
                new Query<TixingjianxiuEntity>(params).getPage(),
                new EntityWrapper<TixingjianxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TixingjianxiuEntity> wrapper) {
		  Page<TixingjianxiuView> page =new Query<TixingjianxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TixingjianxiuVO> selectListVO(Wrapper<TixingjianxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TixingjianxiuVO selectVO(Wrapper<TixingjianxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TixingjianxiuView> selectListView(Wrapper<TixingjianxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TixingjianxiuView selectView(Wrapper<TixingjianxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
