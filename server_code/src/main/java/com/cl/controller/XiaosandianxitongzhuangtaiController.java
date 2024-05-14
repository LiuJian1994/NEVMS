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

import com.cl.entity.XiaosandianxitongzhuangtaiEntity;
import com.cl.entity.view.XiaosandianxitongzhuangtaiView;

import com.cl.service.XiaosandianxitongzhuangtaiService;
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
 * 小三电系统状态
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 23:19:59
 */
@RestController
@RequestMapping("/xiaosandianxitongzhuangtai")
public class XiaosandianxitongzhuangtaiController {
    @Autowired
    private XiaosandianxitongzhuangtaiService xiaosandianxitongzhuangtaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xiaosandianxitongzhuangtai.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaosandianxitongzhuangtaiEntity> ew = new EntityWrapper<XiaosandianxitongzhuangtaiEntity>();

		PageUtils page = xiaosandianxitongzhuangtaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaosandianxitongzhuangtai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai, 
		HttpServletRequest request){
        EntityWrapper<XiaosandianxitongzhuangtaiEntity> ew = new EntityWrapper<XiaosandianxitongzhuangtaiEntity>();

		PageUtils page = xiaosandianxitongzhuangtaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaosandianxitongzhuangtai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai){
       	EntityWrapper<XiaosandianxitongzhuangtaiEntity> ew = new EntityWrapper<XiaosandianxitongzhuangtaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaosandianxitongzhuangtai, "xiaosandianxitongzhuangtai")); 
        return R.ok().put("data", xiaosandianxitongzhuangtaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai){
        EntityWrapper< XiaosandianxitongzhuangtaiEntity> ew = new EntityWrapper< XiaosandianxitongzhuangtaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaosandianxitongzhuangtai, "xiaosandianxitongzhuangtai")); 
		XiaosandianxitongzhuangtaiView xiaosandianxitongzhuangtaiView =  xiaosandianxitongzhuangtaiService.selectView(ew);
		return R.ok("查询小三电系统状态成功").put("data", xiaosandianxitongzhuangtaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai = xiaosandianxitongzhuangtaiService.selectById(id);
		xiaosandianxitongzhuangtai = xiaosandianxitongzhuangtaiService.selectView(new EntityWrapper<XiaosandianxitongzhuangtaiEntity>().eq("id", id));
        return R.ok().put("data", xiaosandianxitongzhuangtai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai = xiaosandianxitongzhuangtaiService.selectById(id);
		xiaosandianxitongzhuangtai = xiaosandianxitongzhuangtaiService.selectView(new EntityWrapper<XiaosandianxitongzhuangtaiEntity>().eq("id", id));
        return R.ok().put("data", xiaosandianxitongzhuangtai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai, HttpServletRequest request){
    	xiaosandianxitongzhuangtai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaosandianxitongzhuangtai);
        xiaosandianxitongzhuangtaiService.insert(xiaosandianxitongzhuangtai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai, HttpServletRequest request){
    	xiaosandianxitongzhuangtai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaosandianxitongzhuangtai);
        xiaosandianxitongzhuangtaiService.insert(xiaosandianxitongzhuangtai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaosandianxitongzhuangtaiEntity xiaosandianxitongzhuangtai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaosandianxitongzhuangtai);
        xiaosandianxitongzhuangtaiService.updateById(xiaosandianxitongzhuangtai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaosandianxitongzhuangtaiService.deleteBatchIds(Arrays.asList(ids));
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
