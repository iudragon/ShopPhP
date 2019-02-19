package dragon.bakuman.iu.shopphp.utility;

import android.content.Context;
import android.content.SharedPreferences;

import dragon.bakuman.iu.shopphp.MyApp;

public class SharePreferenceUtils {

    private static String PREFERENCE_NAME = "shopphp";
    private static SharePreferenceUtils sharePreferenceUtils;
    private SharedPreferences sharedPreferences;

    private SharePreferenceUtils(Context context){

        PREFERENCE_NAME = PREFERENCE_NAME + context.getPackageName();
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharePreferenceUtils getInstance(){

        if (sharePreferenceUtils == null) {
            sharePreferenceUtils = new SharePreferenceUtils(MyApp.getContext());
        }

        return sharePreferenceUtils;
    }

    public void saveString(String key, String val){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.commit();
    }

    public String getString(String key, String defVal){

        return sharedPreferences.getString(key, defVal);
    }

    public String getString(String key){

        return sharedPreferences.getString(key, "");
    }
}








