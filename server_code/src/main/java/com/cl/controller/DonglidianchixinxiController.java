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

import com.cl.entity.DonglidianchixinxiEntity;
import com.cl.entity.view.DonglidianchixinxiView;

import com.cl.service.DonglidianchixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.File;
import com.cl.utils.BaiduUtil;
import org.springframework.util.ResourceUtils;
import java.io.FileNotFoundException;

/**
 * 动力电池信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@RestController
@RequestMapping("/donglidianchixinxi")
public class DonglidianchixinxiController {
    @Autowired
    private DonglidianchixinxiService donglidianchixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DonglidianchixinxiEntity donglidianchixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			donglidianchixinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DonglidianchixinxiEntity> ew = new EntityWrapper<DonglidianchixinxiEntity>();

		PageUtils page = donglidianchixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, donglidianchixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DonglidianchixinxiEntity donglidianchixinxi, 
		HttpServletRequest request){
        EntityWrapper<DonglidianchixinxiEntity> ew = new EntityWrapper<DonglidianchixinxiEntity>();

		PageUtils page = donglidianchixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, donglidianchixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DonglidianchixinxiEntity donglidianchixinxi){
       	EntityWrapper<DonglidianchixinxiEntity> ew = new EntityWrapper<DonglidianchixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( donglidianchixinxi, "donglidianchixinxi")); 
        return R.ok().put("data", donglidianchixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DonglidianchixinxiEntity donglidianchixinxi){
        EntityWrapper< DonglidianchixinxiEntity> ew = new EntityWrapper< DonglidianchixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( donglidianchixinxi, "donglidianchixinxi")); 
		DonglidianchixinxiView donglidianchixinxiView =  donglidianchixinxiService.selectView(ew);
		return R.ok("查询动力电池信息成功").put("data", donglidianchixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DonglidianchixinxiEntity donglidianchixinxi = donglidianchixinxiService.selectById(id);
		donglidianchixinxi = donglidianchixinxiService.selectView(new EntityWrapper<DonglidianchixinxiEntity>().eq("id", id));
        return R.ok().put("data", donglidianchixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DonglidianchixinxiEntity donglidianchixinxi = donglidianchixinxiService.selectById(id);
		donglidianchixinxi = donglidianchixinxiService.selectView(new EntityWrapper<DonglidianchixinxiEntity>().eq("id", id));
        return R.ok().put("data", donglidianchixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DonglidianchixinxiEntity donglidianchixinxi, HttpServletRequest request){
    	donglidianchixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(donglidianchixinxi);
        donglidianchixinxiService.insert(donglidianchixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DonglidianchixinxiEntity donglidianchixinxi, HttpServletRequest request){
    	donglidianchixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(donglidianchixinxi);
        donglidianchixinxiService.insert(donglidianchixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DonglidianchixinxiEntity donglidianchixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(donglidianchixinxi);
        donglidianchixinxiService.updateById(donglidianchixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        donglidianchixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







    /**
     * 文字识别
     */
    @RequestMapping("/baidu/ocr")
    @IgnoreAuth
    public R baiduOcr(@RequestParam("fileName") String fileName,HttpServletRequest request) {
        String ss = "";
        try {
            File path = new File(ResourceUtils.getURL("classpath:static").getPath());
            if(!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(),"/file/");
            if(!upload.exists()) {
                upload.mkdirs();
            }
            File file = new File(upload.getAbsolutePath()+"/"+fileName);
            if(file.exists()){
                ss = BaiduUtil.generalString(file.getAbsolutePath(), false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return R.ok().put("data", ss);
    }

}
