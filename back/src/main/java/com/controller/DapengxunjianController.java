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

import com.entity.DapengxunjianEntity;
import com.entity.view.DapengxunjianView;

import com.service.DapengxunjianService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 大棚巡检
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@RestController
@RequestMapping("/dapengxunjian")
public class DapengxunjianController {
    @Autowired
    private DapengxunjianService dapengxunjianService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DapengxunjianEntity dapengxunjian,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			dapengxunjian.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			dapengxunjian.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<DapengxunjianEntity> ew = new EntityWrapper<DapengxunjianEntity>();


        //查询结果
		PageUtils page = dapengxunjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dapengxunjian), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DapengxunjianEntity dapengxunjian,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jilushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jilushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DapengxunjianEntity> ew = new EntityWrapper<DapengxunjianEntity>();
        if(jilushijianstart!=null) ew.ge("jilushijian", jilushijianstart);
        if(jilushijianend!=null) ew.le("jilushijian", jilushijianend);

        //查询结果
		PageUtils page = dapengxunjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dapengxunjian), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DapengxunjianEntity dapengxunjian){
       	EntityWrapper<DapengxunjianEntity> ew = new EntityWrapper<DapengxunjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dapengxunjian, "dapengxunjian"));
        return R.ok().put("data", dapengxunjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DapengxunjianEntity dapengxunjian){
        EntityWrapper< DapengxunjianEntity> ew = new EntityWrapper< DapengxunjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dapengxunjian, "dapengxunjian"));
		DapengxunjianView dapengxunjianView =  dapengxunjianService.selectView(ew);
		return R.ok("查询大棚巡检成功").put("data", dapengxunjianView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DapengxunjianEntity dapengxunjian = dapengxunjianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(dapengxunjian,deSens);
        return R.ok().put("data", dapengxunjian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DapengxunjianEntity dapengxunjian = dapengxunjianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(dapengxunjian,deSens);
        return R.ok().put("data", dapengxunjian);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增大棚巡检")
    public R save(@RequestBody DapengxunjianEntity dapengxunjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dapengxunjian);
        dapengxunjianService.insert(dapengxunjian);
        return R.ok().put("data",dapengxunjian.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增大棚巡检")
    @RequestMapping("/add")
    public R add(@RequestBody DapengxunjianEntity dapengxunjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dapengxunjian);
        dapengxunjianService.insert(dapengxunjian);
        return R.ok().put("data",dapengxunjian.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改大棚巡检")
    public R update(@RequestBody DapengxunjianEntity dapengxunjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dapengxunjian);
        //全部更新
        dapengxunjianService.updateById(dapengxunjian);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除大棚巡检")
    public R delete(@RequestBody Long[] ids){
        dapengxunjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
