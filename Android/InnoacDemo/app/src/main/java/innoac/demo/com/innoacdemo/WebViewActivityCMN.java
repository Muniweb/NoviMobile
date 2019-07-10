package innoac.demo.com.innoacdemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebViewActivityCMN extends AppCompatActivity {


    WebView webView;
    String mAppTitle, mUrl;
    Intent mIntent;
    private ProgressBar mProgressDialog;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);

        mIntent = getIntent();
        mUrl = mIntent.getStringExtra("myurl");
        Uri myUri = Uri.parse(mUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(myUri);
        intent.setPackage("com.android.chrome");
        startActivity(intent);
        finish();
//        mAppTitle = mIntent.getStringExtra("objname");
//        webView = findViewById(R.id.webView1);
//        getSupportActionBar().setTitle(mAppTitle);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconsbackk);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
////        webView.setInitialScale(1);
//        webView.setPadding(0, 0, 0, 0);
//        webView.setInitialScale(100);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
//        webView.setScrollbarFadingEnabled(false);
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setBuiltInZoomControls(true);
//
////        webView.setInitialScale(160);
//
////        mProgressDialog = new ProgressBar(WebViewActivityCMN.this);
////        webView.setWebViewClient(new MyWebViewClient(mProgressDialog));
//
//        webView.setWebViewClient(new MyWebViewClient());
//        webView.loadUrl(mUrl);
//
//    }
//
//
//    @Override
//    public void onPause() {
//        super.onPause();
//
//
//    }
//
//    private class MyWebViewClient extends WebViewClient {
////        private ProgressBar progressBar;
////
////        public MyWebViewClient(ProgressBar progressBar) {
////            this.progressBar = progressBar;
////            progressBar.setVisibility(View.VISIBLE);
////
////        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            // TODO Auto-generated method stub
//            if (url.startsWith("mailto:")) {
//                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse(url));
//                startActivity(i);
//            } else if (url.startsWith("tel:")) {
//                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(url));
//                if (isPermissionGranted()) {
//                    if (ActivityCompat.checkSelfPermission(WebViewActivityCMN.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                        return true;
//                    }
//                    startActivity(i);
//                }
//
//            } else {
//                view.loadUrl(url);
//            }
//            return true;
//        }
//
//        @Override
//        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
//            handler.proceed();
//            final AlertDialog.Builder builder = new AlertDialog.Builder(WebViewActivityCMN.this);
//            builder.setMessage("The Webpage you are requesting is secure, would you like to proceed?");
//            builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    handler.proceed();
//                }
//            });
//            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    handler.cancel();
//                }
//            });
//            final AlertDialog dialog = builder.create();
//            dialog.show();
//        }
//
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
////            super.onPageFinished(view, url);
////            progressBar.setVisibility(View.GONE);
//        }
//    }
//
//    public boolean isPermissionGranted() {
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
//                    == PackageManager.PERMISSION_GRANTED) {
//                return true;
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
//                return false;
//            }
//        } else { //permission is automatically granted on sdk<23 upon installation
//            return true;
//        }
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//
//            case 1: {
//
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                } else {
//                }
//                return;
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request
//        }
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // todo: goto back activity from here
//                finish();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
    }

}