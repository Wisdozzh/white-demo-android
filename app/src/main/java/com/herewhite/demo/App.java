package com.herewhite.demo;

import android.app.Application;

import com.google.gson.JsonObject;
import com.herewhite.sdk.Utils.PreFetcher;

public class App extends Application {

    public static JsonObject origins;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        PreFetcher fetcher = new PreFetcher();
        fetcher.setResultCallback(new PreFetcher.ResultCallback() {
            @Override
            public void fetchOriginConfigFail(Exception exception) {

            }

            @Override
            public void fetchOriginConfigSuccess(JsonObject jsonObject) {

            }

            @Override
            public void finishPrefetch(JsonObject jsonObject) {
                origins = jsonObject;
            }
        });
        fetcher.fetchOriginConfigs();
    }
}
