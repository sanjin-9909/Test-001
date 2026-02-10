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


import com.dao.GuangaijiluDao;
import com.entity.GuangaijiluEntity;
import com.service.GuangaijiluService;
import com.entity.vo.GuangaijiluVO;
import com.entity.view.GuangaijiluView;

@Service("guangaijiluService")
public class GuangaijiluServiceImpl extends ServiceImpl<GuangaijiluDao, GuangaijiluEntity> implements GuangaijiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuangaijiluEntity> page = this.selectPage(
                new Query<GuangaijiluEntity>(params).getPage(),
                new EntityWrapper<GuangaijiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuangaijiluEntity> wrapper) {
		  Page<GuangaijiluView> page =new Query<GuangaijiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuangaijiluVO> selectListVO(Wrapper<GuangaijiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuangaijiluVO selectVO(Wrapper<GuangaijiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuangaijiluView> selectListView(Wrapper<GuangaijiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuangaijiluView selectView(Wrapper<GuangaijiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
