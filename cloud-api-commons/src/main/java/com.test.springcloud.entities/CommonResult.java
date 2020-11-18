package com.test.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: 兴希
 * Date: 2020/11/6
 * Time: 9:35
 * Description: No Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

//    public CommonResult(Integer code, String msg, T data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }

//    public CommonResult(Integer code, String msg) {
//        this(code,msg,null);
//    }
}
