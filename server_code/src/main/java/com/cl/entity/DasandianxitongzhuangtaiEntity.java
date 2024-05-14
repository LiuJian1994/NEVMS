package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 大三电系统状态
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@TableName("dasandianxitongzhuangtai")
public class DasandianxitongzhuangtaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DasandianxitongzhuangtaiEntity() {
		
	}
	
	public DasandianxitongzhuangtaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 车辆图片
	 */
					
	private String cheliangtupian;
	
	/**
	 * 车牌号
	 */
					
	private String chepaihao;
	
	/**
	 * 驱动电机
	 */
					
	private String qudongdianji;
	
	/**
	 * 动力电池
	 */
					
	private String donglidianchi;
	
	/**
	 * 电控系统
	 */
					
	private String diankongxitong;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：车辆图片
	 */
	public void setCheliangtupian(String cheliangtupian) {
		this.cheliangtupian = cheliangtupian;
	}
	/**
	 * 获取：车辆图片
	 */
	public String getCheliangtupian() {
		return cheliangtupian;
	}
	/**
	 * 设置：车牌号
	 */
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	/**
	 * 获取：车牌号
	 */
	public String getChepaihao() {
		return chepaihao;
	}
	/**
	 * 设置：驱动电机
	 */
	public void setQudongdianji(String qudongdianji) {
		this.qudongdianji = qudongdianji;
	}
	/**
	 * 获取：驱动电机
	 */
	public String getQudongdianji() {
		return qudongdianji;
	}
	/**
	 * 设置：动力电池
	 */
	public void setDonglidianchi(String donglidianchi) {
		this.donglidianchi = donglidianchi;
	}
	/**
	 * 获取：动力电池
	 */
	public String getDonglidianchi() {
		return donglidianchi;
	}
	/**
	 * 设置：电控系统
	 */
	public void setDiankongxitong(String diankongxitong) {
		this.diankongxitong = diankongxitong;
	}
	/**
	 * 获取：电控系统
	 */
	public String getDiankongxitong() {
		return diankongxitong;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}

}
