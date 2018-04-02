package com.itcast.jpush;


import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPushDemo {
    private static final Logger log = LoggerFactory.getLogger(JPushDemo.class);
    private static String masterSecret = "d323dfcfe2a9606aa729b855";
    private static String appKey = "8a40c7f9cf53aad9e23d37a9";
   // private static final String ALERT = "推送信息";

    public static void JPushMessage(String ALERT){
        PushResult pushResult = push(null,ALERT);
        if(pushResult != null && pushResult.isResultOK()){
            log.info("信息推送成功！");
        }else{
            log.info("信息推送失败！");
        }
    }
    public static PushResult push(String alias,String alert){
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jPushClient = new JPushClient(masterSecret,appKey,null,clientConfig);
        PushPayload payload = null;
        if(alias != null && alias != ""){
            payload = buildPushObject_android_ios_alias_alert(alias,alert);
        }else{
            payload = buildPushObject_android_ios_alias_alert(alert);
        }
        try {
            return jPushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static PushPayload buildPushObject_android_ios_alias_alert(String alias,String alert){
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
                        .build())
                .build();
    }
    public static PushPayload buildPushObject_android_ios_alias_alert(String alert){
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
                        .build())
                .build();
    }
}
