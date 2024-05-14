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
 * 动力电池信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@TableName("donglidianchixinxi")
public class DonglidianchixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DonglidianchixinxiEntity() {
		
	}
	
	public DonglidianchixinxiEntity(T t) {
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
	 * 电池电量
	 */
					
	private String dianchidianliang;
	
	/**
	 * 剩余容量
	 */
					
	private String shengyurongliang;
	
	/**
	 * 电压
	 */
					
	private String dianya;
	
	/**
	 * 循环次数
	 */
					
	private String xunhuancishu;
	
	/**
	 * 电池温度
	 */
					
	private String dianchiwendu;
	
	/**
	 * 充电电流
	 */
					
	private String chongdiandianliu;
	
	/**
	 * 最大充电电流
	 */
					
	private String zuidachongdiandianliu;
	
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
	 * 设置：电池电量
	 */
	public void setDianchidianliang(String dianchidianliang) {
		this.dianchidianliang = dianchidianliang;
	}
	/**
	 * 获取：电池电量
	 */
	public String getDianchidianliang() {
		return dianchidianliang;
	}
	/**
	 * 设置：剩余容量
	 */
	public void setShengyurongliang(String shengyurongliang) {
		this.shengyurongliang = shengyurongliang;
	}
	/**
	 * 获取：剩余容量
	 */
	public String getShengyurongliang() {
		return shengyurongliang;
	}
	/**
	 * 设置：电压
	 */
	public void setDianya(String dianya) {
		this.dianya = dianya;
	}
	/**
	 * 获取：电压
	 */
	public String getDianya() {
		return dianya;
	}
	/**
	 * 设置：循环次数
	 */
	public void setXunhuancishu(String xunhuancishu) {
		this.xunhuancishu = xunhuancishu;
	}
	/**
	 * 获取：循环次数
	 */
	public String getXunhuancishu() {
		return xunhuancishu;
	}
	/**
	 * 设置：电池温度
	 */
	public void setDianchiwendu(String dianchiwendu) {
		this.dianchiwendu = dianchiwendu;
	}
	/**
	 * 获取：电池温度
	 */
	public String getDianchiwendu() {
		return dianchiwendu;
	}
	/**
	 * 设置：充电电流
	 */
	public void setChongdiandianliu(String chongdiandianliu) {
		this.chongdiandianliu = chongdiandianliu;
	}
	/**
	 * 获取：充电电流
	 */
	public String getChongdiandianliu() {
		return chongdiandianliu;
	}
	/**
	 * 设置：最大充电电流
	 */
	public void setZuidachongdiandianliu(String zuidachongdiandianliu) {
		this.zuidachongdiandianliu = zuidachongdiandianliu;
	}
	/**
	 * 获取：最大充电电流
	 */
	public String getZuidachongdiandianliu() {
		return zuidachongdiandianliu;
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
