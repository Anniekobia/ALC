package com.example.profilealc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ALCActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView alcpagewebview= findViewById(R.id.alc_page_web_view);
        alcpagewebview.setWebViewClient(new SSLTolerentWebViewClient());
        alcpagewebview.getSettings().setJavaScriptEnabled(true);
        alcpagewebview.loadUrl("https://andela.com/alc/");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView alcpagewebview= findViewById(R.id.alc_page_web_view);
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && alcpagewebview.canGoBack()) {
            alcpagewebview.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }



    public class SSLTolerentWebViewClient extends WebViewClient {
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            switch (error.getPrimaryError()) {
                case SslError.SSL_UNTRUSTED:
                    handler.proceed();
                    break;
                case SslError.SSL_EXPIRED:
                    handler.proceed();
                    break;
                case SslError.SSL_IDMISMATCH:
                    handler.proceed();
                    break;
                case SslError.SSL_NOTYETVALID:
                    handler.proceed();
                    break;
            }
        }
    }



}
