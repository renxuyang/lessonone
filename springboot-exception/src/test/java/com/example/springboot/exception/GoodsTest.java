package com.example.springboot.exception;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.example.springboot.exception.controller.ApiController;
import com.example.springboot.exception.map.mapper.GoodsMapper;
import com.example.springboot.exception.map.object.GoodsDO;
import com.example.springboot.exception.map.service.GoodsService;
import com.example.springboot.exception.object.dto.ExportInfo;
import com.example.springboot.exception.repository.ApplicationContextProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class GoodsTest {

    @Resource
    GoodsMapper goodsMapper;
    @Resource
    GoodsService goodsService;
    @Resource
    ApplicationContextProvider applicationContextProvider;
    @Test
    void contextLoads() {
    }

    @Test
    void testGoods(){
        List<GoodsDO> goodsDOs = goodsService.lambdaQuery().eq(GoodsDO::getId,1).list();
        goodsDOs.forEach(System.out::println);
    }
    @Test
    void testSave(){
        for (int i =1; i <1000000;i++){
            String product="商品"+i;
            GoodsDO goodsDO = GoodsDO.builder()
                    .goodsName(product)
                    .goodsPrice(new BigDecimal(10))
                    .goodsDetail("123")
                    .build();
            goodsService.saveOrUpdate(goodsDO);

        }



    }
    @Test
    void testRemove(){
        boolean remove = goodsService.removeById(4);
        System.out.println(remove);


    }
    @Test
    void tableInfo(){
        GoodsDO goodsDO = GoodsDO.builder()
                .goodsName("rxy")
                .goodsDetail("123")
                .build();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(goodsDO.getClass());
        Object res = tableInfo.getPropertyValue(goodsDO, tableInfo.getKeyProperty());
        System.out.println(res.toString());

    }
    @Test
    void testStream(){
        List<GoodsDO> goodsDOs = goodsService.list();
        System.out.println(JSONObject.toJSONString(goodsDOs));
        List<ExportInfo> exportInfos = goodsDOs.stream().map(goodsDO -> {
            ExportInfo exportInfo = new ExportInfo();
            BeanUtils.copyProperties(goodsDO,exportInfo);
            System.out.println(JSONObject.toJSONString(exportInfo));
            return exportInfo;
        }).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(exportInfos));
    }

    @Test
    void testBean(){
        System.out.println(ApplicationContextProvider.getBean("GenericWebApplicationContext"));
}

    @Autowired
    ApiController apiController;
    @Test
    void testExport(){
        apiController.exportInfo();
    }

}
