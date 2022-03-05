package com.example.springboot.exception.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.exception.map.object.GoodsDO;
import com.example.springboot.exception.map.service.GoodsService;
import com.example.springboot.exception.object.dto.ExportInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ApiController {
    private static Logger log  = LoggerFactory.getLogger(ApiController.class);
    @Resource
    GoodsService goodsService;

    @Resource
    HttpServletResponse response;

    @RequestMapping(value = "/api/export",method = RequestMethod.POST)
    public void exportInfo()  {
        log.info("ceshi123");
        String sheetName = "商品信息";
        log.info("345");
        List<GoodsDO> goodsDOs = goodsService.list();
        log.info(JSONObject.toJSONString(goodsDOs));
        List<ExportInfo> exportInfos = goodsDOs.stream().map(goodsDO -> {
            ExportInfo exportInfo = new ExportInfo();
            BeanUtils.copyProperties(goodsDO,exportInfo);
            return exportInfo;
        }).collect(Collectors.toList());
        //生成easyexcel的流

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyExcel没有关系
        log.info("345");
        try {
            System.out.println(123);
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

            EasyExcel.write(response.getOutputStream()).head(ExportInfo.class).sheet(sheetName).doWrite(exportInfos);
            log.info(response.getOutputStream().toString());
            log.info(JSONObject.toJSONString(exportInfos));
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
