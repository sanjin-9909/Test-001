package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import com.utils.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.TousujiluEntity;
import com.entity.view.TousujiluView;

import com.service.TousujiluService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投诉记录
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
@RestController
@RequestMapping("/tousujilu")
public class TousujiluController {
    @Autowired
    private TousujiluService tousujiluService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TousujiluEntity tousujilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			tousujilu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jishurenyuan")) {
			tousujilu.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<TousujiluEntity> ew = new EntityWrapper<TousujiluEntity>();


        //查询结果
		PageUtils page = tousujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousujilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TousujiluEntity tousujilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tousushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tousushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TousujiluEntity> ew = new EntityWrapper<TousujiluEntity>();
        if(tousushijianstart!=null) ew.ge("tousushijian", tousushijianstart);
        if(tousushijianend!=null) ew.le("tousushijian", tousushijianend);

        //查询结果
		PageUtils page = tousujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousujilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TousujiluEntity tousujilu){
       	EntityWrapper<TousujiluEntity> ew = new EntityWrapper<TousujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tousujilu, "tousujilu"));
        return R.ok().put("data", tousujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TousujiluEntity tousujilu){
        EntityWrapper< TousujiluEntity> ew = new EntityWrapper< TousujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tousujilu, "tousujilu"));
		TousujiluView tousujiluView =  tousujiluService.selectView(ew);
		return R.ok("查询投诉记录成功").put("data", tousujiluView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TousujiluEntity tousujilu = tousujiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tousujilu,deSens);
        return R.ok().put("data", tousujilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TousujiluEntity tousujilu = tousujiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tousujilu,deSens);
        return R.ok().put("data", tousujilu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增投诉记录")
    public R save(@RequestBody TousujiluEntity tousujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousujilu);
        tousujiluService.insert(tousujilu);
        return R.ok().put("data",tousujilu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增投诉记录")
    @RequestMapping("/add")
    public R add(@RequestBody TousujiluEntity tousujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousujilu);
        tousujiluService.insert(tousujilu);
        return R.ok().put("data",tousujilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改投诉记录")
    public R update(@RequestBody TousujiluEntity tousujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousujilu);
        //全部更新
        tousujiluService.updateById(tousujilu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除投诉记录")
    public R delete(@RequestBody Long[] ids){
        tousujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
