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

public class ReakcjeSoundsActivity extends Activity {
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

                Intent intent = new Intent(ReakcjeSoundsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReakcjeSoundsActivity.this, FavouritesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });

        soundsArray.add(new Sound("smiech2", "smiech", R.drawable.smiech2));
        soundsArray.add(new Sound("smiech_1", "smiech #1", R.drawable.smiech_1));
        soundsArray.add(new Sound("aaaa_2", "aaaaa #2", R.drawable.aaaa_2));
        soundsArray.add(new Sound("witam_koluniow", "witam koluniow", R.drawable.witam_koluniow));
        soundsArray.add(new Sound("kurwa_1", "kurr*", R.drawable.kurwa_1));
        soundsArray.add(new Sound("o_kurwa_jego_mac", "kur** jego mac", R.drawable.o_kurwa_jego_mac));
        soundsArray.add(new Sound("to_kurestwo_najmocniejsze", "kurestwo najmocniejsze", R.drawable.to_kurestwo_najmocniejsze));
        soundsArray.add(new Sound("co_za_kurwa", "co za kur**", R.drawable.co_za_kurwa));
        soundsArray.add(new Sound("kurr_zapial", "kurrr zapiał", R.drawable.kurr_zapial));
        soundsArray.add(new Sound("kurwa_jego_mac", "kurrr* jego mac", R.drawable.kurwa_jego_mac));
        soundsArray.add(new Sound("ten_to_dopier_pierdolnie", "ten pier******", R.drawable.ten_to_dopier_pierdolnie));
        soundsArray.add(new Sound("kawal_chlopa", "kawał chłopa", R.drawable.kawal_chlopa));
        soundsArray.add(new Sound("piekna_sprawa", "piękna sprawa", R.drawable.piekna_sprawa));
        soundsArray.add(new Sound("dziadostwo", "dziadostwoo", R.drawable.dziadostwo));
        soundsArray.add(new Sound("polecam_dzieciom", "polecam dzieciom", R.drawable.polecam_dzieciom));
        soundsArray.add(new Sound("podpiwek_jedrzej", "podpiwek jedrzej", R.drawable.podpiwek_jedrzej));
        soundsArray.add(new Sound("slodkie_jak_herbata", "slodkie jak herbata", R.drawable.slodkie_jak_herbata));
        soundsArray.add(new Sound("do_plukania_szklanek", "plukanie szklanek", R.drawable.do_plukania_szklanek));
        soundsArray.add(new Sound("kto_wypuscil_takie_dziadostwo", "kto wypuscil dziadostwo", R.drawable.kto_wypuscil_takie_dziadostwo));
        soundsArray.add(new Sound("szanowni_panstwo", "szanowni panstwo", R.drawable.szanowni_panstwo));
        soundsArray.add(new Sound("podpiek_przed_piwem", "przed piwem", R.drawable.podpiek_przed_piwem));
        soundsArray.add(new Sound("ani_to_piwo", "ani to piwo", R.drawable.ani_to_piwo));
        soundsArray.add(new Sound("dla_mnie_to_jest_za_slabe", "dla mnie to jest za slabe", R.drawable.dla_mnie_to_jest_za_slabe));
        soundsArray.add(new Sound("az_mi_slinka_leci", "az mi slinka leci", R.drawable.az_mi_slinka_leci));
        soundsArray.add(new Sound("smak_spirytusem", "smak spirytusem", R.drawable.smak_spirytusem));
        soundsArray.add(new Sound("takiego_szalenstwa", "takiego szaleństwa", R.drawable.takiego_szalenstwa));
        soundsArray.add(new Sound("szampany_do_wlosow", "szampany do włosów", R.drawable.szampany_do_wlosow));
        soundsArray.add(new Sound("ogoreczki_rybki", "ogoreczki, rybki", R.drawable.ogoreczki_rybki));
        soundsArray.add(new Sound("elegancka_do_konsumpcji", "elegancka do konsumpcji", R.drawable.elegancka_do_konsumpcji));
        soundsArray.add(new Sound("jest_super", "jest super", R.drawable.jest_super));
        soundsArray.add(new Sound("bialy_denaturat", "bialu denaturat", R.drawable.bialy_denaturat));
        soundsArray.add(new Sound("dziekuje_panstwu", "dziekuje panstwu", R.drawable.dziekuje_panstwu));
        soundsArray.add(new Sound("siema_1", "siema", R.drawable.siema_1));
        soundsArray.add(new Sound("siema_2", "siema", R.drawable.siema_2));
        soundsArray.add(new Sound("siemanko", "siemanko", R.drawable.siemanko));
        soundsArray.add(new Sound("jestem_wieslaw_wszywka", "jestem wieslaw wszywka", R.drawable.jestem_wieslaw_wszywka));
        soundsArray.add(new Sound("to_juz_jest_piorun", "pierun", R.drawable.to_juz_jest_piorun));
        soundsArray.add(new Sound("aaaa_1", "aaaaa", R.drawable.aaaa_1));
        soundsArray.add(new Sound("czuc_spirytusem", "czuc spirytusem", R.drawable.czuc_spirytusem));
        soundsArray.add(new Sound("pozdrawiam_1", "pozdrawiam #1", R.drawable.pozdrawiam_1));
        soundsArray.add(new Sound("jest_pierwsza_klasa", "pierwsza klasa", R.drawable.jest_pierwsza_klasa));
        soundsArray.add(new Sound("bimbry_zaczynaja_dzialac", "bimbry zaczynaja dzialac", R.drawable.bimbry_zaczynaja_dzialac));
        soundsArray.add(new Sound("o_gaz_jest", "gaz jest", R.drawable.o_gaz_jest));
        soundsArray.add(new Sound("brak_alkoholu", "brak alkoholu", R.drawable.brak_alkoholu));
        soundsArray.add(new Sound("dziekuje_za_obejrzenie_programu", "dziekuje za obejrzenie", R.drawable.dziekuje_za_obejrzenie_programu));
        soundsArray.add(new Sound("za_slabe_okulary", "za slabe okulary", R.drawable.za_slabe_okulary));
        soundsArray.add(new Sound("zeby_mnie_tak_nie_miotalo", "zeby mnie nie miotało", R.drawable.zeby_mnie_tak_nie_miotalo));
        soundsArray.add(new Sound("czuc_jakby_ziolami", "czuć jakby ziołami", R.drawable.czuc_jakby_ziolami));
        soundsArray.add(new Sound("smakowe_dla_kobiet", "smakowie dla kobiet", R.drawable.smakowe_dla_kobiet));
        soundsArray.add(new Sound("ta_wodka_smak_ma_kompotu", "smak kompotu", R.drawable.ta_wodka_smak_ma_kompotu));
        soundsArray.add(new Sound("smak_piwa", "smak piwa", R.drawable.smak_piwa));
        soundsArray.add(new Sound("gicio", "gicio", R.drawable.gicio));
        soundsArray.add(new Sound("ciorna_jak_ziemia", "ciorna jak ziemia", R.drawable.ciorna_jak_ziemia));


        soundAdapter = new SoundsAdapter(ReakcjeSoundsActivity.this, R.layout.row,
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