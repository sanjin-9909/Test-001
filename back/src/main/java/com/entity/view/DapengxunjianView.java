package com.entity.view;

import com.entity.DapengxunjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 大棚巡检
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@TableName("dapengxunjian")
public class DapengxunjianView  extends DapengxunjianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DapengxunjianView(){
	}
 
 	public DapengxunjianView(DapengxunjianEntity dapengxunjianEntity){
 	try {
			BeanUtils.copyProperties(this, dapengxunjianEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
