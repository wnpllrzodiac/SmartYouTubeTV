package com.liskovsoft.smartyoutubetv.interceptors;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.liskovsoft.smartyoutubetv.flavors.webview.SmartYouTubeTVActivity;
import com.liskovsoft.smartyoutubetv.flavors.webview.interceptors.OpenExternalPlayerInterceptor;

public class OpenExternalPlayerInterceptorWithState extends RequestInterceptor {
    private RequestInterceptor mInterceptor;
    private Context mContext;

    public OpenExternalPlayerInterceptorWithState(Context context) {
        mContext = context;
        boolean isWebView = mContext instanceof SmartYouTubeTVActivity;
        boolean isXWalk = mContext instanceof com.liskovsoft.smartyoutubetv.flavors.xwalk.SmartYouTubeTVActivity;
        boolean isExo = mContext instanceof com.liskovsoft.smartyoutubetv.flavors.exoplayer.SmartYouTubeTVActivity;
        if (isWebView) {
            mInterceptor = new OpenExternalPlayerInterceptor(mContext);
        } else if (isXWalk) {
            mInterceptor = new com.liskovsoft.smartyoutubetv.flavors.xwalk.interceptors.OpenExternalPlayerInterceptor(mContext);
        } else if (isExo) {
            mInterceptor = new com.liskovsoft.smartyoutubetv.flavors.exoplayer.interceptors.OpenExternalPlayerInterceptor(mContext);
        }
    }

    @Override
    public boolean test(String url) {
        return mInterceptor.test(url);
    }

    @Override
    public WebResourceResponse intercept(String url) {
        return mInterceptor.intercept(url);
    }
}
