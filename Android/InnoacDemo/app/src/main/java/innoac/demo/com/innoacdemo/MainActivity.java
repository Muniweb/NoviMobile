package innoac.demo.com.innoacdemo;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, List<String>> amenities = new HashMap<>();
    public static HashMap<String, String> parksList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


}
