package com.hecw.wechat.quartz;
import org.apache.log4j.Logger;
import com.hecw.wechat.common.WeChatTask;

/**
 * 任务执行获取token
 *
 * @author:admin
 * @date:2019/11/13
 * @time:15:26
 */
public class QuartzJob {
    private static Logger logger = Logger.getLogger(QuartzJob.class);
    public void workForToken() {
        try {
            WeChatTask timer = new WeChatTask();
            timer.getToken_getTicket();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
