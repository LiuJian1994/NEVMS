package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
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
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.BaoyangjiluEntity;
import com.cl.entity.view.BaoyangjiluView;

import com.cl.service.BaoyangjiluService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 保养记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@RestController
@RequestMapping("/baoyangjilu")
public class BaoyangjiluController {
    @Autowired
    private BaoyangjiluService baoyangjiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaoyangjiluEntity baoyangjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			baoyangjilu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaoyangjiluEntity> ew = new EntityWrapper<BaoyangjiluEntity>();

		PageUtils page = baoyangjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoyangjilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaoyangjiluEntity baoyangjilu, 
		HttpServletRequest request){
        EntityWrapper<BaoyangjiluEntity> ew = new EntityWrapper<BaoyangjiluEntity>();

		PageUtils page = baoyangjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoyangjilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaoyangjiluEntity baoyangjilu){
       	EntityWrapper<BaoyangjiluEntity> ew = new EntityWrapper<BaoyangjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baoyangjilu, "baoyangjilu")); 
        return R.ok().put("data", baoyangjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaoyangjiluEntity baoyangjilu){
        EntityWrapper< BaoyangjiluEntity> ew = new EntityWrapper< BaoyangjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baoyangjilu, "baoyangjilu")); 
		BaoyangjiluView baoyangjiluView =  baoyangjiluService.selectView(ew);
		return R.ok("查询保养记录成功").put("data", baoyangjiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaoyangjiluEntity baoyangjilu = baoyangjiluService.selectById(id);
		baoyangjilu = baoyangjiluService.selectView(new EntityWrapper<BaoyangjiluEntity>().eq("id", id));
        return R.ok().put("data", baoyangjilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaoyangjiluEntity baoyangjilu = baoyangjiluService.selectById(id);
		baoyangjilu = baoyangjiluService.selectView(new EntityWrapper<BaoyangjiluEntity>().eq("id", id));
        return R.ok().put("data", baoyangjilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaoyangjiluEntity baoyangjilu, HttpServletRequest request){
    	baoyangjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baoyangjilu);
        baoyangjiluService.insert(baoyangjilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaoyangjiluEntity baoyangjilu, HttpServletRequest request){
    	baoyangjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baoyangjilu);
        baoyangjiluService.insert(baoyangjilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaoyangjiluEntity baoyangjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoyangjilu);
        baoyangjiluService.updateById(baoyangjilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baoyangjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
