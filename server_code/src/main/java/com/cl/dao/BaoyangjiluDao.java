package com.cl.dao;

import com.cl.entity.BaoyangjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaoyangjiluView;


/**
 * 保养记录
 * 
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface BaoyangjiluDao extends BaseMapper<BaoyangjiluEntity> {
	
	List<BaoyangjiluView> selectListView(@Param("ew") Wrapper<BaoyangjiluEntity> wrapper);

	List<BaoyangjiluView> selectListView(Pagination page,@Param("ew") Wrapper<BaoyangjiluEntity> wrapper);
	
	BaoyangjiluView selectView(@Param("ew") Wrapper<BaoyangjiluEntity> wrapper);
	

}
