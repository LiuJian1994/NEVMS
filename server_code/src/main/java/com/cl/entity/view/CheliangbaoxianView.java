package com.cl.entity.view;

import com.cl.entity.CheliangbaoxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 车辆保险
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@TableName("cheliangbaoxian")
public class CheliangbaoxianView  extends CheliangbaoxianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheliangbaoxianView(){
	}
 
 	public CheliangbaoxianView(CheliangbaoxianEntity cheliangbaoxianEntity){
 	try {
			BeanUtils.copyProperties(this, cheliangbaoxianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
