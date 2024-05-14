package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.CheliangweixiuDao;
import com.cl.entity.CheliangweixiuEntity;
import com.cl.service.CheliangweixiuService;
import com.cl.entity.view.CheliangweixiuView;

@Service("cheliangweixiuService")
public class CheliangweixiuServiceImpl extends ServiceImpl<CheliangweixiuDao, CheliangweixiuEntity> implements CheliangweixiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangweixiuEntity> page = this.selectPage(
                new Query<CheliangweixiuEntity>(params).getPage(),
                new EntityWrapper<CheliangweixiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangweixiuEntity> wrapper) {
		  Page<CheliangweixiuView> page =new Query<CheliangweixiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CheliangweixiuView> selectListView(Wrapper<CheliangweixiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangweixiuView selectView(Wrapper<CheliangweixiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
