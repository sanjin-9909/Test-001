package com.entity.view;

import com.entity.YujingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 预警信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@TableName("yujingxinxi")
public class YujingxinxiView  extends YujingxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YujingxinxiView(){
	}
 
 	public YujingxinxiView(YujingxinxiEntity yujingxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yujingxinxiEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
