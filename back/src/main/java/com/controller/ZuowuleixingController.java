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

import com.entity.ZuowuleixingEntity;
import com.entity.view.ZuowuleixingView;

import com.service.ZuowuleixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作物类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@RestController
@RequestMapping("/zuowuleixing")
public class ZuowuleixingController {
    @Autowired
    private ZuowuleixingService zuowuleixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuowuleixingEntity zuowuleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZuowuleixingEntity> ew = new EntityWrapper<ZuowuleixingEntity>();


        //查询结果
		PageUtils page = zuowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuowuleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZuowuleixingEntity zuowuleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZuowuleixingEntity> ew = new EntityWrapper<ZuowuleixingEntity>();

        //查询结果
		PageUtils page = zuowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuowuleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuowuleixingEntity zuowuleixing){
       	EntityWrapper<ZuowuleixingEntity> ew = new EntityWrapper<ZuowuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuowuleixing, "zuowuleixing"));
        return R.ok().put("data", zuowuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuowuleixingEntity zuowuleixing){
        EntityWrapper< ZuowuleixingEntity> ew = new EntityWrapper< ZuowuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuowuleixing, "zuowuleixing"));
		ZuowuleixingView zuowuleixingView =  zuowuleixingService.selectView(ew);
		return R.ok("查询作物类型成功").put("data", zuowuleixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuowuleixingEntity zuowuleixing = zuowuleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zuowuleixing,deSens);
        return R.ok().put("data", zuowuleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuowuleixingEntity zuowuleixing = zuowuleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zuowuleixing,deSens);
        return R.ok().put("data", zuowuleixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增作物类型")
    public R save(@RequestBody ZuowuleixingEntity zuowuleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zuowuleixingService.selectCount(new EntityWrapper<ZuowuleixingEntity>().eq("zuowuleixing", zuowuleixing.getZuowuleixing()))>0) {
            return R.error("作物类型已存在");
        }
        //ValidatorUtils.validateEntity(zuowuleixing);
        zuowuleixingService.insert(zuowuleixing);
        return R.ok().put("data",zuowuleixing.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增作物类型")
    @RequestMapping("/add")
    public R add(@RequestBody ZuowuleixingEntity zuowuleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zuowuleixingService.selectCount(new EntityWrapper<ZuowuleixingEntity>().eq("zuowuleixing", zuowuleixing.getZuowuleixing()))>0) {
            return R.error("作物类型已存在");
        }
        //ValidatorUtils.validateEntity(zuowuleixing);
        zuowuleixingService.insert(zuowuleixing);
        return R.ok().put("data",zuowuleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改作物类型")
    public R update(@RequestBody ZuowuleixingEntity zuowuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuowuleixing);
        //验证字段唯一性，否则返回错误信息
        if(zuowuleixingService.selectCount(new EntityWrapper<ZuowuleixingEntity>().ne("id", zuowuleixing.getId()).eq("zuowuleixing", zuowuleixing.getZuowuleixing()))>0) {
            return R.error("作物类型已存在");
        }
        //全部更新
        zuowuleixingService.updateById(zuowuleixing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除作物类型")
    public R delete(@RequestBody Long[] ids){
        zuowuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
