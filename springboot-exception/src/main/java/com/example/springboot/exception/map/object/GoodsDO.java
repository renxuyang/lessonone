package com.example.springboot.exception.map.object;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;

@Data
@Builder
@TableName(value = "goods")
public class GoodsDO extends BaseEntity {

    @TableField(value = "goods_name")
    private String goodsName;

    @TableField(value = "goods_title")
    private String goodsTitle;

    @TableField(value = "goods_detail")
    private String goodsDetail;

    @TableField(value = "goods_price")
    private BigDecimal goodsPrice;

    @TableField(value = "goods_img")
    private String goodsImg;

    @TableField(value = "goods_stock")
    private Integer goodsStock;

    @TableLogic(value = "1", delval = "0")
    private Integer status;

    @Tolerate
    public GoodsDO(){

    }
}
