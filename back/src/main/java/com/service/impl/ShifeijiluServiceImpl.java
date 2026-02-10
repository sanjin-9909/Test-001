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


import com.dao.ShifeijiluDao;
import com.entity.ShifeijiluEntity;
import com.service.ShifeijiluService;
import com.entity.vo.ShifeijiluVO;
import com.entity.view.ShifeijiluView;

@Service("shifeijiluService")
public class ShifeijiluServiceImpl extends ServiceImpl<ShifeijiluDao, ShifeijiluEntity> implements ShifeijiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShifeijiluEntity> page = this.selectPage(
                new Query<ShifeijiluEntity>(params).getPage(),
                new EntityWrapper<ShifeijiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShifeijiluEntity> wrapper) {
		  Page<ShifeijiluView> page =new Query<ShifeijiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShifeijiluVO> selectListVO(Wrapper<ShifeijiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShifeijiluVO selectVO(Wrapper<ShifeijiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShifeijiluView> selectListView(Wrapper<ShifeijiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShifeijiluView selectView(Wrapper<ShifeijiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
