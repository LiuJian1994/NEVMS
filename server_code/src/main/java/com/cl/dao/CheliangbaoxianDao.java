package com.cl.dao;

import com.cl.entity.CheliangbaoxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangbaoxianView;


/**
 * 车辆保险
 * 
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface CheliangbaoxianDao extends BaseMapper<CheliangbaoxianEntity> {
	
	List<CheliangbaoxianView> selectListView(@Param("ew") Wrapper<CheliangbaoxianEntity> wrapper);

	List<CheliangbaoxianView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangbaoxianEntity> wrapper);
	
	CheliangbaoxianView selectView(@Param("ew") Wrapper<CheliangbaoxianEntity> wrapper);
	

}
