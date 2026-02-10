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

import com.entity.ShebeiweixiuEntity;
import com.entity.view.ShebeiweixiuView;

import com.service.ShebeiweixiuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备维修
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
@RestController
@RequestMapping("/shebeiweixiu")
public class ShebeiweixiuController {
    @Autowired
    private ShebeiweixiuService shebeiweixiuService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeiweixiuEntity shebeiweixiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			shebeiweixiu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jishurenyuan")) {
			shebeiweixiu.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShebeiweixiuEntity> ew = new EntityWrapper<ShebeiweixiuEntity>();


        //查询结果
		PageUtils page = shebeiweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiweixiu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShebeiweixiuEntity shebeiweixiu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date weixiushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date weixiushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeiweixiuEntity> ew = new EntityWrapper<ShebeiweixiuEntity>();
        if(weixiushijianstart!=null) ew.ge("weixiushijian", weixiushijianstart);
        if(weixiushijianend!=null) ew.le("weixiushijian", weixiushijianend);

        //查询结果
		PageUtils page = shebeiweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiweixiu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeiweixiuEntity shebeiweixiu){
       	EntityWrapper<ShebeiweixiuEntity> ew = new EntityWrapper<ShebeiweixiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeiweixiu, "shebeiweixiu"));
        return R.ok().put("data", shebeiweixiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeiweixiuEntity shebeiweixiu){
        EntityWrapper< ShebeiweixiuEntity> ew = new EntityWrapper< ShebeiweixiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeiweixiu, "shebeiweixiu"));
		ShebeiweixiuView shebeiweixiuView =  shebeiweixiuService.selectView(ew);
		return R.ok("查询设备维修成功").put("data", shebeiweixiuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeiweixiuEntity shebeiweixiu = shebeiweixiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeiweixiu,deSens);
        return R.ok().put("data", shebeiweixiu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeiweixiuEntity shebeiweixiu = shebeiweixiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeiweixiu,deSens);
        return R.ok().put("data", shebeiweixiu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增设备维修")
    public R save(@RequestBody ShebeiweixiuEntity shebeiweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiweixiu);
        shebeiweixiuService.insert(shebeiweixiu);
        return R.ok().put("data",shebeiweixiu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增设备维修")
    @RequestMapping("/add")
    public R add(@RequestBody ShebeiweixiuEntity shebeiweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiweixiu);
        shebeiweixiuService.insert(shebeiweixiu);
        return R.ok().put("data",shebeiweixiu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改设备维修")
    public R update(@RequestBody ShebeiweixiuEntity shebeiweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiweixiu);
        //全部更新
        shebeiweixiuService.updateById(shebeiweixiu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除设备维修")
    public R delete(@RequestBody Long[] ids){
        shebeiweixiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
