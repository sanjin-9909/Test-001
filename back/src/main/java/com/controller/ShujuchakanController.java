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

import com.entity.ShujuchakanEntity;
import com.entity.view.ShujuchakanView;

import com.service.ShujuchakanService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 数据查看
 * 后端接口
 * @author 
 * @email 
 * @date 2026-01-05 10:45:40
 */
@RestController
@RequestMapping("/shujuchakan")
public class ShujuchakanController {
    @Autowired
    private ShujuchakanService shujuchakanService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShujuchakanEntity shujuchakan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("hezuoshe")) {
			shujuchakan.setXinyongdaima((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("nonghu")) {
			shujuchakan.setNonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jishurenyuan")) {
			shujuchakan.setJishuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShujuchakanEntity> ew = new EntityWrapper<ShujuchakanEntity>();


        //查询结果
		PageUtils page = shujuchakanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujuchakan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShujuchakanEntity shujuchakan,
                @RequestParam(required = false) Double wendustart,
                @RequestParam(required = false) Double wenduend,
                @RequestParam(required = false) Double shidustart,
                @RequestParam(required = false) Double shiduend,
                @RequestParam(required = false) Double guangzhaostart,
                @RequestParam(required = false) Double guangzhaoend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fenxishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fenxishijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShujuchakanEntity> ew = new EntityWrapper<ShujuchakanEntity>();
        if(wendustart!=null) ew.ge("wendu", wendustart);
        if(wenduend!=null) ew.le("wendu", wenduend);
        if(shidustart!=null) ew.ge("shidu", shidustart);
        if(shiduend!=null) ew.le("shidu", shiduend);
        if(guangzhaostart!=null) ew.ge("guangzhao", guangzhaostart);
        if(guangzhaoend!=null) ew.le("guangzhao", guangzhaoend);
        if(fenxishijianstart!=null) ew.ge("fenxishijian", fenxishijianstart);
        if(fenxishijianend!=null) ew.le("fenxishijian", fenxishijianend);

        //查询结果
		PageUtils page = shujuchakanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujuchakan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShujuchakanEntity shujuchakan){
       	EntityWrapper<ShujuchakanEntity> ew = new EntityWrapper<ShujuchakanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shujuchakan, "shujuchakan"));
        return R.ok().put("data", shujuchakanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShujuchakanEntity shujuchakan){
        EntityWrapper< ShujuchakanEntity> ew = new EntityWrapper< ShujuchakanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shujuchakan, "shujuchakan"));
		ShujuchakanView shujuchakanView =  shujuchakanService.selectView(ew);
		return R.ok("查询数据查看成功").put("data", shujuchakanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShujuchakanEntity shujuchakan = shujuchakanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shujuchakan,deSens);
        return R.ok().put("data", shujuchakan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShujuchakanEntity shujuchakan = shujuchakanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shujuchakan,deSens);
        return R.ok().put("data", shujuchakan);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增数据查看")
    public R save(@RequestBody ShujuchakanEntity shujuchakan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shujuchakanService.selectCount(new EntityWrapper<ShujuchakanEntity>().eq("dapengbianhao", shujuchakan.getDapengbianhao()))>0) {
            return R.error("大棚编号已存在");
        }
        //ValidatorUtils.validateEntity(shujuchakan);
        shujuchakanService.insert(shujuchakan);
        return R.ok().put("data",shujuchakan.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("新增数据查看")
    @RequestMapping("/add")
    public R add(@RequestBody ShujuchakanEntity shujuchakan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shujuchakanService.selectCount(new EntityWrapper<ShujuchakanEntity>().eq("dapengbianhao", shujuchakan.getDapengbianhao()))>0) {
            return R.error("大棚编号已存在");
        }
        //ValidatorUtils.validateEntity(shujuchakan);
        shujuchakanService.insert(shujuchakan);
        return R.ok().put("data",shujuchakan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改数据查看")
    public R update(@RequestBody ShujuchakanEntity shujuchakan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shujuchakan);
        //验证字段唯一性，否则返回错误信息
        if(shujuchakanService.selectCount(new EntityWrapper<ShujuchakanEntity>().ne("id", shujuchakan.getId()).eq("dapengbianhao", shujuchakan.getDapengbianhao()))>0) {
            return R.error("大棚编号已存在");
        }
        //全部更新
        shujuchakanService.updateById(shujuchakan);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除数据查看")
    public R delete(@RequestBody Long[] ids){
        shujuchakanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
