package com.example.demo.util;

import java.util.HashMap;

/**
 * SQL输入参数的配置
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 12:53
 */
public class ParameterMap extends HashMap<Object, Object> {
    private static final long serialVersionUID = 1L;

    public ParameterMap(Object... parameters) {
        for (int i = 0; i < parameters.length - 1; i += 2) {
            super.put(parameters[i], parameters[i + 1]);
        }
    }
}
