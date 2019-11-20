package com.hecw.web.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 项目启动初始化servlet
 *
 * @author:admin
 * @date:2019/11/13
 * @time:15:09
 */
public class InterfaceUrlIntiServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.print("配置信息加载");
        InterfaceUrlInti.init();
    }
}
