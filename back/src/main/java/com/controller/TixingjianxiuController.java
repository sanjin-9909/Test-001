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

import com.entity.TixingjianxiuEntity;
import com.entity.view.TixingjianxiuView;

import com.service.TixingjianxiuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 提醒检修
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@RestController
@RequestMapping("/tixingjianxiu")
public class TixingjianxiuController {
    @Autowired
    private TixingjianxiuService tixingjianxiuService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TixingjianxiuEntity tixingjianxiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			tixingjianxiu.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			tixingjianxiu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<TixingjianxiuEntity> ew = new EntityWrapper<TixingjianxiuEntity>();


        //查询结果
		PageUtils page = tixingjianxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixingjianxiu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,TixingjianxiuEntity tixingjianxiu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tixingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tixingshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TixingjianxiuEntity> ew = new EntityWrapper<TixingjianxiuEntity>();
        if(tixingshijianstart!=null) ew.ge("tixingshijian", tixingshijianstart);
        if(tixingshijianend!=null) ew.le("tixingshijian", tixingshijianend);

        //查询结果
		PageUtils page = tixingjianxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixingjianxiu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TixingjianxiuEntity tixingjianxiu){
       	EntityWrapper<TixingjianxiuEntity> ew = new EntityWrapper<TixingjianxiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tixingjianxiu, "tixingjianxiu"));
        return R.ok().put("data", tixingjianxiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TixingjianxiuEntity tixingjianxiu){
        EntityWrapper< TixingjianxiuEntity> ew = new EntityWrapper< TixingjianxiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tixingjianxiu, "tixingjianxiu"));
		TixingjianxiuView tixingjianxiuView =  tixingjianxiuService.selectView(ew);
		return R.ok("查询提醒检修成功").put("data", tixingjianxiuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TixingjianxiuEntity tixingjianxiu = tixingjianxiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tixingjianxiu,deSens);
        return R.ok().put("data", tixingjianxiu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TixingjianxiuEntity tixingjianxiu = tixingjianxiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tixingjianxiu,deSens);
        return R.ok().put("data", tixingjianxiu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增提醒检修")
    public R save(@RequestBody TixingjianxiuEntity tixingjianxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingjianxiu);
        tixingjianxiuService.insert(tixingjianxiu);
        return R.ok().put("data",tixingjianxiu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增提醒检修")
    @RequestMapping("/add")
    public R add(@RequestBody TixingjianxiuEntity tixingjianxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingjianxiu);
        tixingjianxiuService.insert(tixingjianxiu);
        return R.ok().put("data",tixingjianxiu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改提醒检修")
    public R update(@RequestBody TixingjianxiuEntity tixingjianxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingjianxiu);
        //全部更新
        tixingjianxiuService.updateById(tixingjianxiu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除提醒检修")
    public R delete(@RequestBody Long[] ids){
        tixingjianxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
