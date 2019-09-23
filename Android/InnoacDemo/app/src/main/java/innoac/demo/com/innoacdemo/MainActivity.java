package innoac.demo.com.innoacdemo;

import android.Manifest;
import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import com.estimotelib.EstimoLibUtil;
import com.estimotelib.EstimoNotificationsManager;
import com.estimotelib.OnBeaconMessageListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, List<String>> amenities = new HashMap<>();
    public static HashMap<String, String> parksList = new HashMap<>();

    final String appId = "myrealestategenie-eqn";
    final String appToken = "5e33390906dc0ef9a593fa7abc66119b";
    EstimoLibUtil util;

    OnBeaconMessageListener mBeaconMessageListener;

    public EstimoNotificationsManager mNm;

    TelephonyManager mTelephonyManager;

    public MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mNm = new EstimoNotificationsManager(this);
        initBeacon();
        requestSinglePermission();

        getSupportActionBar().setDisplayShowHomeEnabled(false);
//displaying custom ActionBar
        View mActionBarView = getLayoutInflater().inflate(R.layout.my_actionbar, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.RoadConstruction);
                urlIntent.putExtra("objname", getResources().getString(R.string.road_construction));
                startActivity(urlIntent);

            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.Parks);
                urlIntent.putExtra("objname", getResources().getString(R.string.evnt_regis));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.DevelopmentProject);
                urlIntent.putExtra("objname", getResources().getString(R.string.development_projects));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.CityWebsite);
                urlIntent.putExtra("objname", getResources().getString(R.string.city_website));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.Calender);
                urlIntent.putExtra("objname", getResources().getString(R.string.calender));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.PayBill);
                urlIntent.putExtra("objname", getResources().getString(R.string.pay_bill));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.CityDirectory);
                urlIntent.putExtra("objname", getResources().getString(R.string.city_directory));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.Job);
                urlIntent.putExtra("objname", getResources().getString(R.string.job_opportunity));
                startActivity(urlIntent);
            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.ReportAnIssue);
                urlIntent.putExtra("objname", getResources().getString(R.string.report_an_issue));
                startActivity(urlIntent);
            }
        });

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.SEARCH);
                urlIntent.putExtra("objname", getResources().getString(R.string.search));
                startActivity(urlIntent);
            }
        });

        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.RECERATION);
                urlIntent.putExtra("objname", getResources().getString(R.string.recreation));
                startActivity(urlIntent);
            }
        });

        findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.FACEBOOK);
                urlIntent.putExtra("objname", getResources().getString(R.string.facebook));
                startActivity(urlIntent);
            }
        });

        findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.STAFF_DIRECTORY);
                urlIntent.putExtra("objname", getResources().getString(R.string.staff_directory));
                startActivity(urlIntent);
            }
        });

        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(MainActivity.this, WebViewActivityCMN.class);
                urlIntent.putExtra("myurl", ApplicationProperty.Video);
                urlIntent.putExtra("objname", getResources().getString(R.string.studio));
                startActivity(urlIntent);
            }
        });
    }

    private void initBeacon() {
        util = new EstimoLibUtil(appId,appToken,this);
        util.startMonitoring(this,MainActivity.class,false
                ,getResources().getString(R.string.app_name));
    }

    public void requestSinglePermission() {

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_PHONE_STATE)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
                        /* ... */
                        getIMEI();
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {
                        /* ... */
                        showPermissionsAlert();
                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        /* ... */
                        token.continuePermissionRequest();
                    }
                }).check();

    }

    private void getIMEI() {
        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        String deviceid = mTelephonyManager.getDeviceId();
        mNm.getAppNameIMEINumber(deviceid);
        mNm.sendAddUserRequest(this,"",getResources().getString(R.string.app_name));
        Log.e("DASHBOARD", "DeviceImei " + deviceid);
    }

    /**
     * Alert dialog to navigate to app settings
     * to enable necessary permissions
     */
    private void showPermissionsAlert() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Permissions required!")
                .setMessage("RealEstate needs few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        openSettings();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if(intent.getAction().equalsIgnoreCase(getResources().getString(R.string.app_name))) {
                    String url = intent.getStringExtra("url");
                    Log.e("DASH_BOARD","URL : "+url);

                    if(!url.equalsIgnoreCase("null")){
                        Intent it = new Intent(mContext,WebUrlActivity.class);
                        it.putExtra(ApplicationProperty.WEB_VIEW_URL,url);
                        startActivity(it);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(mContext).registerReceiver((receiver),
                new IntentFilter(getResources().getString(R.string.app_name)));
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        util.setBeaconMessageListener(mBeaconMessageListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        util.removeBeaconMessageListener();
    }
}
