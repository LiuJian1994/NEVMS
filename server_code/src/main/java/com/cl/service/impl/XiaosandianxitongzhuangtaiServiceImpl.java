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


import com.cl.dao.XiaosandianxitongzhuangtaiDao;
import com.cl.entity.XiaosandianxitongzhuangtaiEntity;
import com.cl.service.XiaosandianxitongzhuangtaiService;
import com.cl.entity.view.XiaosandianxitongzhuangtaiView;

@Service("xiaosandianxitongzhuangtaiService")
public class XiaosandianxitongzhuangtaiServiceImpl extends ServiceImpl<XiaosandianxitongzhuangtaiDao, XiaosandianxitongzhuangtaiEntity> implements XiaosandianxitongzhuangtaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaosandianxitongzhuangtaiEntity> page = this.selectPage(
                new Query<XiaosandianxitongzhuangtaiEntity>(params).getPage(),
                new EntityWrapper<XiaosandianxitongzhuangtaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper) {
		  Page<XiaosandianxitongzhuangtaiView> page =new Query<XiaosandianxitongzhuangtaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaosandianxitongzhuangtaiView> selectListView(Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaosandianxitongzhuangtaiView selectView(Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
