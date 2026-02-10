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


import com.dao.GenghuanjiluDao;
import com.entity.GenghuanjiluEntity;
import com.service.GenghuanjiluService;
import com.entity.vo.GenghuanjiluVO;
import com.entity.view.GenghuanjiluView;

@Service("genghuanjiluService")
public class GenghuanjiluServiceImpl extends ServiceImpl<GenghuanjiluDao, GenghuanjiluEntity> implements GenghuanjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GenghuanjiluEntity> page = this.selectPage(
                new Query<GenghuanjiluEntity>(params).getPage(),
                new EntityWrapper<GenghuanjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GenghuanjiluEntity> wrapper) {
		  Page<GenghuanjiluView> page =new Query<GenghuanjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GenghuanjiluVO> selectListVO(Wrapper<GenghuanjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GenghuanjiluVO selectVO(Wrapper<GenghuanjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GenghuanjiluView> selectListView(Wrapper<GenghuanjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GenghuanjiluView selectView(Wrapper<GenghuanjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
