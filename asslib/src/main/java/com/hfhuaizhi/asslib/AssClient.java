package com.hfhuaizhi.asslib;

/**
 * Created by hfhuaizhi
 * Date: 2020/4/30
 */
public class AssClient {
    private static AssClient INSTANCE;

    private AssClient() {
    }

    public AssClient getInstance() {
        return AssClientHolder.client;
    }

    private static class AssClientHolder {
        private static AssClient client = new AssClient();
    }

}
