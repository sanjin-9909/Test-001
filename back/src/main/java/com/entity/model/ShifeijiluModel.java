package com.entity.model;

import com.entity.ShifeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 施肥记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public class ShifeijiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 施肥数量
	 */
	
	private String shifeishuliang;
		
	/**
	 * 施肥时间
	 */
	
	private String shifeishijian;
		
	/**
	 * 施肥周期
	 */
	
	private String shifeizhouqi;
		
	/**
	 * 施肥方案
	 */
	
	private String shifeifangan;
		
	/**
	 * 农户账号
	 */
	
	private String nonghuzhanghao;
		
	/**
	 * 农户姓名
	 */
	
	private String nonghuxingming;
				
	
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
	 * 设置：施肥数量
	 */
	 
	public void setShifeishuliang(String shifeishuliang) {
		this.shifeishuliang = shifeishuliang;
	}
	
	/**
	 * 获取：施肥数量
	 */
	public String getShifeishuliang() {
		return shifeishuliang;
	}
				
	
	/**
	 * 设置：施肥时间
	 */
	 
	public void setShifeishijian(String shifeishijian) {
		this.shifeishijian = shifeishijian;
	}
	
	/**
	 * 获取：施肥时间
	 */
	public String getShifeishijian() {
		return shifeishijian;
	}
				
	
	/**
	 * 设置：施肥周期
	 */
	 
	public void setShifeizhouqi(String shifeizhouqi) {
		this.shifeizhouqi = shifeizhouqi;
	}
	
	/**
	 * 获取：施肥周期
	 */
	public String getShifeizhouqi() {
		return shifeizhouqi;
	}
				
	
	/**
	 * 设置：施肥方案
	 */
	 
	public void setShifeifangan(String shifeifangan) {
		this.shifeifangan = shifeifangan;
	}
	
	/**
	 * 获取：施肥方案
	 */
	public String getShifeifangan() {
		return shifeifangan;
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
