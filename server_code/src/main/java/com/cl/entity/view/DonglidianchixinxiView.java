package com.cl.entity.view;

import com.cl.entity.DonglidianchixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 动力电池信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@TableName("donglidianchixinxi")
public class DonglidianchixinxiView  extends DonglidianchixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DonglidianchixinxiView(){
	}
 
 	public DonglidianchixinxiView(DonglidianchixinxiEntity donglidianchixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, donglidianchixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
