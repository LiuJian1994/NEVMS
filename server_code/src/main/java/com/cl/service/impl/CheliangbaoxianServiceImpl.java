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


import com.cl.dao.CheliangbaoxianDao;
import com.cl.entity.CheliangbaoxianEntity;
import com.cl.service.CheliangbaoxianService;
import com.cl.entity.view.CheliangbaoxianView;

@Service("cheliangbaoxianService")
public class CheliangbaoxianServiceImpl extends ServiceImpl<CheliangbaoxianDao, CheliangbaoxianEntity> implements CheliangbaoxianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangbaoxianEntity> page = this.selectPage(
                new Query<CheliangbaoxianEntity>(params).getPage(),
                new EntityWrapper<CheliangbaoxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangbaoxianEntity> wrapper) {
		  Page<CheliangbaoxianView> page =new Query<CheliangbaoxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CheliangbaoxianView> selectListView(Wrapper<CheliangbaoxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangbaoxianView selectView(Wrapper<CheliangbaoxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
