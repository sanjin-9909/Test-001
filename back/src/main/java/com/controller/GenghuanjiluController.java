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

import com.entity.GenghuanjiluEntity;
import com.entity.view.GenghuanjiluView;

import com.service.GenghuanjiluService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 更换记录
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
@RestController
@RequestMapping("/genghuanjilu")
public class GenghuanjiluController {
    @Autowired
    private GenghuanjiluService genghuanjiluService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GenghuanjiluEntity genghuanjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			genghuanjilu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jishurenyuan")) {
			genghuanjilu.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GenghuanjiluEntity> ew = new EntityWrapper<GenghuanjiluEntity>();


        //查询结果
		PageUtils page = genghuanjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, genghuanjilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GenghuanjiluEntity genghuanjilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date genghuanshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date genghuanshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GenghuanjiluEntity> ew = new EntityWrapper<GenghuanjiluEntity>();
        if(genghuanshijianstart!=null) ew.ge("genghuanshijian", genghuanshijianstart);
        if(genghuanshijianend!=null) ew.le("genghuanshijian", genghuanshijianend);

        //查询结果
		PageUtils page = genghuanjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, genghuanjilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GenghuanjiluEntity genghuanjilu){
       	EntityWrapper<GenghuanjiluEntity> ew = new EntityWrapper<GenghuanjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( genghuanjilu, "genghuanjilu"));
        return R.ok().put("data", genghuanjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GenghuanjiluEntity genghuanjilu){
        EntityWrapper< GenghuanjiluEntity> ew = new EntityWrapper< GenghuanjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( genghuanjilu, "genghuanjilu"));
		GenghuanjiluView genghuanjiluView =  genghuanjiluService.selectView(ew);
		return R.ok("查询更换记录成功").put("data", genghuanjiluView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GenghuanjiluEntity genghuanjilu = genghuanjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(genghuanjilu,deSens);
        return R.ok().put("data", genghuanjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GenghuanjiluEntity genghuanjilu = genghuanjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(genghuanjilu,deSens);
        return R.ok().put("data", genghuanjilu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增更换记录")
    public R save(@RequestBody GenghuanjiluEntity genghuanjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(genghuanjilu);
        genghuanjiluService.insert(genghuanjilu);
        return R.ok().put("data",genghuanjilu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增更换记录")
    @RequestMapping("/add")
    public R add(@RequestBody GenghuanjiluEntity genghuanjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(genghuanjilu);
        genghuanjiluService.insert(genghuanjilu);
        return R.ok().put("data",genghuanjilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改更换记录")
    public R update(@RequestBody GenghuanjiluEntity genghuanjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(genghuanjilu);
        //全部更新
        genghuanjiluService.updateById(genghuanjilu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除更换记录")
    public R delete(@RequestBody Long[] ids){
        genghuanjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
