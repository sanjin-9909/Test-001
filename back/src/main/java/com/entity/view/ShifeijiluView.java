package com.entity.view;

import com.entity.ShifeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 施肥记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
@TableName("shifeijilu")
public class ShifeijiluView  extends ShifeijiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShifeijiluView(){
	}
 
 	public ShifeijiluView(ShifeijiluEntity shifeijiluEntity){
 	try {
			BeanUtils.copyProperties(this, shifeijiluEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
