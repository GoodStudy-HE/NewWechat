package com.hecw.wechat.controller;

import com.hecw.wechat.dispatcher.MsgDispatcher;
import com.hecw.wechat.util.MessageUtil;
import com.hecw.wechat.util.SignUtil;
import com.hecw.wechat.dispatcher.EventDispatcher;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.Map;

/**
 * 用于接收get参数，返回验证参数
 *
 * @author:admin
 * @date:2019/11/6
 * @time:13:59
 */
@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
    private static Logger logger = Logger.getLogger(WechatSecurity.class);

    /**
     * @param @param request
     * @param @param response
     * @param @param signature
     * @param @param timestamp
     * @param @param nonce
     * @param @param echostr
     * @Description: 用于接收get参数，返回验证参数
     * @author dapengniao
     * @date 2016年3月4日 下午6:20:00
     */
    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("这里存在非法请求！");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    @RequestMapping(value = "security", method = RequestMethod.POST)
    // post方法用于接收微信服务端消息
    public void DoPost(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        try{
            Map<String, String> map=MessageUtil.parseXml(request);
            String msgtype=map.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
                String msgrsp= EventDispatcher.processEvent(map); //进入事件处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            }else{
                String msgrsp= MsgDispatcher.processMessage(map); //进入消息处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            }
        }catch(Exception e){
            logger.error(e,e);
        }
    }
}

