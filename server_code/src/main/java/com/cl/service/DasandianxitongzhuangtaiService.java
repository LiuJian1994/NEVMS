package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DasandianxitongzhuangtaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DasandianxitongzhuangtaiView;


/**
 * 大三电系统状态
 *
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
public interface DasandianxitongzhuangtaiService extends IService<DasandianxitongzhuangtaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DasandianxitongzhuangtaiView> selectListView(Wrapper<DasandianxitongzhuangtaiEntity> wrapper);
   	
   	DasandianxitongzhuangtaiView selectView(@Param("ew") Wrapper<DasandianxitongzhuangtaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DasandianxitongzhuangtaiEntity> wrapper);
   	

}

