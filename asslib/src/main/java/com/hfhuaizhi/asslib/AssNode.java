package com.hfhuaizhi.asslib;

import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Created by hfhuaizhi
 * Date: 2020/4/30
 */
public class AssNode implements Runnable {
    public AssNode next;
    private String msg;
    private String clickId;
    private String nodePackage;
    private String nodeActivity;
    private AssClient mClient;

    private static final int RETRY_TIME = 5;
    private static final int SLEEP_TIME = 200;

    private AccessibilityEvent currentEvent;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getClickId() {
        return clickId;
    }

    public void setClickId(String clickId) {
        this.clickId = clickId;
    }

    public void updateEvent(AccessibilityEvent event) {
        currentEvent = event;
    }

    @Override
    public void run() {
        AccessibilityNodeInfo info = null;
        if (!TextUtils.isEmpty(msg)) {
            int i = 0;
            while (info == null) {
                info = mClient.findViewByText(msg);
                if (i++ >= 1) {
                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i > RETRY_TIME) {
                    break;
                }
            }
        }
        if(info==null&&!TextUtils.isEmpty(clickId)){
            int i = 0;
            while (info == null) {
                info = mClient.findViewByID(clickId);
                if (i++ >= 1) {
                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i > RETRY_TIME) {
                    break;
                }
            }
        }
    }

    public void setEvent(AccessibilityEvent event) {
        currentEvent = event;
    }
}
