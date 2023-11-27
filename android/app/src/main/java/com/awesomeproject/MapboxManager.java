package com.awesomeproject;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class MapboxManager extends SimpleViewManager<MapboxView> {

    ReactApplicationContext mCallerContext;

    public MapboxManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "MapboxNavigation";
    }

    @NonNull
    @Override
    protected MapboxView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new MapboxView(themedReactContext);

    }
}
