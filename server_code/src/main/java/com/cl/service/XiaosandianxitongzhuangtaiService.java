package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaosandianxitongzhuangtaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaosandianxitongzhuangtaiView;


/**
 * 小三电系统状态
 *
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface XiaosandianxitongzhuangtaiService extends IService<XiaosandianxitongzhuangtaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaosandianxitongzhuangtaiView> selectListView(Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper);
   	
   	XiaosandianxitongzhuangtaiView selectView(@Param("ew") Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaosandianxitongzhuangtaiEntity> wrapper);
   	

}

