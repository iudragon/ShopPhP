package dragon.bakuman.iu.shopphp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dragon.bakuman.iu.shopphp.R;
import dragon.bakuman.iu.shopphp.home.HomeActivity;
import dragon.bakuman.iu.shopphp.login.SignInActivity;
import dragon.bakuman.iu.shopphp.utility.SharePreferenceUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    public void init(){

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // if registered show Home Screen, else show Login Screen

                if (SharePreferenceUtils.getInstance().getString("register_user").equalsIgnoreCase("")){

                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }, 3000);
    }
}
