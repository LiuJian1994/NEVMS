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


import com.cl.dao.DonglidianchixinxiDao;
import com.cl.entity.DonglidianchixinxiEntity;
import com.cl.service.DonglidianchixinxiService;
import com.cl.entity.view.DonglidianchixinxiView;

@Service("donglidianchixinxiService")
public class DonglidianchixinxiServiceImpl extends ServiceImpl<DonglidianchixinxiDao, DonglidianchixinxiEntity> implements DonglidianchixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DonglidianchixinxiEntity> page = this.selectPage(
                new Query<DonglidianchixinxiEntity>(params).getPage(),
                new EntityWrapper<DonglidianchixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DonglidianchixinxiEntity> wrapper) {
		  Page<DonglidianchixinxiView> page =new Query<DonglidianchixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DonglidianchixinxiView> selectListView(Wrapper<DonglidianchixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DonglidianchixinxiView selectView(Wrapper<DonglidianchixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
