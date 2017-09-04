package com.codekopi.rcvrcv.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by GeekGarden on 31/08/2017.
 */

public class JavascriptAccessor {
  Context mContext;


  public JavascriptAccessor(Context mContext) {
    this.mContext = mContext;
  }

  @SuppressLint("JavascriptInterface")
  public void getYerData(String data) {
    Log.e("TAG", data);
  }
  public void showHTML(String html) {
    String htmlString = html;
  }
}
