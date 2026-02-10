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


import com.dao.ZixunneirongDao;
import com.entity.ZixunneirongEntity;
import com.service.ZixunneirongService;
import com.entity.vo.ZixunneirongVO;
import com.entity.view.ZixunneirongView;

@Service("zixunneirongService")
public class ZixunneirongServiceImpl extends ServiceImpl<ZixunneirongDao, ZixunneirongEntity> implements ZixunneirongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunneirongEntity> page = this.selectPage(
                new Query<ZixunneirongEntity>(params).getPage(),
                new EntityWrapper<ZixunneirongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunneirongEntity> wrapper) {
		  Page<ZixunneirongView> page =new Query<ZixunneirongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZixunneirongVO> selectListVO(Wrapper<ZixunneirongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZixunneirongVO selectVO(Wrapper<ZixunneirongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZixunneirongView> selectListView(Wrapper<ZixunneirongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunneirongView selectView(Wrapper<ZixunneirongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
