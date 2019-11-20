package com.hecw.wechat.message.resp;

/**
 * 图片消息
 *
 * @author:admin
 * @date:2019/11/8
 * @time:15:33
 */
public class ImageMessage extends BaseMessage {
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
