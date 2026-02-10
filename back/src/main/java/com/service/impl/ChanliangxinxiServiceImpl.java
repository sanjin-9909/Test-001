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


import com.dao.ChanliangxinxiDao;
import com.entity.ChanliangxinxiEntity;
import com.service.ChanliangxinxiService;
import com.entity.vo.ChanliangxinxiVO;
import com.entity.view.ChanliangxinxiView;

@Service("chanliangxinxiService")
public class ChanliangxinxiServiceImpl extends ServiceImpl<ChanliangxinxiDao, ChanliangxinxiEntity> implements ChanliangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChanliangxinxiEntity> page = this.selectPage(
                new Query<ChanliangxinxiEntity>(params).getPage(),
                new EntityWrapper<ChanliangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChanliangxinxiEntity> wrapper) {
		  Page<ChanliangxinxiView> page =new Query<ChanliangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChanliangxinxiVO> selectListVO(Wrapper<ChanliangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChanliangxinxiVO selectVO(Wrapper<ChanliangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChanliangxinxiView> selectListView(Wrapper<ChanliangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChanliangxinxiView selectView(Wrapper<ChanliangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
