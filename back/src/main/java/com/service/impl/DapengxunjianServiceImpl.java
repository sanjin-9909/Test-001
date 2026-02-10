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


import com.dao.DapengxunjianDao;
import com.entity.DapengxunjianEntity;
import com.service.DapengxunjianService;
import com.entity.vo.DapengxunjianVO;
import com.entity.view.DapengxunjianView;

@Service("dapengxunjianService")
public class DapengxunjianServiceImpl extends ServiceImpl<DapengxunjianDao, DapengxunjianEntity> implements DapengxunjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DapengxunjianEntity> page = this.selectPage(
                new Query<DapengxunjianEntity>(params).getPage(),
                new EntityWrapper<DapengxunjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DapengxunjianEntity> wrapper) {
		  Page<DapengxunjianView> page =new Query<DapengxunjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DapengxunjianVO> selectListVO(Wrapper<DapengxunjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DapengxunjianVO selectVO(Wrapper<DapengxunjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DapengxunjianView> selectListView(Wrapper<DapengxunjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DapengxunjianView selectView(Wrapper<DapengxunjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
