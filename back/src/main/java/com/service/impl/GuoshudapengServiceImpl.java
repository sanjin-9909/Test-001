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


import com.dao.GuoshudapengDao;
import com.entity.GuoshudapengEntity;
import com.service.GuoshudapengService;
import com.entity.vo.GuoshudapengVO;
import com.entity.view.GuoshudapengView;

@Service("guoshudapengService")
public class GuoshudapengServiceImpl extends ServiceImpl<GuoshudapengDao, GuoshudapengEntity> implements GuoshudapengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuoshudapengEntity> page = this.selectPage(
                new Query<GuoshudapengEntity>(params).getPage(),
                new EntityWrapper<GuoshudapengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuoshudapengEntity> wrapper) {
		  Page<GuoshudapengView> page =new Query<GuoshudapengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuoshudapengVO> selectListVO(Wrapper<GuoshudapengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuoshudapengVO selectVO(Wrapper<GuoshudapengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuoshudapengView> selectListView(Wrapper<GuoshudapengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuoshudapengView selectView(Wrapper<GuoshudapengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GuoshudapengEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GuoshudapengEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GuoshudapengEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
