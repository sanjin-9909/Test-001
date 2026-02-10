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

import com.entity.YujingxiezhuEntity;
import com.entity.view.YujingxiezhuView;

import com.service.YujingxiezhuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 预警协助
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@RestController
@RequestMapping("/yujingxiezhu")
public class YujingxiezhuController {
    @Autowired
    private YujingxiezhuService yujingxiezhuService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YujingxiezhuEntity yujingxiezhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			yujingxiezhu.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			yujingxiezhu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YujingxiezhuEntity> ew = new EntityWrapper<YujingxiezhuEntity>();


        //查询结果
		PageUtils page = yujingxiezhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujingxiezhu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YujingxiezhuEntity yujingxiezhu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date xiezhushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date xiezhushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YujingxiezhuEntity> ew = new EntityWrapper<YujingxiezhuEntity>();
        if(xiezhushijianstart!=null) ew.ge("xiezhushijian", xiezhushijianstart);
        if(xiezhushijianend!=null) ew.le("xiezhushijian", xiezhushijianend);

        //查询结果
		PageUtils page = yujingxiezhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujingxiezhu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YujingxiezhuEntity yujingxiezhu){
       	EntityWrapper<YujingxiezhuEntity> ew = new EntityWrapper<YujingxiezhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yujingxiezhu, "yujingxiezhu"));
        return R.ok().put("data", yujingxiezhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YujingxiezhuEntity yujingxiezhu){
        EntityWrapper< YujingxiezhuEntity> ew = new EntityWrapper< YujingxiezhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yujingxiezhu, "yujingxiezhu"));
		YujingxiezhuView yujingxiezhuView =  yujingxiezhuService.selectView(ew);
		return R.ok("查询预警协助成功").put("data", yujingxiezhuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YujingxiezhuEntity yujingxiezhu = yujingxiezhuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yujingxiezhu,deSens);
        return R.ok().put("data", yujingxiezhu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YujingxiezhuEntity yujingxiezhu = yujingxiezhuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yujingxiezhu,deSens);
        return R.ok().put("data", yujingxiezhu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增预警协助")
    public R save(@RequestBody YujingxiezhuEntity yujingxiezhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujingxiezhu);
        yujingxiezhuService.insert(yujingxiezhu);
        return R.ok().put("data",yujingxiezhu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增预警协助")
    @RequestMapping("/add")
    public R add(@RequestBody YujingxiezhuEntity yujingxiezhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujingxiezhu);
        yujingxiezhuService.insert(yujingxiezhu);
        return R.ok().put("data",yujingxiezhu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改预警协助")
    public R update(@RequestBody YujingxiezhuEntity yujingxiezhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujingxiezhu);
        //全部更新
        yujingxiezhuService.updateById(yujingxiezhu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除预警协助")
    public R delete(@RequestBody Long[] ids){
        yujingxiezhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
