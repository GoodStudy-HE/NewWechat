package com.hecw.wechat.message.resp;

/**
 * 音乐消息
 *
 * @author:admin
 * @date:2019/11/12
 * @time:10:57
 */
public class MusicMessage extends Music {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
