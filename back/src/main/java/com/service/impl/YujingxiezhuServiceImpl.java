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


import com.dao.YujingxiezhuDao;
import com.entity.YujingxiezhuEntity;
import com.service.YujingxiezhuService;
import com.entity.vo.YujingxiezhuVO;
import com.entity.view.YujingxiezhuView;

@Service("yujingxiezhuService")
public class YujingxiezhuServiceImpl extends ServiceImpl<YujingxiezhuDao, YujingxiezhuEntity> implements YujingxiezhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YujingxiezhuEntity> page = this.selectPage(
                new Query<YujingxiezhuEntity>(params).getPage(),
                new EntityWrapper<YujingxiezhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YujingxiezhuEntity> wrapper) {
		  Page<YujingxiezhuView> page =new Query<YujingxiezhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YujingxiezhuVO> selectListVO(Wrapper<YujingxiezhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YujingxiezhuVO selectVO(Wrapper<YujingxiezhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YujingxiezhuView> selectListView(Wrapper<YujingxiezhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YujingxiezhuView selectView(Wrapper<YujingxiezhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
