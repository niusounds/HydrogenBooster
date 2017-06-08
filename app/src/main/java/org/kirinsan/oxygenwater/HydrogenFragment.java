package org.kirinsan.oxygenwater;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.view.View;
import android.webkit.WebView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_main)
public class HydrogenFragment extends Fragment {

    @ViewById
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @AfterViews
    void init() {
        webView.loadUrl("file:///android_asset/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        webView.evaluateJavascript("start();", null);

        webView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onPause() {
        super.onPause();
        webView.evaluateJavascript("stop();", null);
    }
}
