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

import com.entity.ShebeianzhuangEntity;
import com.entity.view.ShebeianzhuangView;

import com.service.ShebeianzhuangService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备安装
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:42
 */
@RestController
@RequestMapping("/shebeianzhuang")
public class ShebeianzhuangController {
    @Autowired
    private ShebeianzhuangService shebeianzhuangService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeianzhuangEntity shebeianzhuang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			shebeianzhuang.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			shebeianzhuang.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShebeianzhuangEntity> ew = new EntityWrapper<ShebeianzhuangEntity>();


        //查询结果
		PageUtils page = shebeianzhuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeianzhuang), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShebeianzhuangEntity shebeianzhuang,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date anzhuangshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date anzhuangshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeianzhuangEntity> ew = new EntityWrapper<ShebeianzhuangEntity>();
        if(anzhuangshijianstart!=null) ew.ge("anzhuangshijian", anzhuangshijianstart);
        if(anzhuangshijianend!=null) ew.le("anzhuangshijian", anzhuangshijianend);

        //查询结果
		PageUtils page = shebeianzhuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeianzhuang), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeianzhuangEntity shebeianzhuang){
       	EntityWrapper<ShebeianzhuangEntity> ew = new EntityWrapper<ShebeianzhuangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeianzhuang, "shebeianzhuang"));
        return R.ok().put("data", shebeianzhuangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeianzhuangEntity shebeianzhuang){
        EntityWrapper< ShebeianzhuangEntity> ew = new EntityWrapper< ShebeianzhuangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeianzhuang, "shebeianzhuang"));
		ShebeianzhuangView shebeianzhuangView =  shebeianzhuangService.selectView(ew);
		return R.ok("查询设备安装成功").put("data", shebeianzhuangView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeianzhuangEntity shebeianzhuang = shebeianzhuangService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeianzhuang,deSens);
        return R.ok().put("data", shebeianzhuang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeianzhuangEntity shebeianzhuang = shebeianzhuangService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeianzhuang,deSens);
        return R.ok().put("data", shebeianzhuang);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增设备安装")
    public R save(@RequestBody ShebeianzhuangEntity shebeianzhuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeianzhuang);
        shebeianzhuangService.insert(shebeianzhuang);
        return R.ok().put("data",shebeianzhuang.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增设备安装")
    @RequestMapping("/add")
    public R add(@RequestBody ShebeianzhuangEntity shebeianzhuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeianzhuang);
        shebeianzhuangService.insert(shebeianzhuang);
        return R.ok().put("data",shebeianzhuang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改设备安装")
    public R update(@RequestBody ShebeianzhuangEntity shebeianzhuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeianzhuang);
        //全部更新
        shebeianzhuangService.updateById(shebeianzhuang);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除设备安装")
    public R delete(@RequestBody Long[] ids){
        shebeianzhuangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
