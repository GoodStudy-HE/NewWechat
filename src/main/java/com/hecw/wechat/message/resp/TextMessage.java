package com.hecw.wechat.message.resp;

/**
 * 文本消息消息体
 *
 * @author:admin
 * @date:2019/11/8
 * @time:15:27
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
