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
 * 保养记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@TableName("baoyangjilu")
public class BaoyangjiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BaoyangjiluEntity() {
		
	}
	
	public BaoyangjiluEntity(T t) {
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
	 * 车辆颜色
	 */
					
	private String cheliangyanse;
	
	/**
	 * 保养项目
	 */
					
	private String baoyangxiangmu;
	
	/**
	 * 保养时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baoyangshijian;
	
	/**
	 * 制作日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date zhizuoriqi;
	
	/**
	 * 保养人员
	 */
					
	private String baoyangrenyuan;
	
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
	 * 设置：车辆颜色
	 */
	public void setCheliangyanse(String cheliangyanse) {
		this.cheliangyanse = cheliangyanse;
	}
	/**
	 * 获取：车辆颜色
	 */
	public String getCheliangyanse() {
		return cheliangyanse;
	}
	/**
	 * 设置：保养项目
	 */
	public void setBaoyangxiangmu(String baoyangxiangmu) {
		this.baoyangxiangmu = baoyangxiangmu;
	}
	/**
	 * 获取：保养项目
	 */
	public String getBaoyangxiangmu() {
		return baoyangxiangmu;
	}
	/**
	 * 设置：保养时间
	 */
	public void setBaoyangshijian(Date baoyangshijian) {
		this.baoyangshijian = baoyangshijian;
	}
	/**
	 * 获取：保养时间
	 */
	public Date getBaoyangshijian() {
		return baoyangshijian;
	}
	/**
	 * 设置：制作日期
	 */
	public void setZhizuoriqi(Date zhizuoriqi) {
		this.zhizuoriqi = zhizuoriqi;
	}
	/**
	 * 获取：制作日期
	 */
	public Date getZhizuoriqi() {
		return zhizuoriqi;
	}
	/**
	 * 设置：保养人员
	 */
	public void setBaoyangrenyuan(String baoyangrenyuan) {
		this.baoyangrenyuan = baoyangrenyuan;
	}
	/**
	 * 获取：保养人员
	 */
	public String getBaoyangrenyuan() {
		return baoyangrenyuan;
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
