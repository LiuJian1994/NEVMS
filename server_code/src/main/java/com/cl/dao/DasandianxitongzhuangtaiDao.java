package com.cl.dao;

import com.cl.entity.DasandianxitongzhuangtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DasandianxitongzhuangtaiView;


/**
 * 大三电系统状态
 * 
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface DasandianxitongzhuangtaiDao extends BaseMapper<DasandianxitongzhuangtaiEntity> {
	
	List<DasandianxitongzhuangtaiView> selectListView(@Param("ew") Wrapper<DasandianxitongzhuangtaiEntity> wrapper);

	List<DasandianxitongzhuangtaiView> selectListView(Pagination page,@Param("ew") Wrapper<DasandianxitongzhuangtaiEntity> wrapper);
	
	DasandianxitongzhuangtaiView selectView(@Param("ew") Wrapper<DasandianxitongzhuangtaiEntity> wrapper);
	

}
