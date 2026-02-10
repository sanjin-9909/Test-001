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

import com.entity.YujingxinxiEntity;
import com.entity.view.YujingxinxiView;

import com.service.YujingxinxiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 预警信息
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@RestController
@RequestMapping("/yujingxinxi")
public class YujingxinxiController {
    @Autowired
    private YujingxinxiService yujingxinxiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YujingxinxiEntity yujingxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			yujingxinxi.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			yujingxinxi.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YujingxinxiEntity> ew = new EntityWrapper<YujingxinxiEntity>();


        //查询结果
		PageUtils page = yujingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujingxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YujingxinxiEntity yujingxinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yujingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yujingshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YujingxinxiEntity> ew = new EntityWrapper<YujingxinxiEntity>();
        if(yujingshijianstart!=null) ew.ge("yujingshijian", yujingshijianstart);
        if(yujingshijianend!=null) ew.le("yujingshijian", yujingshijianend);

        //查询结果
		PageUtils page = yujingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujingxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YujingxinxiEntity yujingxinxi){
       	EntityWrapper<YujingxinxiEntity> ew = new EntityWrapper<YujingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yujingxinxi, "yujingxinxi"));
        return R.ok().put("data", yujingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YujingxinxiEntity yujingxinxi){
        EntityWrapper< YujingxinxiEntity> ew = new EntityWrapper< YujingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yujingxinxi, "yujingxinxi"));
		YujingxinxiView yujingxinxiView =  yujingxinxiService.selectView(ew);
		return R.ok("查询预警信息成功").put("data", yujingxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YujingxinxiEntity yujingxinxi = yujingxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yujingxinxi,deSens);
        return R.ok().put("data", yujingxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YujingxinxiEntity yujingxinxi = yujingxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yujingxinxi,deSens);
        return R.ok().put("data", yujingxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增预警信息")
    public R save(@RequestBody YujingxinxiEntity yujingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujingxinxi);
        yujingxinxiService.insert(yujingxinxi);
        return R.ok().put("data",yujingxinxi.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增预警信息")
    @RequestMapping("/add")
    public R add(@RequestBody YujingxinxiEntity yujingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujingxinxi);
        yujingxinxiService.insert(yujingxinxi);
        return R.ok().put("data",yujingxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改预警信息")
    public R update(@RequestBody YujingxinxiEntity yujingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujingxinxi);
        //全部更新
        yujingxinxiService.updateById(yujingxinxi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除预警信息")
    public R delete(@RequestBody Long[] ids){
        yujingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
