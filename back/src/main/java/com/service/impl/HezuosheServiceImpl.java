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


import com.dao.HezuosheDao;
import com.entity.HezuosheEntity;
import com.service.HezuosheService;
import com.entity.vo.HezuosheVO;
import com.entity.view.HezuosheView;

@Service("hezuosheService")
public class HezuosheServiceImpl extends ServiceImpl<HezuosheDao, HezuosheEntity> implements HezuosheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HezuosheEntity> page = this.selectPage(
                new Query<HezuosheEntity>(params).getPage(),
                new EntityWrapper<HezuosheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HezuosheEntity> wrapper) {
		  Page<HezuosheView> page =new Query<HezuosheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<HezuosheVO> selectListVO(Wrapper<HezuosheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HezuosheVO selectVO(Wrapper<HezuosheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HezuosheView> selectListView(Wrapper<HezuosheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HezuosheView selectView(Wrapper<HezuosheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
