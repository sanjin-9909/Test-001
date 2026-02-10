package com.entity.vo;

import com.entity.GuoshushengzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 果蔬生长
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
public class GuoshushengzhangVO  implements Serializable {
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
	 * 记录时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jilushijian;
		
	/**
	 * 生长阶段
	 */
	
	private String shengzhangjieduan;
		
	/**
	 * 叶片数量
	 */
	
	private String yepianshuliang;
		
	/**
	 * 作物高度
	 */
	
	private String zuowugaodu;
		
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
	 * 设置：记录时间
	 */
	 
	public void setJilushijian(Date jilushijian) {
		this.jilushijian = jilushijian;
	}
	
	/**
	 * 获取：记录时间
	 */
	public Date getJilushijian() {
		return jilushijian;
	}
				
	
	/**
	 * 设置：生长阶段
	 */
	 
	public void setShengzhangjieduan(String shengzhangjieduan) {
		this.shengzhangjieduan = shengzhangjieduan;
	}
	
	/**
	 * 获取：生长阶段
	 */
	public String getShengzhangjieduan() {
		return shengzhangjieduan;
	}
				
	
	/**
	 * 设置：叶片数量
	 */
	 
	public void setYepianshuliang(String yepianshuliang) {
		this.yepianshuliang = yepianshuliang;
	}
	
	/**
	 * 获取：叶片数量
	 */
	public String getYepianshuliang() {
		return yepianshuliang;
	}
				
	
	/**
	 * 设置：作物高度
	 */
	 
	public void setZuowugaodu(String zuowugaodu) {
		this.zuowugaodu = zuowugaodu;
	}
	
	/**
	 * 获取：作物高度
	 */
	public String getZuowugaodu() {
		return zuowugaodu;
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
