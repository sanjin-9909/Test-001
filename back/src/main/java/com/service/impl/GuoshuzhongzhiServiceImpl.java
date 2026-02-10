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


import com.dao.GuoshuzhongzhiDao;
import com.entity.GuoshuzhongzhiEntity;
import com.service.GuoshuzhongzhiService;
import com.entity.vo.GuoshuzhongzhiVO;
import com.entity.view.GuoshuzhongzhiView;

@Service("guoshuzhongzhiService")
public class GuoshuzhongzhiServiceImpl extends ServiceImpl<GuoshuzhongzhiDao, GuoshuzhongzhiEntity> implements GuoshuzhongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuoshuzhongzhiEntity> page = this.selectPage(
                new Query<GuoshuzhongzhiEntity>(params).getPage(),
                new EntityWrapper<GuoshuzhongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuoshuzhongzhiEntity> wrapper) {
		  Page<GuoshuzhongzhiView> page =new Query<GuoshuzhongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuoshuzhongzhiVO> selectListVO(Wrapper<GuoshuzhongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuoshuzhongzhiVO selectVO(Wrapper<GuoshuzhongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuoshuzhongzhiView> selectListView(Wrapper<GuoshuzhongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuoshuzhongzhiView selectView(Wrapper<GuoshuzhongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GuoshuzhongzhiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GuoshuzhongzhiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GuoshuzhongzhiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
