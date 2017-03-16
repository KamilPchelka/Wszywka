package com.gmail.siemaeniu500.wszywka.categories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.gmail.siemaeniu500.wszywka.MainMenuActivity;
import com.gmail.siemaeniu500.wszywka.R;
import com.gmail.siemaeniu500.wszywka.categories.utils.Sound;
import com.gmail.siemaeniu500.wszywka.categories.utils.SoundsAdapter;

import java.util.ArrayList;

public class PowiedzonkaSoundsActivity extends Activity {
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

                Intent intent = new Intent(PowiedzonkaSoundsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PowiedzonkaSoundsActivity.this, FavouritesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });


        soundsArray.add(new Sound("siki_swietej_wenioriki", "siki swietej wenioriki", R.drawable.siki_swietej_wenioriki));
        soundsArray.add(new Sound("badziewie_do_badziewia", "badziewie do badziewia", R.drawable.badziewie_do_badziewia));
        soundsArray.add(new Sound("niebo_w_ziemi_1", "niebo w ziemi", R.drawable.niebo_w_ziemi_1));
        soundsArray.add(new Sound("lecz_sie_na_nogi", "lecz się na nogi", R.drawable.lecz_sie_na_nogi));
        soundsArray.add(new Sound("chcialbym_pozyczyc", "pożyczyć 5 zł", R.drawable.chcialbym_pozyczyc));
        soundsArray.add(new Sound("uje_sie_nie_kreskuje", "uje sie nie kreskuje", R.drawable.uje_sie_nie_kreskuje));
        soundsArray.add(new Sound("zapach_smakuje", "zapach smakuje", R.drawable.zapach_smakuje));
        soundsArray.add(new Sound("gorzkie_jest", "gorzkie jest", R.drawable.gorzkie_jest));
        soundsArray.add(new Sound("chgw", "chgw", R.drawable.chgw));
        soundsArray.add(new Sound("apropo_defacto", "apropo defacto", R.drawable.apropo_defacto));
        soundsArray.add(new Sound("jebucko_nachmielony", "jebucko nachmielony", R.drawable.jebucko_nachmielony));
        soundsArray.add(new Sound("miod_w_gebie", "miod w gebie", R.drawable.miod_w_gebie));
        soundsArray.add(new Sound("watroba_gnije", "watroba gnije", R.drawable.watroba_gnije));
        soundsArray.add(new Sound("aby_bylo_dobre", "aby było dobre", R.drawable.aby_bylo_dobre));
        soundsArray.add(new Sound("lzy_mi_pociekly", "lzy mi pociekły", R.drawable.lzy_mi_pociekly));
        soundsArray.add(new Sound("nie_masz_jakiej_wodki", "nie masz wódki?", R.drawable.nie_masz_jakiej_wodki));
        soundsArray.add(new Sound("masz_tam_kielicha", "masz tam kielicha?", R.drawable.masz_tam_kielicha));
        soundsArray.add(new Sound("pali_jak_dzika_po_zoledziach", "jak dzika po żołędziach", R.drawable.pali_jak_dzika_po_zoledziach));
        soundsArray.add(new Sound("cos_mi_fermentuje", "coś mi fermentuje", R.drawable.cos_mi_fermentuje));
        soundsArray.add(new Sound("ale_petarda", "petarda", R.drawable.ale_petarda));
        soundsArray.add(new Sound("smak_aromatyczny", "smak aromatyczny", R.drawable.smak_aromatyczny));
        soundsArray.add(new Sound("niebo_pod_jezykiem", "niebo pod jezykiem", R.drawable.niebo_pod_jezykiem));
        soundsArray.add(new Sound("usta_oplukac", "usta oplukac", R.drawable.usta_oplukac));
        soundsArray.add(new Sound("mozna_konsumpowac_bez_zastrzezen", "bez zastrzezen", R.drawable.mozna_konsumpowac_bez_zastrzezen));
        soundsArray.add(new Sound("to_kierowcy_tylko_moga_pic", "dla kierowcow", R.drawable.to_kierowcy_tylko_moga_pic));
        soundsArray.add(new Sound("to_juz_kierowcy_nie_moge_pic", "nie dla kierowcow", R.drawable.to_juz_kierowcy_nie_moge_pic));
        soundsArray.add(new Sound("mianowicie_mozna_wypic", "mozna wypic", R.drawable.mianowicie_czas_na_picie));
        soundsArray.add(new Sound("to_badziewie", "badziewie", R.drawable.to_badziewie));
        soundsArray.add(new Sound("kolor_niebieski_przypomina_denaturat", "kolor niebieski przypomina denaturat", R.drawable.kolor_niebieski_przypomina_denaturat));
        soundsArray.add(new Sound("kolunio_kopsnij_drina", "kolunio kopsnij drina", R.drawable.kolunio_kopsnij_drina));
        soundsArray.add(new Sound("szkoda_na_to_pieniedzy", "szkoda na to pieniedzy", R.drawable.szkoda_na_to_pieniedzy));
        soundsArray.add(new Sound("zapowiada_sie_obiecujaco", "zapowiada sie obiecujaco", R.drawable.zapowiada_sie_obiecujaco));
        soundsArray.add(new Sound("pilem_nawet_spirytus", "pilem nawet spirytus z gwinta", R.drawable.pilem_nawet_spirytus));
        soundsArray.add(new Sound("nie_mam_zadnych_obawien", "nie mam zadnych obawien", R.drawable.nie_mam_zadnych_obawien));
        soundsArray.add(new Sound("jeszcze_takiego_zapachu_nie_pilem", "takiego zapachu nie piłem", R.drawable.jeszcze_takiego_zapachu_nie_pilem));
        soundsArray.add(new Sound("bez_zadnych_obawien", "bez zadnych obawien", R.drawable.bez_zadnych_obawien));
        soundsArray.add(new Sound("nie_musze_patrzac", "nie musze patrzac", R.drawable.nie_musze_patrzac));
        soundsArray.add(new Sound("ja_sie_upijam", "ja sie upijam", R.drawable.ja_sie_upijam));
        soundsArray.add(new Sound("to_jest_amarena", "to jest amarena", R.drawable.to_jest_amarena));
        soundsArray.add(new Sound("to_jest_dziadostwo", "to jest dziadostwo", R.drawable.to_jest_dziadostwo));
        soundsArray.add(new Sound("tym_podobniej", "tym podobniej", R.drawable.tym_podobniej));
        soundsArray.add(new Sound("o_kurcza", "o kurczaa", R.drawable.o_kurcza));
        soundsArray.add(new Sound("hej_dziewczynki", "hej dziewczynki", R.drawable.hej_dziewczynki));
        soundsArray.add(new Sound("kolor_krystaliczny", "kolor krystaliczny", R.drawable.kolor_krystaliczny));
        soundsArray.add(new Sound("super_piatka", "super piatka", R.drawable.super_piatka));
        soundsArray.add(new Sound("mocny_jest_jest_super", "mocny jest", R.drawable.mocny_jest_jest_super));
        soundsArray.add(new Sound("nieba_ziemiom_bedzie", "nieba ziemiom bedzie", R.drawable.nieba_ziemiom_bedzie));
        soundsArray.add(new Sound("niebowziecie", "niebowziecie", R.drawable.niebowziecie));
        soundsArray.add(new Sound("guzik_prawda", "guzik prawda", R.drawable.guzik_prawda));
        soundsArray.add(new Sound("piwko_zaatakowalo", "pwio zaatakowalo", R.drawable.piwko_zaatakowalo));


        soundAdapter = new SoundsAdapter(PowiedzonkaSoundsActivity.this, R.layout.row,
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