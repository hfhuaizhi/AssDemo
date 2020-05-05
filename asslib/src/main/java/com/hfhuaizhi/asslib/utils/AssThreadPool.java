package com.hfhuaizhi.asslib.utils;

import android.view.accessibility.AccessibilityEvent;

import com.hfhuaizhi.asslib.AssNode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hfhuaizhi
 * @date 2020/5/5 19:47
 */
public class AssThreadPool {
    private AssNode mCurrentNode;

    private static ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    public void execute(AssNode node, AccessibilityEvent event){
        if(mCurrentNode==node){
            mCurrentNode.updateEvent(event);
        }else {
            mCurrentNode = node;
            mCurrentNode.setEvent(event);
            mThreadPool.execute(node);
        }
    }
}
