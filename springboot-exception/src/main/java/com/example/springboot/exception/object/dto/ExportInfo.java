package com.example.springboot.exception.object.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExportInfo {

    @ExcelProperty(value = "商品名称")
    private String goodsName;

    @ExcelProperty(value = "商品标题")
    private String goodsTitle;

    @ExcelProperty(value = "商品详情")
    private String goodsDetail;

    @ExcelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ExcelProperty(value = "商品图例")
    private String goodsImg;

    @ExcelProperty(value = "商品库存")
    private Integer goodsStock;
}


