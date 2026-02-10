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
 * 资讯内容
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
@TableName("zixunneirong")
public class ZixunneirongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZixunneirongEntity() {
		
	}
	
	public ZixunneirongEntity(T t) {
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
	 * 资讯名称
	 */
					
	private String zixunmingcheng;
	
	/**
	 * 资讯类型
	 */
					
	private String zixunleixing;
	
	/**
	 * 资讯图片
	 */
					
	private String zixuntupian;
	
	/**
	 * 适用场景
	 */
					
	private String shiyongchangjing;
	
	/**
	 * 难度等级
	 */
					
	private String nandudengji;
	
	/**
	 * 核心点
	 */
					
	private String hexindian;
	
	/**
	 * 步骤流程
	 */
					
	private String buzhouliucheng;
	
	/**
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	/**
	 * 适用人群
	 */
					
	private String shiyongrenqun;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 资讯详情
	 */
					
	private String zixunxiangqing;
	
	/**
	 * 技术员账号
	 */
					
	private String jishuyuanzhanghao;
	
	/**
	 * 技术员姓名
	 */
					
	private String jishuyuanxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
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
	 * 设置：资讯名称
	 */
	public void setZixunmingcheng(String zixunmingcheng) {
		this.zixunmingcheng = zixunmingcheng;
	}
	/**
	 * 获取：资讯名称
	 */
	public String getZixunmingcheng() {
		return zixunmingcheng;
	}
	/**
	 * 设置：资讯类型
	 */
	public void setZixunleixing(String zixunleixing) {
		this.zixunleixing = zixunleixing;
	}
	/**
	 * 获取：资讯类型
	 */
	public String getZixunleixing() {
		return zixunleixing;
	}
	/**
	 * 设置：资讯图片
	 */
	public void setZixuntupian(String zixuntupian) {
		this.zixuntupian = zixuntupian;
	}
	/**
	 * 获取：资讯图片
	 */
	public String getZixuntupian() {
		return zixuntupian;
	}
	/**
	 * 设置：适用场景
	 */
	public void setShiyongchangjing(String shiyongchangjing) {
		this.shiyongchangjing = shiyongchangjing;
	}
	/**
	 * 获取：适用场景
	 */
	public String getShiyongchangjing() {
		return shiyongchangjing;
	}
	/**
	 * 设置：难度等级
	 */
	public void setNandudengji(String nandudengji) {
		this.nandudengji = nandudengji;
	}
	/**
	 * 获取：难度等级
	 */
	public String getNandudengji() {
		return nandudengji;
	}
	/**
	 * 设置：核心点
	 */
	public void setHexindian(String hexindian) {
		this.hexindian = hexindian;
	}
	/**
	 * 获取：核心点
	 */
	public String getHexindian() {
		return hexindian;
	}
	/**
	 * 设置：步骤流程
	 */
	public void setBuzhouliucheng(String buzhouliucheng) {
		this.buzhouliucheng = buzhouliucheng;
	}
	/**
	 * 获取：步骤流程
	 */
	public String getBuzhouliucheng() {
		return buzhouliucheng;
	}
	/**
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
	/**
	 * 设置：适用人群
	 */
	public void setShiyongrenqun(String shiyongrenqun) {
		this.shiyongrenqun = shiyongrenqun;
	}
	/**
	 * 获取：适用人群
	 */
	public String getShiyongrenqun() {
		return shiyongrenqun;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：资讯详情
	 */
	public void setZixunxiangqing(String zixunxiangqing) {
		this.zixunxiangqing = zixunxiangqing;
	}
	/**
	 * 获取：资讯详情
	 */
	public String getZixunxiangqing() {
		return zixunxiangqing;
	}
	/**
	 * 设置：技术员账号
	 */
	public void setJishuyuanzhanghao(String jishuyuanzhanghao) {
		this.jishuyuanzhanghao = jishuyuanzhanghao;
	}
	/**
	 * 获取：技术员账号
	 */
	public String getJishuyuanzhanghao() {
		return jishuyuanzhanghao;
	}
	/**
	 * 设置：技术员姓名
	 */
	public void setJishuyuanxingming(String jishuyuanxingming) {
		this.jishuyuanxingming = jishuyuanxingming;
	}
	/**
	 * 获取：技术员姓名
	 */
	public String getJishuyuanxingming() {
		return jishuyuanxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
}
