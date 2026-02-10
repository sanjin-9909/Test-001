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


import com.dao.ShujuchakanDao;
import com.entity.ShujuchakanEntity;
import com.service.ShujuchakanService;
import com.entity.vo.ShujuchakanVO;
import com.entity.view.ShujuchakanView;

@Service("shujuchakanService")
public class ShujuchakanServiceImpl extends ServiceImpl<ShujuchakanDao, ShujuchakanEntity> implements ShujuchakanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShujuchakanEntity> page = this.selectPage(
                new Query<ShujuchakanEntity>(params).getPage(),
                new EntityWrapper<ShujuchakanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShujuchakanEntity> wrapper) {
		  Page<ShujuchakanView> page =new Query<ShujuchakanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShujuchakanVO> selectListVO(Wrapper<ShujuchakanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShujuchakanVO selectVO(Wrapper<ShujuchakanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShujuchakanView> selectListView(Wrapper<ShujuchakanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShujuchakanView selectView(Wrapper<ShujuchakanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
