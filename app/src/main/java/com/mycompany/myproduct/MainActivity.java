package com.mycompany.myproduct;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.aerserv.sdk.AerServBanner;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServEventListener;
import com.aerserv.sdk.AerServSdk;
import com.aerserv.sdk.AerServInterstitial;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button Banner,Interstitial,Rewarded;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Banner=(Button) findViewById(R.id.banner);
        Interstitial=(Button) findViewById(R.id.interstitial);
        Rewarded=(Button) findViewById(R.id.rewarded);
        AerServSdk.init(this, "1017456");
    }

public void loadBanner(View v){

    AerServEventListener listener = new AerServEventListener() {
        @Override
        public void onAerServEvent(AerServEvent event, List params) {
            switch (event) {
                case AD_LOADED:
                    // Execute some code when AD_LOADED event occurs.
                    break;
                case AD_DISMISSED:
                    // Execute some code when AD_DISMISSED event occurs.
                    break;
                case AD_FAILED:
                    // Execute some code when AD_FAILED event occurs.
                    break;
            }
        }
    };
   AerServConfig config = new AerServConfig(this, "1059449");
    //AerServConfig config = new AerServConfig(this, "1060255");
    /**
     * You'll have to pass the AerServEventListener through the the AerServConfig.
     */
    config.setEventListener(listener);
    AerServBanner aerservbanner = (AerServBanner) findViewById(R.id.aerservbanner);
    aerservbanner.configure(config).show();
}



public void loadinterstitial(View v){
    AerServConfig config = new AerServConfig(this, "1056583");
    AerServInterstitial interstitial = new AerServInterstitial(config);
    interstitial.show();


    }

    public void loadrewarded(View v){



    }
}
