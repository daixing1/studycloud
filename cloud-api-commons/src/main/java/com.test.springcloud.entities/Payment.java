package com.test.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: 兴希
 * Date: 2020/11/6
 * Time: 9:34
 * Description: No Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long id;
    private String serial;
}
