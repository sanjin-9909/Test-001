package com.entity.model;

import com.entity.HezuosheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 合作社
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public class HezuosheModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 合作社名称
	 */
	
	private String hezuoshemingcheng;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 成立日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chengliriqi;
		
	/**
	 * 联系人
	 */
	
	private String lianxiren;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 主营项目
	 */
	
	private String zhuyingxiangmu;
		
	/**
	 * 所在地
	 */
	
	private String suozaidi;
		
	/**
	 * 合作社详情
	 */
	
	private String hezuoshexiangqing;
		
	/**
	 * 密保问题
	 */
	
	private String pquestion;
		
	/**
	 * 密保答案
	 */
	
	private String panswer;
		
	/**
	 * 状态
	 */
	
	private Integer status;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：合作社名称
	 */
	 
	public void setHezuoshemingcheng(String hezuoshemingcheng) {
		this.hezuoshemingcheng = hezuoshemingcheng;
	}
	
	/**
	 * 获取：合作社名称
	 */
	public String getHezuoshemingcheng() {
		return hezuoshemingcheng;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：成立日期
	 */
	 
	public void setChengliriqi(Date chengliriqi) {
		this.chengliriqi = chengliriqi;
	}
	
	/**
	 * 获取：成立日期
	 */
	public Date getChengliriqi() {
		return chengliriqi;
	}
				
	
	/**
	 * 设置：联系人
	 */
	 
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	
	/**
	 * 获取：联系人
	 */
	public String getLianxiren() {
		return lianxiren;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：主营项目
	 */
	 
	public void setZhuyingxiangmu(String zhuyingxiangmu) {
		this.zhuyingxiangmu = zhuyingxiangmu;
	}
	
	/**
	 * 获取：主营项目
	 */
	public String getZhuyingxiangmu() {
		return zhuyingxiangmu;
	}
				
	
	/**
	 * 设置：所在地
	 */
	 
	public void setSuozaidi(String suozaidi) {
		this.suozaidi = suozaidi;
	}
	
	/**
	 * 获取：所在地
	 */
	public String getSuozaidi() {
		return suozaidi;
	}
				
	
	/**
	 * 设置：合作社详情
	 */
	 
	public void setHezuoshexiangqing(String hezuoshexiangqing) {
		this.hezuoshexiangqing = hezuoshexiangqing;
	}
	
	/**
	 * 获取：合作社详情
	 */
	public String getHezuoshexiangqing() {
		return hezuoshexiangqing;
	}
				
	
	/**
	 * 设置：密保问题
	 */
	 
	public void setPquestion(String pquestion) {
		this.pquestion = pquestion;
	}
	
	/**
	 * 获取：密保问题
	 */
	public String getPquestion() {
		return pquestion;
	}
				
	
	/**
	 * 设置：密保答案
	 */
	 
	public void setPanswer(String panswer) {
		this.panswer = panswer;
	}
	
	/**
	 * 获取：密保答案
	 */
	public String getPanswer() {
		return panswer;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
			
}
