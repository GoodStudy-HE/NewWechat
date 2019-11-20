package com.hecw.web.until;

import java.util.Properties;

/**
 * TODO
 *
 * @author:admin
 * @date:2019/11/13
 * @time:15:17
 */
public class GlobalConstants {
    public static Properties interfaceUrlProperties;


    public static String getInterfaceUrl(String key) {
        return (String) interfaceUrlProperties.get(key);
    }

}
