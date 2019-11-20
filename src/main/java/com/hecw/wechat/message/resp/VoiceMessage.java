package com.hecw.wechat.message.resp;

/**
 * 语音消息
 *
 * @author:admin
 * @date:2019/11/12
 * @time:10:35
 */
public class VoiceMessage extends Voice {
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
