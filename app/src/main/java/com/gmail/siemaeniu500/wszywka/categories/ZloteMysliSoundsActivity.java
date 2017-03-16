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

public class ZloteMysliSoundsActivity extends Activity {
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

                Intent intent = new Intent(ZloteMysliSoundsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZloteMysliSoundsActivity.this, FavouritesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });


        soundsArray.add(new Sound("cytat_wodka_smakuje_wspaniale", "wodka smakuje wspanialne", R.drawable.cytat_wodka_smakuje_wspaniale));
        soundsArray.add(new Sound("wodeczka_jest_wspaniala", "wodeczka jest wspaniala", R.drawable.wodeczka_jest_wspaniala));
        soundsArray.add(new Sound("zart_1", "zart 1", R.drawable.zart_1));
        soundsArray.add(new Sound("jakby_woda_z_gnojowki", "woda z gnojowki", R.drawable.jakby_woda_z_gnojowki));
        soundsArray.add(new Sound("dziewiec_ml_niecaly_litr", "9ml = litr", R.drawable.dziewiec_ml_niecaly_litr));
        soundsArray.add(new Sound("piwa_mamy_na_samym_nie", "piwa na samym  dnie", R.drawable.piwa_mamy_na_samym_nie));
        soundsArray.add(new Sound("smak_wodki_cos_dobrego", "smak wodki cos dobrego", R.drawable.smak_wodki_cos_dobrego));
        soundsArray.add(new Sound("zart_2", "zart #2", R.drawable.zart_2));
        soundsArray.add(new Sound("lubie_duzy_volt", "lubie duzy volt", R.drawable.lubie_duzy_volt));
        soundsArray.add(new Sound("nie_bede_pil", "nie bede pil", R.drawable.nie_bede_pil));
        soundsArray.add(new Sound("przestac_pic", "przestac pic", R.drawable.przestac_pic));
        soundsArray.add(new Sound("piwo_chuja_warte", "piwo ch** warte", R.drawable.piwo_chuja_warte));


        soundAdapter = new SoundsAdapter(ZloteMysliSoundsActivity.this, R.layout.row,
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