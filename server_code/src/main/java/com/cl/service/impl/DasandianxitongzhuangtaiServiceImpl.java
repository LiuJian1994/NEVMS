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


import com.cl.dao.DasandianxitongzhuangtaiDao;
import com.cl.entity.DasandianxitongzhuangtaiEntity;
import com.cl.service.DasandianxitongzhuangtaiService;
import com.cl.entity.view.DasandianxitongzhuangtaiView;

@Service("dasandianxitongzhuangtaiService")
public class DasandianxitongzhuangtaiServiceImpl extends ServiceImpl<DasandianxitongzhuangtaiDao, DasandianxitongzhuangtaiEntity> implements DasandianxitongzhuangtaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DasandianxitongzhuangtaiEntity> page = this.selectPage(
                new Query<DasandianxitongzhuangtaiEntity>(params).getPage(),
                new EntityWrapper<DasandianxitongzhuangtaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DasandianxitongzhuangtaiEntity> wrapper) {
		  Page<DasandianxitongzhuangtaiView> page =new Query<DasandianxitongzhuangtaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DasandianxitongzhuangtaiView> selectListView(Wrapper<DasandianxitongzhuangtaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DasandianxitongzhuangtaiView selectView(Wrapper<DasandianxitongzhuangtaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
