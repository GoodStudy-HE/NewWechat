package com.hecw.wechat.message.req;

/**
 * 图片消息
 *
 * @author:admin
 * @date:2019/11/8
 * @time:15:16
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
