package com.example.springboot.exception.map.object;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data //生成set get 方法  需要引入lombok插件和jar
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;          //id
//    private Date createTime;     //创建时间
//    private Integer createPaper;  //创建人
//    private Date updateTime;     //更新时间
//    private Integer updatePaper; //修改人
}
