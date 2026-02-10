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

import com.entity.ShifeijiluEntity;
import com.entity.view.ShifeijiluView;

import com.service.ShifeijiluService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 施肥记录
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
@RestController
@RequestMapping("/shifeijilu")
public class ShifeijiluController {
    @Autowired
    private ShifeijiluService shifeijiluService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShifeijiluEntity shifeijilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			shifeijilu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShifeijiluEntity> ew = new EntityWrapper<ShifeijiluEntity>();


        //查询结果
		PageUtils page = shifeijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shifeijilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShifeijiluEntity shifeijilu,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShifeijiluEntity> ew = new EntityWrapper<ShifeijiluEntity>();

        //查询结果
		PageUtils page = shifeijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shifeijilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShifeijiluEntity shifeijilu){
       	EntityWrapper<ShifeijiluEntity> ew = new EntityWrapper<ShifeijiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shifeijilu, "shifeijilu"));
        return R.ok().put("data", shifeijiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShifeijiluEntity shifeijilu){
        EntityWrapper< ShifeijiluEntity> ew = new EntityWrapper< ShifeijiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shifeijilu, "shifeijilu"));
		ShifeijiluView shifeijiluView =  shifeijiluService.selectView(ew);
		return R.ok("查询施肥记录成功").put("data", shifeijiluView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShifeijiluEntity shifeijilu = shifeijiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shifeijilu,deSens);
        return R.ok().put("data", shifeijilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShifeijiluEntity shifeijilu = shifeijiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shifeijilu,deSens);
        return R.ok().put("data", shifeijilu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增施肥记录")
    public R save(@RequestBody ShifeijiluEntity shifeijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shifeijilu);
        shifeijiluService.insert(shifeijilu);
        return R.ok().put("data",shifeijilu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增施肥记录")
    @RequestMapping("/add")
    public R add(@RequestBody ShifeijiluEntity shifeijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shifeijilu);
        shifeijiluService.insert(shifeijilu);
        return R.ok().put("data",shifeijilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改施肥记录")
    public R update(@RequestBody ShifeijiluEntity shifeijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shifeijilu);
        //全部更新
        shifeijiluService.updateById(shifeijilu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除施肥记录")
    public R delete(@RequestBody Long[] ids){
        shifeijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
