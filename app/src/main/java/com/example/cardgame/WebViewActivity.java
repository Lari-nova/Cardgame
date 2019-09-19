package com.example.cardgame;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        progressBar = findViewById(R.id.progress_bar);
        webView = findViewById(R.id.web_view_activity);
        webView.setWebChromeClient(new Client());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webView.loadUrl("https://yandex.ru");
    }

    public class Client extends WebChromeClient {

        public void onProgressChanged(WebView view, int newProgress){
            progressBar.setProgress(newProgress);
        }
    }
}
