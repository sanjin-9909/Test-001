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


import com.dao.GuzhangbaoxiuDao;
import com.entity.GuzhangbaoxiuEntity;
import com.service.GuzhangbaoxiuService;
import com.entity.vo.GuzhangbaoxiuVO;
import com.entity.view.GuzhangbaoxiuView;

@Service("guzhangbaoxiuService")
public class GuzhangbaoxiuServiceImpl extends ServiceImpl<GuzhangbaoxiuDao, GuzhangbaoxiuEntity> implements GuzhangbaoxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuzhangbaoxiuEntity> page = this.selectPage(
                new Query<GuzhangbaoxiuEntity>(params).getPage(),
                new EntityWrapper<GuzhangbaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuzhangbaoxiuEntity> wrapper) {
		  Page<GuzhangbaoxiuView> page =new Query<GuzhangbaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuzhangbaoxiuVO> selectListVO(Wrapper<GuzhangbaoxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuzhangbaoxiuVO selectVO(Wrapper<GuzhangbaoxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuzhangbaoxiuView> selectListView(Wrapper<GuzhangbaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuzhangbaoxiuView selectView(Wrapper<GuzhangbaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
