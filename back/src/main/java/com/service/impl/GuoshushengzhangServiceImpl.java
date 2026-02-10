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


import com.dao.GuoshushengzhangDao;
import com.entity.GuoshushengzhangEntity;
import com.service.GuoshushengzhangService;
import com.entity.vo.GuoshushengzhangVO;
import com.entity.view.GuoshushengzhangView;

@Service("guoshushengzhangService")
public class GuoshushengzhangServiceImpl extends ServiceImpl<GuoshushengzhangDao, GuoshushengzhangEntity> implements GuoshushengzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuoshushengzhangEntity> page = this.selectPage(
                new Query<GuoshushengzhangEntity>(params).getPage(),
                new EntityWrapper<GuoshushengzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuoshushengzhangEntity> wrapper) {
		  Page<GuoshushengzhangView> page =new Query<GuoshushengzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuoshushengzhangVO> selectListVO(Wrapper<GuoshushengzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuoshushengzhangVO selectVO(Wrapper<GuoshushengzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuoshushengzhangView> selectListView(Wrapper<GuoshushengzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuoshushengzhangView selectView(Wrapper<GuoshushengzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GuoshushengzhangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GuoshushengzhangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GuoshushengzhangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
