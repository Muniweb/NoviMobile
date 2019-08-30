package innoac.demo.com.innoacdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import im.delight.android.webview.AdvancedWebView;

public class WebUrlActivity extends AppCompatActivity implements AdvancedWebView.Listener{
    WebUrlActivity mContext;

    String webViewUrl;

    private AdvancedWebView mWebView;

    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);

        mContext = this;

        if(getIntent() != null) {
            Bundle data = getIntent().getExtras();
            webViewUrl = data.getString(ApplicationProperty.WEB_VIEW_URL);
            Log.e("webViewUrl",""+webViewUrl);
        }

        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.webview);

        mProgressbar = findViewById(R.id.progressbar);

        mWebView.loadUrl(webViewUrl);
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(String url) {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }
}
