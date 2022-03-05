package com.example.springboot.exception.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.springboot.exception.MyException;
import com.example.springboot.exception.MyExceptionEnum;
import com.example.springboot.exception.map.object.BaseEntity;
import com.example.springboot.exception.validation.UniqueUser;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.List;

public class UserValidationUtil {
    private static String id;
    /**
     * 实体类id字段值
     */
    private static Integer idValue;
    private static  String field;
    private static  Object fieldValue;
    private static String  db_field;
    private static Object object;
    public static boolean checkUser(String field,String message,Object object,String id){
//       / UserValidationUtil.field = field;
//        UserValidationUtil.object = object;
//        UserValidationUtil.id = id;
//        getFieldValue();
//        BaseEntity entity = (BaseEntity) object;
//
//        // 如果数据重复返回false -> 再返回自定义错误消息到前端
//        if ( idValue == null ){
//            if ( !CollectionUtils.isEmpty(list) ){
//                throw new MyException( 500,message);
//            }
//        } else {
//            if ( !CollectionUtils.isEmpty( list ) ){
//                // fieldValueNew：前端输入字段值
//                Object fieldValueNew = fieldValue;
//
//                // 获取该id所在对象的校验字段值 - 旧数据
//                getFieldValue();
//                if ( !fieldValueNew.equals( fieldValue ) || list.size() > 1 ){
//                    throw new MyException(MyExceptionEnum.NOT_FOUND);
//                }
//            }
//        }
        return true;
    }

    public static void getFieldValue(){
        // ① 获取所有的字段
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            // ② 设置对象中成员 属性private为可读
            f.setAccessible(true);
            // ③ 判断字段注解是否存在
            if ( f.isAnnotationPresent(UniqueUser.class) ) {
                // ④ 如果存在则获取该注解对应的字段,并判断是否与我们要校验的字段一致
                if ( f.getName().equals( field ) ){
                    try {
                        // ⑤ 如果一致则获取其属性值
                        fieldValue = f.get(object);
                        // ⑥ 获取该校验字段对应的数据库字段属性  目的： 给 mybatis-plus 做ar查询使用
                        TableField annotation = f.getAnnotation(TableField.class);
                        db_field = annotation.value();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                // ⑦ 获取id值 -> 作用：判断是插入还是更新操作
                if ( id.equals( f.getName() ) ){
                    try {
                        idValue = (Integer) f.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
