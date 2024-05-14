package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DonglidianchixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DonglidianchixinxiView;


/**
 * 动力电池信息
 *
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface DonglidianchixinxiService extends IService<DonglidianchixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DonglidianchixinxiView> selectListView(Wrapper<DonglidianchixinxiEntity> wrapper);
   	
   	DonglidianchixinxiView selectView(@Param("ew") Wrapper<DonglidianchixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DonglidianchixinxiEntity> wrapper);
   	

}

