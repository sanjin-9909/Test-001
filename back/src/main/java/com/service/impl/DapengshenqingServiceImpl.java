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


import com.dao.DapengshenqingDao;
import com.entity.DapengshenqingEntity;
import com.service.DapengshenqingService;
import com.entity.vo.DapengshenqingVO;
import com.entity.view.DapengshenqingView;

@Service("dapengshenqingService")
public class DapengshenqingServiceImpl extends ServiceImpl<DapengshenqingDao, DapengshenqingEntity> implements DapengshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DapengshenqingEntity> page = this.selectPage(
                new Query<DapengshenqingEntity>(params).getPage(),
                new EntityWrapper<DapengshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DapengshenqingEntity> wrapper) {
		  Page<DapengshenqingView> page =new Query<DapengshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DapengshenqingVO> selectListVO(Wrapper<DapengshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DapengshenqingVO selectVO(Wrapper<DapengshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DapengshenqingView> selectListView(Wrapper<DapengshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DapengshenqingView selectView(Wrapper<DapengshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<DapengshenqingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<DapengshenqingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<DapengshenqingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
