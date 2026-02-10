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

import com.entity.GuzhangbaoxiuEntity;
import com.entity.view.GuzhangbaoxiuView;

import com.service.GuzhangbaoxiuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 故障报修
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@RestController
@RequestMapping("/guzhangbaoxiu")
public class GuzhangbaoxiuController {
    @Autowired
    private GuzhangbaoxiuService guzhangbaoxiuService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuzhangbaoxiuEntity guzhangbaoxiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			guzhangbaoxiu.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			guzhangbaoxiu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();


        //查询结果
		PageUtils page = guzhangbaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guzhangbaoxiu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GuzhangbaoxiuEntity guzhangbaoxiu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date baoxiushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date baoxiushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();
        if(baoxiushijianstart!=null) ew.ge("baoxiushijian", baoxiushijianstart);
        if(baoxiushijianend!=null) ew.le("baoxiushijian", baoxiushijianend);

        //查询结果
		PageUtils page = guzhangbaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guzhangbaoxiu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuzhangbaoxiuEntity guzhangbaoxiu){
       	EntityWrapper<GuzhangbaoxiuEntity> ew = new EntityWrapper<GuzhangbaoxiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guzhangbaoxiu, "guzhangbaoxiu"));
        return R.ok().put("data", guzhangbaoxiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuzhangbaoxiuEntity guzhangbaoxiu){
        EntityWrapper< GuzhangbaoxiuEntity> ew = new EntityWrapper< GuzhangbaoxiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guzhangbaoxiu, "guzhangbaoxiu"));
		GuzhangbaoxiuView guzhangbaoxiuView =  guzhangbaoxiuService.selectView(ew);
		return R.ok("查询故障报修成功").put("data", guzhangbaoxiuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuzhangbaoxiuEntity guzhangbaoxiu = guzhangbaoxiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guzhangbaoxiu,deSens);
        return R.ok().put("data", guzhangbaoxiu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuzhangbaoxiuEntity guzhangbaoxiu = guzhangbaoxiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guzhangbaoxiu,deSens);
        return R.ok().put("data", guzhangbaoxiu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增故障报修")
    public R save(@RequestBody GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guzhangbaoxiu);
        guzhangbaoxiuService.insert(guzhangbaoxiu);
        return R.ok().put("data",guzhangbaoxiu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增故障报修")
    @RequestMapping("/add")
    public R add(@RequestBody GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guzhangbaoxiu);
        guzhangbaoxiuService.insert(guzhangbaoxiu);
        return R.ok().put("data",guzhangbaoxiu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改故障报修")
    public R update(@RequestBody GuzhangbaoxiuEntity guzhangbaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guzhangbaoxiu);
        //全部更新
        guzhangbaoxiuService.updateById(guzhangbaoxiu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除故障报修")
    public R delete(@RequestBody Long[] ids){
        guzhangbaoxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
