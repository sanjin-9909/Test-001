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

import com.entity.ZixunneirongEntity;
import com.entity.view.ZixunneirongView;

import com.service.ZixunneirongService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 资讯内容
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:43
 */
@RestController
@RequestMapping("/zixunneirong")
public class ZixunneirongController {
    @Autowired
    private ZixunneirongService zixunneirongService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunneirongEntity zixunneirong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jishurenyuan")) {
			zixunneirong.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZixunneirongEntity> ew = new EntityWrapper<ZixunneirongEntity>();


        //查询结果
		PageUtils page = zixunneirongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunneirong), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZixunneirongEntity zixunneirong,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZixunneirongEntity> ew = new EntityWrapper<ZixunneirongEntity>();
        if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
        if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

        //查询结果
		PageUtils page = zixunneirongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunneirong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunneirongEntity zixunneirong){
       	EntityWrapper<ZixunneirongEntity> ew = new EntityWrapper<ZixunneirongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunneirong, "zixunneirong"));
        return R.ok().put("data", zixunneirongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunneirongEntity zixunneirong){
        EntityWrapper< ZixunneirongEntity> ew = new EntityWrapper< ZixunneirongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunneirong, "zixunneirong"));
		ZixunneirongView zixunneirongView =  zixunneirongService.selectView(ew);
		return R.ok("查询资讯内容成功").put("data", zixunneirongView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunneirongEntity zixunneirong = zixunneirongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zixunneirong,deSens);
        return R.ok().put("data", zixunneirong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunneirongEntity zixunneirong = zixunneirongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zixunneirong,deSens);
        return R.ok().put("data", zixunneirong);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增资讯内容")
    public R save(@RequestBody ZixunneirongEntity zixunneirong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunneirong);
        zixunneirongService.insert(zixunneirong);
        return R.ok().put("data",zixunneirong.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增资讯内容")
    @RequestMapping("/add")
    public R add(@RequestBody ZixunneirongEntity zixunneirong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunneirong);
        zixunneirongService.insert(zixunneirong);
        return R.ok().put("data",zixunneirong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改资讯内容")
    public R update(@RequestBody ZixunneirongEntity zixunneirong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunneirong);
        //全部更新
        zixunneirongService.updateById(zixunneirong);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核资讯内容")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZixunneirongEntity> list = new ArrayList<ZixunneirongEntity>();
        for(Long id : ids) {
            ZixunneirongEntity zixunneirong = zixunneirongService.selectById(id);
            zixunneirong.setSfsh(sfsh);
            zixunneirong.setShhf(shhf);
            list.add(zixunneirong);
        }
        zixunneirongService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除资讯内容")
    public R delete(@RequestBody Long[] ids){
        zixunneirongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
