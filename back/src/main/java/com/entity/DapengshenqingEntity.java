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
 * 大棚申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@TableName("dapengshenqing")
public class DapengshenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DapengshenqingEntity() {
		
	}
	
	public DapengshenqingEntity(T t) {
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
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 信用代码
	 */
					
	private String xinyongdaima;
	
	/**
	 * 合作社名称
	 */
					
	private String hezuoshemingcheng;
	
	/**
	 * 种植规划
	 */
					
	private String zhongzhiguihua;
	
	/**
	 * 农户账号
	 */
					
	private String nonghuzhanghao;
	
	/**
	 * 农户姓名
	 */
					
	private String nonghuxingming;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
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
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
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
	 * 设置：种植规划
	 */
	public void setZhongzhiguihua(String zhongzhiguihua) {
		this.zhongzhiguihua = zhongzhiguihua;
	}
	/**
	 * 获取：种植规划
	 */
	public String getZhongzhiguihua() {
		return zhongzhiguihua;
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
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
}
