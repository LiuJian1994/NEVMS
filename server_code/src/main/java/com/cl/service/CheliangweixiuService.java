package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheliangweixiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangweixiuView;


/**
 * 车辆维修
 *
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface CheliangweixiuService extends IService<CheliangweixiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangweixiuView> selectListView(Wrapper<CheliangweixiuEntity> wrapper);
   	
   	CheliangweixiuView selectView(@Param("ew") Wrapper<CheliangweixiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangweixiuEntity> wrapper);
   	

}

