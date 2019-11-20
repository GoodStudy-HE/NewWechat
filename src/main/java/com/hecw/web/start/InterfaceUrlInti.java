package com.hecw.web.start;



import com.hecw.web.until.GlobalConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 项目启动初始化方法
 *
 * @author:admin
 * @date:2019/11/13
 * @time:15:14
 */
public class InterfaceUrlInti {
    public synchronized static void init(){
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        if(GlobalConstants.interfaceUrlProperties==null){
            GlobalConstants.interfaceUrlProperties = new Properties();
        }
        InputStream in = null;
        try {
            in = cl.getResourceAsStream("interface_url.properties");
            props.load(in);
            for(Object key : props.keySet()){
                System.out.print(key);
                System.out.print(props.get(key));
                GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
            }

            props = new Properties();
            in = cl.getResourceAsStream("wechat.properties");
            props.load(in);
            for(Object key : props.keySet()){
                System.out.print(key);
                System.out.print(props.get(key));
                GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }

}
