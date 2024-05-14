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


import com.cl.dao.BaoyangjiluDao;
import com.cl.entity.BaoyangjiluEntity;
import com.cl.service.BaoyangjiluService;
import com.cl.entity.view.BaoyangjiluView;

@Service("baoyangjiluService")
public class BaoyangjiluServiceImpl extends ServiceImpl<BaoyangjiluDao, BaoyangjiluEntity> implements BaoyangjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaoyangjiluEntity> page = this.selectPage(
                new Query<BaoyangjiluEntity>(params).getPage(),
                new EntityWrapper<BaoyangjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaoyangjiluEntity> wrapper) {
		  Page<BaoyangjiluView> page =new Query<BaoyangjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BaoyangjiluView> selectListView(Wrapper<BaoyangjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaoyangjiluView selectView(Wrapper<BaoyangjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
