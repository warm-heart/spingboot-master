package com.extension.springsourcecode;

/**
 * @author wangqianlong
 * @create 2020-08-23 13:39
 */

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @org.springframework.context.annotation.Scope("prototype")
public class ione {
    @Autowired
    private itwo itwol;


}
