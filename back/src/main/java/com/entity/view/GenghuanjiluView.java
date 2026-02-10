package com.entity.view;

import com.entity.GenghuanjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 更换记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
@TableName("genghuanjilu")
public class GenghuanjiluView  extends GenghuanjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GenghuanjiluView(){
	}
 
 	public GenghuanjiluView(GenghuanjiluEntity genghuanjiluEntity){
 	try {
			BeanUtils.copyProperties(this, genghuanjiluEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
