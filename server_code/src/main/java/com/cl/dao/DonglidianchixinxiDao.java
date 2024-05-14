package com.cl.dao;

import com.cl.entity.DonglidianchixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DonglidianchixinxiView;


/**
 * 动力电池信息
 * 
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface DonglidianchixinxiDao extends BaseMapper<DonglidianchixinxiEntity> {
	
	List<DonglidianchixinxiView> selectListView(@Param("ew") Wrapper<DonglidianchixinxiEntity> wrapper);

	List<DonglidianchixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DonglidianchixinxiEntity> wrapper);
	
	DonglidianchixinxiView selectView(@Param("ew") Wrapper<DonglidianchixinxiEntity> wrapper);
	

}
