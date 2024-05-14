package com.cl.dao;

import com.cl.entity.XiaosandianxitongzhuangtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaosandianxitongzhuangtaiView;


/**
 * 小三电系统状态
 * 
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface XiaosandianxitongzhuangtaiDao extends BaseMapper<XiaosandianxitongzhuangtaiEntity> {
	
	List<XiaosandianxitongzhuangtaiView> selectListView(@Param("ew") Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper);

	List<XiaosandianxitongzhuangtaiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper);
	
	XiaosandianxitongzhuangtaiView selectView(@Param("ew") Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper);
	

}
