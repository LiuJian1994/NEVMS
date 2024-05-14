package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BaoyangjiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaoyangjiluView;


/**
 * 保养记录
 *
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface BaoyangjiluService extends IService<BaoyangjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaoyangjiluView> selectListView(Wrapper<BaoyangjiluEntity> wrapper);
   	
   	BaoyangjiluView selectView(@Param("ew") Wrapper<BaoyangjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaoyangjiluEntity> wrapper);
   	

}

