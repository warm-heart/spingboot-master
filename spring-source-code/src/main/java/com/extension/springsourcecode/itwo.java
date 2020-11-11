package com.extension.springsourcecode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2020-08-23 13:39
 */

@Component
// @org.springframework.context.annotation.Scope("prototype")
public class itwo {
    @Autowired
    ione ione;

}
