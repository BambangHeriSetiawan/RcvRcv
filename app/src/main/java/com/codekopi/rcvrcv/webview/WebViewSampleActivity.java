package com.codekopi.rcvrcv.webview;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import java.util.HashMap;
import java.util.Map;

public class WebViewSampleActivity extends AppCompatActivity {
  @BindView(R.id.wvSample)
  WebView wvSample;
  //String url = "https://android-labs-638b8.firebaseapp.com/";
  String url = "https://www.google.co.id/";

  private WebSettings wvSetting;

  @SuppressLint("JavascriptInterface")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web_view_sample);
    ButterKnife.bind(this);
    Map<String, String> extraHeaders = new HashMap<String, String>();
    extraHeaders.put("Accept","application/json");
    extraHeaders.put("Authorization","9FwCqO1UElEwaVPhdTD4xn0LxdlL5JXKjrkPu5KLvEdshzmab9YAHObFfczB");
    //wvSample.loadUrl(url);
    wvSample.loadUrl(url,extraHeaders);
    Log.e("onCreate", "WebViewSampleActivity" + wvSample.getOriginalUrl());
    wvSetting = wvSample.getSettings();
    wvSetting.setJavaScriptEnabled(true);
    wvSetting.setDomStorageEnabled(true);

    wvSample.setWebChromeClient(new WebChromeClient());
  }


}
