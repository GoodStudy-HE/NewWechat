package com.hecw.wechat.servlet;

import com.hecw.web.start.InterfaceUrlInti;
import com.hecw.wechat.common.WeChatTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * 获取token
 *
 * @author:admin
 * @date:2019/11/14
 * @time:15:12
 */
public class TokenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("---获取tokne---");
        try {
            WeChatTask timer = new WeChatTask();
            timer.getToken_getTicket();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
