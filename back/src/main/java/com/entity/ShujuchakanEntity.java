package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 数据查看
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@TableName("shujuchakan")
public class ShujuchakanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShujuchakanEntity() {
		
	}
	
	public ShujuchakanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 大棚编号
	 */
					
	private String dapengbianhao;
	
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
	 * 分析时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fenxishijian;
	
	/**
	 * 信用代码
	 */
					
	private String xinyongdaima;
	
	/**
	 * 合作社名称
	 */
					
	private String hezuoshemingcheng;
	
	/**
	 * 异常原因
	 */
					
	private String yichangyuanyin;
	
	/**
	 * 农户账号
	 */
					
	private String nonghuzhanghao;
	
	/**
	 * 农户姓名
	 */
					
	private String nonghuxingming;
	
	/**
	 * 技术员账号
	 */
					
	private String jishuyuanzhanghao;
	
	/**
	 * 技术员姓名
	 */
					
	private String jishuyuanxingming;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：大棚编号
	 */
	public void setDapengbianhao(String dapengbianhao) {
		this.dapengbianhao = dapengbianhao;
	}
	/**
	 * 获取：大棚编号
	 */
	public String getDapengbianhao() {
		return dapengbianhao;
	}
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
	 * 设置：分析时间
	 */
	public void setFenxishijian(Date fenxishijian) {
		this.fenxishijian = fenxishijian;
	}
	/**
	 * 获取：分析时间
	 */
	public Date getFenxishijian() {
		return fenxishijian;
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
	/**
	 * 设置：异常原因
	 */
	public void setYichangyuanyin(String yichangyuanyin) {
		this.yichangyuanyin = yichangyuanyin;
	}
	/**
	 * 获取：异常原因
	 */
	public String getYichangyuanyin() {
		return yichangyuanyin;
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
	/**
	 * 设置：技术员账号
	 */
	public void setJishuyuanzhanghao(String jishuyuanzhanghao) {
		this.jishuyuanzhanghao = jishuyuanzhanghao;
	}
	/**
	 * 获取：技术员账号
	 */
	public String getJishuyuanzhanghao() {
		return jishuyuanzhanghao;
	}
	/**
	 * 设置：技术员姓名
	 */
	public void setJishuyuanxingming(String jishuyuanxingming) {
		this.jishuyuanxingming = jishuyuanxingming;
	}
	/**
	 * 获取：技术员姓名
	 */
	public String getJishuyuanxingming() {
		return jishuyuanxingming;
	}
}
