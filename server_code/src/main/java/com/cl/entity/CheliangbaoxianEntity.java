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
 * 车辆保险
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@TableName("cheliangbaoxian")
public class CheliangbaoxianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CheliangbaoxianEntity() {
		
	}
	
	public CheliangbaoxianEntity(T t) {
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
	 * 保险类型
	 */
					
	private String baoxianleixing;
	
	/**
	 * 保单号
	 */
					
	private String baodanhao;
	
	/**
	 * 被保险人
	 */
					
	private String beibaoxianren;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 保险生效日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baoxianshengxiaoriqi;
	
	/**
	 * 保险截止日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baoxianjiezhiriqi;
	
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
	 * 设置：保险类型
	 */
	public void setBaoxianleixing(String baoxianleixing) {
		this.baoxianleixing = baoxianleixing;
	}
	/**
	 * 获取：保险类型
	 */
	public String getBaoxianleixing() {
		return baoxianleixing;
	}
	/**
	 * 设置：保单号
	 */
	public void setBaodanhao(String baodanhao) {
		this.baodanhao = baodanhao;
	}
	/**
	 * 获取：保单号
	 */
	public String getBaodanhao() {
		return baodanhao;
	}
	/**
	 * 设置：被保险人
	 */
	public void setBeibaoxianren(String beibaoxianren) {
		this.beibaoxianren = beibaoxianren;
	}
	/**
	 * 获取：被保险人
	 */
	public String getBeibaoxianren() {
		return beibaoxianren;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：保险生效日期
	 */
	public void setBaoxianshengxiaoriqi(Date baoxianshengxiaoriqi) {
		this.baoxianshengxiaoriqi = baoxianshengxiaoriqi;
	}
	/**
	 * 获取：保险生效日期
	 */
	public Date getBaoxianshengxiaoriqi() {
		return baoxianshengxiaoriqi;
	}
	/**
	 * 设置：保险截止日期
	 */
	public void setBaoxianjiezhiriqi(Date baoxianjiezhiriqi) {
		this.baoxianjiezhiriqi = baoxianjiezhiriqi;
	}
	/**
	 * 获取：保险截止日期
	 */
	public Date getBaoxianjiezhiriqi() {
		return baoxianjiezhiriqi;
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
