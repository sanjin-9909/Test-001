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

import com.entity.GuangaijiluEntity;
import com.entity.view.GuangaijiluView;

import com.service.GuangaijiluService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 灌溉记录
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:41
 */
@RestController
@RequestMapping("/guangaijilu")
public class GuangaijiluController {
    @Autowired
    private GuangaijiluService guangaijiluService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuangaijiluEntity guangaijilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			guangaijilu.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GuangaijiluEntity> ew = new EntityWrapper<GuangaijiluEntity>();


        //查询结果
		PageUtils page = guangaijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guangaijilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GuangaijiluEntity guangaijilu,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GuangaijiluEntity> ew = new EntityWrapper<GuangaijiluEntity>();

        //查询结果
		PageUtils page = guangaijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guangaijilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuangaijiluEntity guangaijilu){
       	EntityWrapper<GuangaijiluEntity> ew = new EntityWrapper<GuangaijiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guangaijilu, "guangaijilu"));
        return R.ok().put("data", guangaijiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuangaijiluEntity guangaijilu){
        EntityWrapper< GuangaijiluEntity> ew = new EntityWrapper< GuangaijiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guangaijilu, "guangaijilu"));
		GuangaijiluView guangaijiluView =  guangaijiluService.selectView(ew);
		return R.ok("查询灌溉记录成功").put("data", guangaijiluView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuangaijiluEntity guangaijilu = guangaijiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guangaijilu,deSens);
        return R.ok().put("data", guangaijilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuangaijiluEntity guangaijilu = guangaijiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guangaijilu,deSens);
        return R.ok().put("data", guangaijilu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增灌溉记录")
    public R save(@RequestBody GuangaijiluEntity guangaijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guangaijilu);
        guangaijiluService.insert(guangaijilu);
        return R.ok().put("data",guangaijilu.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增灌溉记录")
    @RequestMapping("/add")
    public R add(@RequestBody GuangaijiluEntity guangaijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guangaijilu);
        guangaijiluService.insert(guangaijilu);
        return R.ok().put("data",guangaijilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改灌溉记录")
    public R update(@RequestBody GuangaijiluEntity guangaijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guangaijilu);
        //全部更新
        guangaijiluService.updateById(guangaijilu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除灌溉记录")
    public R delete(@RequestBody Long[] ids){
        guangaijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
