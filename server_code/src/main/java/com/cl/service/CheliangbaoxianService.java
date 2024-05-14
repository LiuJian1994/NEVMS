package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheliangbaoxianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangbaoxianView;


/**
 * 车辆保险
 *
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface CheliangbaoxianService extends IService<CheliangbaoxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangbaoxianView> selectListView(Wrapper<CheliangbaoxianEntity> wrapper);
   	
   	CheliangbaoxianView selectView(@Param("ew") Wrapper<CheliangbaoxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangbaoxianEntity> wrapper);
   	

}

