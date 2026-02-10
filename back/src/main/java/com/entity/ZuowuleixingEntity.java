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
 * 作物类型
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@TableName("zuowuleixing")
public class ZuowuleixingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZuowuleixingEntity() {
		
	}
	
	public ZuowuleixingEntity(T t) {
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
	 * 作物类型
	 */
					
	private String zuowuleixing;
	
	/**
	 * 周期
	 */
					
	private String zhouqi;
	
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
}
