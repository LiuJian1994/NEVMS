package com.cl.dao;

import com.cl.entity.CheliangweixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangweixiuView;


/**
 * 车辆维修
 * 
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface CheliangweixiuDao extends BaseMapper<CheliangweixiuEntity> {
	
	List<CheliangweixiuView> selectListView(@Param("ew") Wrapper<CheliangweixiuEntity> wrapper);

	List<CheliangweixiuView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangweixiuEntity> wrapper);
	
	CheliangweixiuView selectView(@Param("ew") Wrapper<CheliangweixiuEntity> wrapper);
	

}
