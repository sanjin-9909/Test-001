package com.entity.vo;

import com.entity.ZuowuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 作物类型
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
public class ZuowuleixingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 周期
	 */
	
	private String zhouqi;
				
	
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
