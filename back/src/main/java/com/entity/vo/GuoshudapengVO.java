package com.entity.vo;

import com.entity.GuoshudapengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 果蔬大棚
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public class GuoshudapengVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 大棚名称
	 */
	
	private String dapengmingcheng;
		
	/**
	 * 大棚图片
	 */
	
	private String dapengtupian;
		
	/**
	 * 大棚类型
	 */
	
	private String dapengleixing;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 特点
	 */
	
	private String tedian;
		
	/**
	 * 面积
	 */
	
	private String mianji;
		
	/**
	 * 温度
	 */
	
	private Integer wendu;
		
	/**
	 * 湿度
	 */
	
	private Integer shidu;
		
	/**
	 * 光照
	 */
	
	private Integer guangzhao;
		
	/**
	 * 创建时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chuangjianshijian;
		
	/**
	 * 设备设施
	 */
	
	private String shebeisheshi;
		
	/**
	 * 信用代码
	 */
	
	private String xinyongdaima;
		
	/**
	 * 合作社名称
	 */
	
	private String hezuoshemingcheng;
				
	
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
	 * 设置：大棚图片
	 */
	 
	public void setDapengtupian(String dapengtupian) {
		this.dapengtupian = dapengtupian;
	}
	
	/**
	 * 获取：大棚图片
	 */
	public String getDapengtupian() {
		return dapengtupian;
	}
				
	
	/**
	 * 设置：大棚类型
	 */
	 
	public void setDapengleixing(String dapengleixing) {
		this.dapengleixing = dapengleixing;
	}
	
	/**
	 * 获取：大棚类型
	 */
	public String getDapengleixing() {
		return dapengleixing;
	}
				
	
	/**
	 * 设置：规格
	 */
	 
	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
				
	
	/**
	 * 设置：特点
	 */
	 
	public void setTedian(String tedian) {
		this.tedian = tedian;
	}
	
	/**
	 * 获取：特点
	 */
	public String getTedian() {
		return tedian;
	}
				
	
	/**
	 * 设置：面积
	 */
	 
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return mianji;
	}
				
	
	/**
	 * 设置：温度
	 */
	 
	public void setWendu(Integer wendu) {
		this.wendu = wendu;
	}
	
	/**
	 * 获取：温度
	 */
	public Integer getWendu() {
		return wendu;
	}
				
	
	/**
	 * 设置：湿度
	 */
	 
	public void setShidu(Integer shidu) {
		this.shidu = shidu;
	}
	
	/**
	 * 获取：湿度
	 */
	public Integer getShidu() {
		return shidu;
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
	 * 设置：创建时间
	 */
	 
	public void setChuangjianshijian(Date chuangjianshijian) {
		this.chuangjianshijian = chuangjianshijian;
	}
	
	/**
	 * 获取：创建时间
	 */
	public Date getChuangjianshijian() {
		return chuangjianshijian;
	}
				
	
	/**
	 * 设置：设备设施
	 */
	 
	public void setShebeisheshi(String shebeisheshi) {
		this.shebeisheshi = shebeisheshi;
	}
	
	/**
	 * 获取：设备设施
	 */
	public String getShebeisheshi() {
		return shebeisheshi;
	}
				
	
	/**
	 * 设置：信用代码
	 */
	 
	public void setXinyongdaima(String xinyongdaima) {
		this.xinyongdaima = xinyongdaima;
	}
	
	/**
	 * 获取：信用代码
	 */
	public String getXinyongdaima() {
		return xinyongdaima;
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
			
}
