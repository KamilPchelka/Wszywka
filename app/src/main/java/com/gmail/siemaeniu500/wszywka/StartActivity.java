package com.gmail.siemaeniu500.wszywka;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.facebook.FacebookSdk;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static com.gmail.siemaeniu500.wszywka.categories.utils.SoundsAdapter.mp;

public class StartActivity extends Activity {
    public static boolean isPlaying;
    public static HashMap<String, GlideDrawable> map;
    public static Context context;
    public static Toast toast;
    public static boolean ismessenger;


    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final int PROTOCOL_VERSION = 20150314;
    public static final String YOUR_APP_ID = "[380806812287760]";
    public static final int SHARE_TO_MESSENGER_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        context = this;
        PackageManager pm = context.getPackageManager();
        ismessenger = isPackageInstalled("com.facebook.orca", pm);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_start);


        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                final R.drawable drawableResources = new R.drawable();
                final Class<R.drawable> c = R.drawable.class;
                final Field[] fields = c.getDeclaredFields();
                map = new HashMap<String, GlideDrawable>();


                for (int i = 0, max = fields.length; i < max; i++) {
                    final int resourceId;
                    try {
                        resourceId = fields[i].getInt(drawableResources);
                        String name = fields[i].getName();
                        Bitmap bmp = null;
                        GlideDrawable gbd = Glide.with(StartActivity.context).load(resourceId).into(100, 100).get();
                        map.put(name, gbd);
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }

                }
                GlideDrawable gbd = null;
                try {
                    gbd = Glide.with(StartActivity.context).load(R.mipmap.unliked).into(147, 146).get();
                    map.put("unliked", gbd);
                    gbd = Glide.with(StartActivity.context).load(R.drawable.liked).into(147, 146).get();
                    map.put("liked", gbd);
                    gbd = Glide.with(StartActivity.context).load(R.mipmap.share_button).into(147, 146).get();
                    map.put("share", gbd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                map.put("", gbd);
                return null;
            }
        }.execute();


        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainMenuActivity.class);
                startActivity(intent);
                mp = MediaPlayer.create(context, R.raw.fanfara);
                mp.start();

            }
        });
/*        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {


                    Intent intent = new Intent(StartActivity.this, MainMenuActivity.class);
                    startActivity(intent);


                    }
                },
                3000
        );*/

    }

    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
