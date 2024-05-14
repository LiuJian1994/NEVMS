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

import com.cl.entity.CheliangweixiuEntity;
import com.cl.entity.view.CheliangweixiuView;

import com.cl.service.CheliangweixiuService;
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
 * 车辆维修
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@RestController
@RequestMapping("/cheliangweixiu")
public class CheliangweixiuController {
    @Autowired
    private CheliangweixiuService cheliangweixiuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangweixiuEntity cheliangweixiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			cheliangweixiu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheliangweixiuEntity> ew = new EntityWrapper<CheliangweixiuEntity>();

		PageUtils page = cheliangweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangweixiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheliangweixiuEntity cheliangweixiu, 
		HttpServletRequest request){
        EntityWrapper<CheliangweixiuEntity> ew = new EntityWrapper<CheliangweixiuEntity>();

		PageUtils page = cheliangweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangweixiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangweixiuEntity cheliangweixiu){
       	EntityWrapper<CheliangweixiuEntity> ew = new EntityWrapper<CheliangweixiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangweixiu, "cheliangweixiu")); 
        return R.ok().put("data", cheliangweixiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangweixiuEntity cheliangweixiu){
        EntityWrapper< CheliangweixiuEntity> ew = new EntityWrapper< CheliangweixiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangweixiu, "cheliangweixiu")); 
		CheliangweixiuView cheliangweixiuView =  cheliangweixiuService.selectView(ew);
		return R.ok("查询车辆维修成功").put("data", cheliangweixiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangweixiuEntity cheliangweixiu = cheliangweixiuService.selectById(id);
		cheliangweixiu = cheliangweixiuService.selectView(new EntityWrapper<CheliangweixiuEntity>().eq("id", id));
        return R.ok().put("data", cheliangweixiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangweixiuEntity cheliangweixiu = cheliangweixiuService.selectById(id);
		cheliangweixiu = cheliangweixiuService.selectView(new EntityWrapper<CheliangweixiuEntity>().eq("id", id));
        return R.ok().put("data", cheliangweixiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangweixiuEntity cheliangweixiu, HttpServletRequest request){
    	cheliangweixiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangweixiu);
        cheliangweixiuService.insert(cheliangweixiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangweixiuEntity cheliangweixiu, HttpServletRequest request){
    	cheliangweixiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangweixiu);
        cheliangweixiuService.insert(cheliangweixiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheliangweixiuEntity cheliangweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangweixiu);
        cheliangweixiuService.updateById(cheliangweixiu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheliangweixiuService.deleteBatchIds(Arrays.asList(ids));
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
