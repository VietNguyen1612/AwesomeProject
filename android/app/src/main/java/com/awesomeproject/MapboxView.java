package com.awesomeproject;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.awesomeproject.databinding.NavigationViewBinding;
import com.mapbox.maps.MapboxMap;
import com.mapbox.navigation.base.options.NavigationOptions;
import com.mapbox.navigation.core.MapboxNavigationProvider;
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp;
import com.mapbox.maps.plugin.LocationPuck2D;
import com.mapbox.navigation.ui.maps.NavigationStyles;
import com.mapbox.navigation.ui.maps.location.NavigationLocationProvider;

public class MapboxView extends FrameLayout {
    private MapboxMap mapboxMap;
    private NavigationViewBinding binding;
    private NavigationLocationProvider navigationLocationProvider;
    public MapboxView(@NonNull Context context) {
        super(context);
        binding = NavigationViewBinding.inflate(LayoutInflater.from(context),this,true);
    }

    public MapboxView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MapboxView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MapboxView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onCreate();
    }


    protected void onCreate(){
        binding.mapView.getMapboxMap().loadStyleUri(NavigationStyles.NAVIGATION_DAY_STYLE);
        MapboxNavigationApp.setup(
                new NavigationOptions.Builder(this.getContext())
                        .accessToken(String.valueOf(R.string.mapbox_access_token))
                        .build()
        );

    }
}
