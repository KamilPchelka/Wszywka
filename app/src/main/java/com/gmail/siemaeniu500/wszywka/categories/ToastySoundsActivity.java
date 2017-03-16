package com.gmail.siemaeniu500.wszywka.categories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.gmail.siemaeniu500.wszywka.MainMenuActivity;
import com.gmail.siemaeniu500.wszywka.R;
import com.gmail.siemaeniu500.wszywka.categories.utils.Sound;
import com.gmail.siemaeniu500.wszywka.categories.utils.SoundsAdapter;

import java.util.ArrayList;

public class ToastySoundsActivity extends Activity {
    ListView soundsList;
    SoundsAdapter soundAdapter;
    ArrayList<Sound> soundsArray = new ArrayList<Sound>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_sounds);
        ImageButton ib = (ImageButton) findViewById(R.id.mainMenuButton);
        final ImageButton favouriteButton = (ImageButton) findViewById(R.id.favouriteButton);
        final RelativeLayout inputSearch = (RelativeLayout) findViewById(R.id.searchLayout);
        inputSearch.setVisibility(View.GONE);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ToastySoundsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToastySoundsActivity.this, FavouritesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });


        soundsArray.add(new Sound("chlusniem_aby_nie_usniec_1", "chlusniem aby nie usniec", R.drawable.chlusniem_aby_nie_usniec_1));
        soundsArray.add(new Sound("zdrowko", "zdrowko", R.drawable.zdrowko));
        soundsArray.add(new Sound("lecim_na_szczecin", "lecim na szczecin", R.drawable.lecim_na_szczecin));
        soundsArray.add(new Sound("dziewczeta_zdrowie", "dziewczeta zdrowie", R.drawable.dziewczeta_zdrowie));
        soundsArray.add(new Sound("pierdynkiem_bo_odwykniem", "pierdykiem bo odwykniem", R.drawable.pierdynkiem_bo_odwykniem));
        soundsArray.add(new Sound("dziabiemy_na_3_noge", "na trzecią nogę", R.drawable.dziabiemy_na_3_noge));
        soundsArray.add(new Sound("mianowicie_czas_na_picie", "czas  na picie", R.drawable.mianowicie_czas_na_picie));
        soundsArray.add(new Sound("zdrowie_panowie_i_panie", "zdrowie panowie i panie", R.drawable.zdrowie_panowie_i_panie));
        soundsArray.add(new Sound("na_krzywy_ryj_pijemy", "na krzywy ryj", R.drawable.na_krzywy_ryj_pijemy));
        soundsArray.add(new Sound("zdrowie_tego_co_gorzala", "zdrowie tego", R.drawable.zdrowie_tego_co_gorzala));


        soundAdapter = new SoundsAdapter(ToastySoundsActivity.this, R.layout.row,
                soundsArray);
        soundsList = (ListView) findViewById(R.id.listView);
        soundsList.setItemsCanFocus(false);
        soundsList.setAdapter(soundAdapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }
}