package com.gmail.siemaeniu500.wszywka;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.gmail.siemaeniu500.wszywka.categories.AllSoundsActivity;
import com.gmail.siemaeniu500.wszywka.categories.FavouritesActivity;
import com.gmail.siemaeniu500.wszywka.categories.PowiedzonkaSoundsActivity;
import com.gmail.siemaeniu500.wszywka.categories.ReakcjeSoundsActivity;
import com.gmail.siemaeniu500.wszywka.categories.ToastySoundsActivity;
import com.gmail.siemaeniu500.wszywka.categories.ZloteMysliSoundsActivity;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);
        final ImageButton allsoundsbutton = (ImageButton) findViewById(R.id.all_sounds_button);
        final ImageButton toastysbutton = (ImageButton) findViewById(R.id.toasty);
        final ImageButton zlotemyslibutton = (ImageButton) findViewById(R.id.zlote_mysli);
        final ImageButton reakcjebutton = (ImageButton) findViewById(R.id.reakcje);
        final ImageButton powiedzonkabutton = (ImageButton) findViewById(R.id.powiedzonka);
        final ImageButton favouriteButton = (ImageButton) findViewById(R.id.favouriteButton);
        final LinearLayout mRelativeLayout = (LinearLayout) findViewById(R.id.linearLayout);
        ImageButton mButton = (ImageButton) findViewById(R.id.mainMenuButton2);
        final RelativeLayout back_dim_layout = (RelativeLayout) findViewById(R.id.bac_dim_layout);
        final Context mContext = getApplicationContext();


        if(StartActivity.map == null){

            Intent intent = new Intent(MainMenuActivity.this, StartActivity.class);
            startActivity(intent);

        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);


                View customView = inflater.inflate(R.layout.popup_window, null);

                final PopupWindow mPopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                mPopupWindow.setFocusable(true);

                back_dim_layout.setVisibility(View.VISIBLE);

                mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        back_dim_layout.setVisibility(View.GONE);
                    }
                });

                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }


                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER, 0, 0);
            }
        });


        allsoundsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Thread second = new Thread() {
                    public void run() {
                        Intent intent = new Intent(MainMenuActivity.this, AllSoundsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    }
                };
                second.start();


            }
        });

        toastysbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Thread second = new Thread() {
                    public void run() {
                        Intent intent = new Intent(MainMenuActivity.this, ToastySoundsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    }
                };
                second.start();


            }
        });

        zlotemyslibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Thread second = new Thread() {
                    public void run() {
                        Intent intent = new Intent(MainMenuActivity.this, ZloteMysliSoundsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    }
                };
                second.start();


            }
        });

        reakcjebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Thread second = new Thread() {
                    public void run() {
                        Intent intent = new Intent(MainMenuActivity.this, ReakcjeSoundsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    }
                };
                second.start();


            }
        });

        powiedzonkabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Thread second = new Thread() {
                    public void run() {
                        Intent intent = new Intent(MainMenuActivity.this, PowiedzonkaSoundsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    }
                };
                second.start();


            }
        });


        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, FavouritesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });
    }




    @Override
    public void onBackPressed() {
        finish();
    }


    public void onClick(View v) {


    }
}
