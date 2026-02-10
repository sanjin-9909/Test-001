package com.entity.vo;

import com.entity.GuoshuzhongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 果蔬种植
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public class GuoshuzhongzhiVO  implements Serializable {
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
	 * 适宜温度
	 */
	
	private Integer shiyiwendu;
		
	/**
	 * 适宜湿度
	 */
	
	private Integer shiyishidu;
		
	/**
	 * 光照
	 */
	
	private Integer guangzhao;
		
	/**
	 * 种植时间
	 */
	
	private String zhongzhishijian;
		
	/**
	 * 种植详情
	 */
	
	private String zhongzhixiangqing;
		
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
	 * 设置：适宜温度
	 */
	 
	public void setShiyiwendu(Integer shiyiwendu) {
		this.shiyiwendu = shiyiwendu;
	}
	
	/**
	 * 获取：适宜温度
	 */
	public Integer getShiyiwendu() {
		return shiyiwendu;
	}
				
	
	/**
	 * 设置：适宜湿度
	 */
	 
	public void setShiyishidu(Integer shiyishidu) {
		this.shiyishidu = shiyishidu;
	}
	
	/**
	 * 获取：适宜湿度
	 */
	public Integer getShiyishidu() {
		return shiyishidu;
	}
				
	
	/**
	 * 设置：光照
	 */
	 
	public void setGuangzhao(Integer guangzhao) {
		this.guangzhao = guangzhao;
	}
	
	/**
	 * 获取：光照
	 */
	public Integer getGuangzhao() {
		return guangzhao;
	}
				
	
	/**
	 * 设置：种植时间
	 */
	 
	public void setZhongzhishijian(String zhongzhishijian) {
		this.zhongzhishijian = zhongzhishijian;
	}
	
	/**
	 * 获取：种植时间
	 */
	public String getZhongzhishijian() {
		return zhongzhishijian;
	}
				
	
	/**
	 * 设置：种植详情
	 */
	 
	public void setZhongzhixiangqing(String zhongzhixiangqing) {
		this.zhongzhixiangqing = zhongzhixiangqing;
	}
	
	/**
	 * 获取：种植详情
	 */
	public String getZhongzhixiangqing() {
		return zhongzhixiangqing;
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
