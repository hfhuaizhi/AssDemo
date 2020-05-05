package com.hfhuaizhi.asslib.service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

import com.hfhuaizhi.asslib.AssClient;

public class AccessibilitySampleService extends AccessibilityService {
    private AssClient mClient;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AssClient.init(getApplicationContext(), this);
        mClient = AssClient.getInstance();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (mClient != null) {
            mClient.onEvent(event);
        }
    }

    @Override
    public void onInterrupt() {

    }
}