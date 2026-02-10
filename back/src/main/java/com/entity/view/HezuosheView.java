package com.entity.view;

import com.entity.HezuosheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 合作社
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@TableName("hezuoshe")
public class HezuosheView  extends HezuosheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HezuosheView(){
	}
 
 	public HezuosheView(HezuosheEntity hezuosheEntity){
 	try {
			BeanUtils.copyProperties(this, hezuosheEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
