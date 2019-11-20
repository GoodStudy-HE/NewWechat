package com.hecw.wechat.message.req;

/**
 * 文本消息
 *
 * @author:admin
 * @date:2019/11/8
 * @time:15:14
 */
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
