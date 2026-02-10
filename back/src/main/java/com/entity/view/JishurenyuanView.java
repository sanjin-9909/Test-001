package com.entity.view;

import com.entity.JishurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 技术人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@TableName("jishurenyuan")
public class JishurenyuanView  extends JishurenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JishurenyuanView(){
	}
 
 	public JishurenyuanView(JishurenyuanEntity jishurenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, jishurenyuanEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
