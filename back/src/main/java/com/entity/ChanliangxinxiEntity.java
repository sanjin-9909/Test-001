package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 产量信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
@TableName("chanliangxinxi")
public class ChanliangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChanliangxinxiEntity() {
		
	}
	
	public ChanliangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 大棚名称
	 */
					
	private String dapengmingcheng;
	
	/**
	 * 作物名称
	 */
					
	private String zuowumingcheng;
	
	/**
	 * 作物类型
	 */
					
	private String zuowuleixing;
	
	/**
	 * 周期
	 */
					
	private String zhouqi;
	
	/**
	 * 作物图片
	 */
					
	private String zuowutupian;
	
	/**
	 * 种植面积㎡
	 */
					
	private String zhongzhimianji;
	
	/**
	 * 收获时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shouhuoshijian;
	
	/**
	 * 收获数量(吨/㎡)
	 */
					
	private Integer shouhuoshuliang;
	
	/**
	 * 农户账号
	 */
					
	private String nonghuzhanghao;
	
	/**
	 * 农户姓名
	 */
					
	private String nonghuxingming;
	
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
	 * 设置：大棚名称
	 */
	public void setDapengmingcheng(String dapengmingcheng) {
		this.dapengmingcheng = dapengmingcheng;
	}
	/**
	 * 获取：大棚名称
	 */
	public String getDapengmingcheng() {
		return dapengmingcheng;
	}
	/**
	 * 设置：作物名称
	 */
	public void setZuowumingcheng(String zuowumingcheng) {
		this.zuowumingcheng = zuowumingcheng;
	}
	/**
	 * 获取：作物名称
	 */
	public String getZuowumingcheng() {
		return zuowumingcheng;
	}
	/**
	 * 设置：作物类型
	 */
	public void setZuowuleixing(String zuowuleixing) {
		this.zuowuleixing = zuowuleixing;
	}
	/**
	 * 获取：作物类型
	 */
	public String getZuowuleixing() {
		return zuowuleixing;
	}
	/**
	 * 设置：周期
	 */
	public void setZhouqi(String zhouqi) {
		this.zhouqi = zhouqi;
	}
	/**
	 * 获取：周期
	 */
	public String getZhouqi() {
		return zhouqi;
	}
	/**
	 * 设置：作物图片
	 */
	public void setZuowutupian(String zuowutupian) {
		this.zuowutupian = zuowutupian;
	}
	/**
	 * 获取：作物图片
	 */
	public String getZuowutupian() {
		return zuowutupian;
	}
	/**
	 * 设置：种植面积㎡
	 */
	public void setZhongzhimianji(String zhongzhimianji) {
		this.zhongzhimianji = zhongzhimianji;
	}
	/**
	 * 获取：种植面积㎡
	 */
	public String getZhongzhimianji() {
		return zhongzhimianji;
	}
	/**
	 * 设置：收获时间
	 */
	public void setShouhuoshijian(Date shouhuoshijian) {
		this.shouhuoshijian = shouhuoshijian;
	}
	/**
	 * 获取：收获时间
	 */
	public Date getShouhuoshijian() {
		return shouhuoshijian;
	}
	/**
	 * 设置：收获数量(吨/㎡)
	 */
	public void setShouhuoshuliang(Integer shouhuoshuliang) {
		this.shouhuoshuliang = shouhuoshuliang;
	}
	/**
	 * 获取：收获数量(吨/㎡)
	 */
	public Integer getShouhuoshuliang() {
		return shouhuoshuliang;
	}
	/**
	 * 设置：农户账号
	 */
	public void setNonghuzhanghao(String nonghuzhanghao) {
		this.nonghuzhanghao = nonghuzhanghao;
	}
	/**
	 * 获取：农户账号
	 */
	public String getNonghuzhanghao() {
		return nonghuzhanghao;
	}
	/**
	 * 设置：农户姓名
	 */
	public void setNonghuxingming(String nonghuxingming) {
		this.nonghuxingming = nonghuxingming;
	}
	/**
	 * 获取：农户姓名
	 */
	public String getNonghuxingming() {
		return nonghuxingming;
	}
}
