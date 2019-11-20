package com.hecw.wechat.dispatcher;

import com.hecw.wechat.message.resp.Image;
import com.hecw.wechat.message.resp.ImageMessage;
import com.hecw.wechat.util.HttpPostUploadUtil;
import com.hecw.wechat.util.MessageUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件消息业务分发器
 *
 * @author:admin
 * @date:2019/11/12
 * @time:14:40
 */
public class EventDispatcher {
    private static Logger logger = Logger.getLogger(EventDispatcher.class);

    public static String processEvent(Map<String, String> map){
        String openid = map.get("FromUserName"); //用户openid
        String mpid = map.get("ToUserName");   //公众号原始ID
        ImageMessage imgmsg = new ImageMessage();
        imgmsg.setToUserName(openid);
        imgmsg.setFromUserName(mpid);
        imgmsg.setCreateTime(new Date().getTime());
        imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
            // 关注事件
            System.out.println("==============这是关注事件！");
            Image img = new Image();
            HttpPostUploadUtil util = new HttpPostUploadUtil();
            String filepath = "C:\\Users\\admin\\Desktop\\钓鱼岛.png";
            Map<String, String> textMap = new HashMap<String, String>();
            textMap.put("name", "testname");
            Map<String, String> fileMap = new HashMap<String, String>();
            fileMap.put("userfile", filepath);
            String mediaidrs = util.formUpload(textMap, fileMap);
            System.out.println(mediaidrs);
            String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
            img.setMediaId(mediaid);
            imgmsg.setImage(img);
            return MessageUtil.imageMessageToXml(imgmsg);
        }else if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)){
            System.out.println("============这是点击事件");

        }

        return null;
    }
}