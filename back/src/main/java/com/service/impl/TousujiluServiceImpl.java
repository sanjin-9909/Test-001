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


import com.dao.TousujiluDao;
import com.entity.TousujiluEntity;
import com.service.TousujiluService;
import com.entity.vo.TousujiluVO;
import com.entity.view.TousujiluView;

@Service("tousujiluService")
public class TousujiluServiceImpl extends ServiceImpl<TousujiluDao, TousujiluEntity> implements TousujiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TousujiluEntity> page = this.selectPage(
                new Query<TousujiluEntity>(params).getPage(),
                new EntityWrapper<TousujiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TousujiluEntity> wrapper) {
		  Page<TousujiluView> page =new Query<TousujiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TousujiluVO> selectListVO(Wrapper<TousujiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TousujiluVO selectVO(Wrapper<TousujiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TousujiluView> selectListView(Wrapper<TousujiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TousujiluView selectView(Wrapper<TousujiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
