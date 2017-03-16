package com.gmail.siemaeniu500.wszywka.categories;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.List;

import com.gmail.siemaeniu500.wszywka.MainMenuActivity;
import com.gmail.siemaeniu500.wszywka.R;
import com.gmail.siemaeniu500.wszywka.categories.utils.Sound;
import com.gmail.siemaeniu500.wszywka.categories.utils.SoundsAdapter;

import java.util.ArrayList;

public class AllSoundsActivity extends Activity {
    ListView soundsList;
    public static SoundsAdapter soundAdapter = null;
    List<Sound> soundsArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_sounds);
        ImageButton ib = (ImageButton) findViewById(R.id.mainMenuButton);
        final ImageButton favouriteButton = (ImageButton) findViewById(R.id.favouriteButton);
        final Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/amatic.ttf");
        EditText inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.setTypeface(font);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                soundAdapter.getFilter().filter(cs.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AllSoundsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllSoundsActivity.this, FavouritesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });





        soundsArray.add(new Sound("smiech2", "śmiech", R.drawable.smiech2));
        soundsArray.add(new Sound("siki_swietej_wenioriki", "siki świętej wenioriki", R.drawable.siki_swietej_wenioriki));
        soundsArray.add(new Sound("dziewiecdziesiat_volt_fraszka", "90 volt fraszka", R.drawable.dziewiecdziesiat_volt_fraszka));
        soundsArray.add(new Sound("dziadostwo", "dziadostwoo", R.drawable.dziadostwo));
        soundsArray.add(new Sound("kolor_niebieski_przypomina_denaturat", "kolor niebieski przypomina denaturat", R.drawable.kolor_niebieski_przypomina_denaturat));
        soundsArray.add(new Sound("konsumpcja_spirytusu", "konsumpcja spirytusu", R.drawable.konsumpcja_spirytusu));
        soundsArray.add(new Sound("polecam_dzieciom", "polecam dzieciom", R.drawable.polecam_dzieciom));
        soundsArray.add(new Sound("siema_1", "siema", R.drawable.siema_1));
        soundsArray.add(new Sound("kolunio_kopsnij_drina", "kolunio kopsnij drina", R.drawable.kolunio_kopsnij_drina));
        soundsArray.add(new Sound("cytat_wodka_smakuje_wspaniale", "woóka smakuje wspanialne", R.drawable.cytat_wodka_smakuje_wspaniale));
        soundsArray.add(new Sound("chlusniem_aby_nie_usniec_1", "chluśniem aby nie uśnieć", R.drawable.chlusniem_aby_nie_usniec_1));
        soundsArray.add(new Sound("szkoda_na_to_pieniedzy", "szkoda na to pieniędzy", R.drawable.szkoda_na_to_pieniedzy));
        soundsArray.add(new Sound("dla_mnie_to_jest_za_slabe", "dla mnie to jest za słabe", R.drawable.dla_mnie_to_jest_za_slabe));
        soundsArray.add(new Sound("zapowiada_sie_obiecujaco", "zapowiada się obiecująco", R.drawable.zapowiada_sie_obiecujaco));
        soundsArray.add(new Sound("az_mi_slinka_leci", "aż mi slinka leci", R.drawable.az_mi_slinka_leci));
        soundsArray.add(new Sound("zdrowko", "zdrowko", R.drawable.zdrowko));
        soundsArray.add(new Sound("pilem_nawet_spirytus", "piłem nawet spirytus z gwinta", R.drawable.pilem_nawet_spirytus));
        soundsArray.add(new Sound("smak_spirytusem", "smak spirytusem", R.drawable.smak_spirytusem));
        soundsArray.add(new Sound("nie_mam_zadnych_obawien", "nie mam żadnych obawień", R.drawable.nie_mam_zadnych_obawien));
        soundsArray.add(new Sound("ogoreczki_rybki", "ogóreczki, rybki", R.drawable.ogoreczki_rybki));
        soundsArray.add(new Sound("elegancka_do_konsumpcji", "elegancka do konsumpcji", R.drawable.elegancka_do_konsumpcji));
        soundsArray.add(new Sound("wodeczka_jest_wspaniala", "wódeczka jest wspaniala", R.drawable.wodeczka_jest_wspaniala));
        soundsArray.add(new Sound("bez_zadnych_obawien", "bez żadnych obawien", R.drawable.bez_zadnych_obawien));
        soundsArray.add(new Sound("jest_super", "jest super", R.drawable.jest_super));
        soundsArray.add(new Sound("zart_1", "żart 1", R.drawable.zart_1));
        soundsArray.add(new Sound("bialy_denaturat", "biały denaturat", R.drawable.bialy_denaturat));
        soundsArray.add(new Sound("dziekuje_panstwu", "dziękuję państwu", R.drawable.dziekuje_panstwu));
        soundsArray.add(new Sound("siema_2", "siema", R.drawable.siema_2));
        soundsArray.add(new Sound("jestem_wieslaw_wszywka", "jestem wiesław wszywka", R.drawable.jestem_wieslaw_wszywka));
        soundsArray.add(new Sound("to_juz_jest_piorun", "pierun", R.drawable.to_juz_jest_piorun));
        soundsArray.add(new Sound("nie_musze_patrzac", "nie musze patrząc", R.drawable.nie_musze_patrzac));
        soundsArray.add(new Sound("ja_sie_upijam", "ja sie upijam", R.drawable.ja_sie_upijam));
        soundsArray.add(new Sound("aaaa_1", "aaaaa", R.drawable.aaaa_1));
        soundsArray.add(new Sound("czuc_spirytusem", "czuć spirytusem", R.drawable.czuc_spirytusem));
        soundsArray.add(new Sound("to_jest_amarena", "to jest amarena", R.drawable.to_jest_amarena));
        soundsArray.add(new Sound("to_jest_dziadostwo", "to jest dziadostwo", R.drawable.to_jest_dziadostwo));
        soundsArray.add(new Sound("co_za_kurwa", "co za kur**", R.drawable.co_za_kurwa));
        soundsArray.add(new Sound("smiech_1", "śmiech #1", R.drawable.smiech_1));
        soundsArray.add(new Sound("kurwa_1", "kurr*", R.drawable.kurwa_1));
        soundsArray.add(new Sound("lecim_na_szczecin", "lecim na szczecin", R.drawable.lecim_na_szczecin));
        soundsArray.add(new Sound("pozdrawiam_1", "pozdrawiam #1", R.drawable.pozdrawiam_1));
        soundsArray.add(new Sound("tym_podobniej", "tym podobniej", R.drawable.tym_podobniej));
        soundsArray.add(new Sound("o_kurcza", "o kurczaa", R.drawable.o_kurcza));
        soundsArray.add(new Sound("siemanko", "siemanko", R.drawable.siemanko));
        soundsArray.add(new Sound("hej_dziewczynki", "hej dziewczynki", R.drawable.hej_dziewczynki));
        soundsArray.add(new Sound("kolor_krystaliczny", "kolor krystaliczny", R.drawable.kolor_krystaliczny));
        soundsArray.add(new Sound("super_piatka", "super piątka", R.drawable.super_piatka));
        soundsArray.add(new Sound("dziewczeta_zdrowie", "dziewczęta zdrowie", R.drawable.dziewczeta_zdrowie));
        soundsArray.add(new Sound("mocny_jest_jest_super", "mocny jest", R.drawable.mocny_jest_jest_super));
        soundsArray.add(new Sound("nieba_ziemiom_bedzie", "nieba ziemiom bedzie", R.drawable.nieba_ziemiom_bedzie));
        soundsArray.add(new Sound("niebowziecie", "niebowzięcie", R.drawable.niebowziecie));
        soundsArray.add(new Sound("jest_pierwsza_klasa", "pierwsza klasa", R.drawable.jest_pierwsza_klasa));
        soundsArray.add(new Sound("bimbry_zaczynaja_dzialac", "bimbry zaczynają działać", R.drawable.bimbry_zaczynaja_dzialac));
        soundsArray.add(new Sound("mozna_konsumpowac_bez_zastrzezen", "bez zastrzeżeń", R.drawable.mozna_konsumpowac_bez_zastrzezen));
        soundsArray.add(new Sound("podpiwek_jedrzej", "podpiwek jędrzej", R.drawable.podpiwek_jedrzej));
        soundsArray.add(new Sound("slodkie_jak_herbata", "słodkie jak herbata", R.drawable.slodkie_jak_herbata));
        soundsArray.add(new Sound("to_kierowcy_tylko_moga_pic", "dla kierowców", R.drawable.to_kierowcy_tylko_moga_pic));
        soundsArray.add(new Sound("szanowni_panstwo", "szanowni państwo", R.drawable.szanowni_panstwo));
        soundsArray.add(new Sound("podpiek_przed_piwem", "przed piwem", R.drawable.podpiek_przed_piwem));
        soundsArray.add(new Sound("ani_to_piwo", "ani to piwo", R.drawable.ani_to_piwo));
        soundsArray.add(new Sound("to_badziewie", "badziewie", R.drawable.to_badziewie));
        soundsArray.add(new Sound("jakby_woda_z_gnojowki", "woda z gnojówki", R.drawable.jakby_woda_z_gnojowki));
        soundsArray.add(new Sound("o_gaz_jest", "gaz jest", R.drawable.o_gaz_jest));
        soundsArray.add(new Sound("to_juz_kierowcy_nie_moge_pic", "nie dla kierowców", R.drawable.to_juz_kierowcy_nie_moge_pic));
        soundsArray.add(new Sound("mianowicie_mozna_wypic", "mianowicie można wypic", R.drawable.mianowicie_czas_na_picie));
        soundsArray.add(new Sound("dziewiec_ml_niecaly_litr", "9ml = litr", R.drawable.dziewiec_ml_niecaly_litr));
        soundsArray.add(new Sound("guzik_prawda", "guzik prawda", R.drawable.guzik_prawda));
        soundsArray.add(new Sound("niebo_w_ziemi_1", "niebo w ziemi", R.drawable.niebo_w_ziemi_1));
        soundsArray.add(new Sound("niebo_pod_jezykiem", "niebo pod językiem", R.drawable.niebo_pod_jezykiem));
        soundsArray.add(new Sound("usta_oplukac", "usta opłukać", R.drawable.usta_oplukac));
        soundsArray.add(new Sound("zeby_te_piwa_nie_zarazily_sie", "żeby te piwa", R.drawable.zeby_te_piwa_nie_zarazily_sie));
        soundsArray.add(new Sound("brak_alkoholu", "brak alkoholu", R.drawable.brak_alkoholu));
        soundsArray.add(new Sound("dziekuje_za_obejrzenie_programu", "dziękuję za obejrzenie", R.drawable.dziekuje_za_obejrzenie_programu));
        soundsArray.add(new Sound("piwa_mamy_na_samym_nie", "piwa mamy na samym  dnie", R.drawable.piwa_mamy_na_samym_nie));
        soundsArray.add(new Sound("badziewie_do_badziewia", "badziewie do badziewia", R.drawable.badziewie_do_badziewia));
        soundsArray.add(new Sound("za_slabe_okulary", "za słabe okulary", R.drawable.za_slabe_okulary));
        soundsArray.add(new Sound("zeby_mnie_tak_nie_miotalo", "żeby mnie nie miotało", R.drawable.zeby_mnie_tak_nie_miotalo));
        soundsArray.add(new Sound("jeszcze_takiego_zapachu_nie_pilem", "takiego zapachu nie piłem", R.drawable.jeszcze_takiego_zapachu_nie_pilem));
        soundsArray.add(new Sound("pierdynkiem_bo_odwykniem", "pierdykiem bo odwykniem", R.drawable.pierdynkiem_bo_odwykniem));
        soundsArray.add(new Sound("dziabiemy_na_3_noge", "na trzecią nogę", R.drawable.dziabiemy_na_3_noge));
        soundsArray.add(new Sound("lecz_sie_na_nogi", "lecz się na nogi", R.drawable.lecz_sie_na_nogi));
        soundsArray.add(new Sound("czuc_jakby_ziolami", "czuć jakby ziołami", R.drawable.czuc_jakby_ziolami));
        soundsArray.add(new Sound("smak_wodki_cos_dobrego", "smak wódki cos dobrego", R.drawable.smak_wodki_cos_dobrego));
        soundsArray.add(new Sound("zart_2", "zart #2", R.drawable.zart_2));
        soundsArray.add(new Sound("mianowicie_czas_na_picie", "czas  na picie", R.drawable.mianowicie_czas_na_picie));
        soundsArray.add(new Sound("chcialbym_pozyczyc", "pożyczyć 5 zł", R.drawable.chcialbym_pozyczyc));
        soundsArray.add(new Sound("uje_sie_nie_kreskuje", "uje się nie kreskuje", R.drawable.uje_sie_nie_kreskuje));
        soundsArray.add(new Sound("smakowe_dla_kobiet", "smakowie dla kobiet", R.drawable.smakowe_dla_kobiet));
        soundsArray.add(new Sound("ta_wodka_smak_ma_kompotu", "smak kompotu", R.drawable.ta_wodka_smak_ma_kompotu));
        soundsArray.add(new Sound("kurr_zapial", "kurrr zapiał", R.drawable.kurr_zapial));
        soundsArray.add(new Sound("zapach_smakuje", "zapach smakuje", R.drawable.zapach_smakuje));
        soundsArray.add(new Sound("lubie_duzy_volt", "lubie duży volt", R.drawable.lubie_duzy_volt));
        soundsArray.add(new Sound("nie_bede_pil", "nie będę pił", R.drawable.nie_bede_pil));
        soundsArray.add(new Sound("przestac_pic", "przestać pić", R.drawable.przestac_pic));
        soundsArray.add(new Sound("kurwa_jego_mac", "kurwa jego mac", R.drawable.kurwa_jego_mac));
        soundsArray.add(new Sound("witam_koluniow", "witam koluniow", R.drawable.witam_koluniow));
        soundsArray.add(new Sound("smak_piwa", "smak piwa", R.drawable.smak_piwa));
        soundsArray.add(new Sound("zdrowie_panowie_i_panie", "zdrowie panowie i panie", R.drawable.zdrowie_panowie_i_panie));
        soundsArray.add(new Sound("aaaa_2", "aaaaa #2", R.drawable.aaaa_2));
        soundsArray.add(new Sound("gicio", "gicio", R.drawable.gicio));
        soundsArray.add(new Sound("na_krzywy_ryj_pijemy", "na krzywy ryj", R.drawable.na_krzywy_ryj_pijemy));
        soundsArray.add(new Sound("gorzkie_jest", "gorzkie jest", R.drawable.gorzkie_jest));
        soundsArray.add(new Sound("piwko_zaatakowalo", "pwio zaatakowalo", R.drawable.piwko_zaatakowalo));
        soundsArray.add(new Sound("jebucko_nachmielony", "jebucko nachmielony", R.drawable.jebucko_nachmielony));
        soundsArray.add(new Sound("ciorna_jak_ziemia", "ciorna jak ziemia", R.drawable.ciorna_jak_ziemia));
        soundsArray.add(new Sound("zdrowie_tego_co_gorzala", "zdrowie tego", R.drawable.zdrowie_tego_co_gorzala));
        soundsArray.add(new Sound("miod_w_gebie", "miód w gębie", R.drawable.miod_w_gebie));
        soundsArray.add(new Sound("piwo_chuja_warte", "piwo chuja warte", R.drawable.piwo_chuja_warte));
        soundsArray.add(new Sound("watroba_gnije", "wątroba gnije", R.drawable.watroba_gnije));
        soundsArray.add(new Sound("lzy_mi_pociekly", "łzy mi pociekły", R.drawable.lzy_mi_pociekly));
        soundsArray.add(new Sound("o_kurwa_jego_mac", "kurwa jego mać", R.drawable.o_kurwa_jego_mac));
        soundsArray.add(new Sound("to_kurestwo_najmocniejsze", "kurestwo najmocniejsze", R.drawable.to_kurestwo_najmocniejsze));
        soundsArray.add(new Sound("nie_masz_jakiej_wodki", "nie masz wódki?", R.drawable.nie_masz_jakiej_wodki));
        soundsArray.add(new Sound("takiego_szalenstwa", "takiego szaleństwa", R.drawable.takiego_szalenstwa));
        soundsArray.add(new Sound("masz_tam_kielicha", "masz tam kielicha?", R.drawable.masz_tam_kielicha));
        soundsArray.add(new Sound("pali_jak_dzika_po_zoledziach", "jak dzika po żołędziach", R.drawable.pali_jak_dzika_po_zoledziach));
        soundsArray.add(new Sound("szampany_do_wlosow", "szampany do włosów", R.drawable.szampany_do_wlosow));
        soundsArray.add(new Sound("ale_petarda", "petarda", R.drawable.ale_petarda));
        soundsArray.add(new Sound("do_plukania_szklanek", "płukanie szklanek", R.drawable.do_plukania_szklanek));
        soundsArray.add(new Sound("smak_aromatyczny", "smak aromatyczny", R.drawable.smak_aromatyczny));
        soundsArray.add(new Sound("chgw", "chgw", R.drawable.chgw));
        soundsArray.add(new Sound("kto_wypuscil_takie_dziadostwo", "kto wypuścił dziadostwo", R.drawable.kto_wypuscil_takie_dziadostwo));
        soundsArray.add(new Sound("ten_to_dopier_pierdolnie", "ten to dopiero pierdolnie, chyba mnie o ziemie", R.drawable.ten_to_dopier_pierdolnie));
        soundsArray.add(new Sound("apropo_defacto", "apropo defacto", R.drawable.apropo_defacto));
        soundsArray.add(new Sound("kawal_chlopa", "kawał chłopa", R.drawable.kawal_chlopa));
        soundsArray.add(new Sound("cos_mi_fermentuje", "coś mi fermentuje", R.drawable.cos_mi_fermentuje));
        soundsArray.add(new Sound("piekna_sprawa", "piękna sprawa", R.drawable.piekna_sprawa));
        soundsArray.add(new Sound("ale_zem_sie_umordowal", "ale żem się umordował", R.drawable.ale_zem_sie_umordowal));
        soundsArray.add(new Sound("ale_sie_ladnie_pieni", "ale się ładnie pieni", R.drawable.ale_sie_ladnie_pieni));
        soundsArray.add(new Sound("aby_bylo_dobre", "aby było dobre", R.drawable.aby_bylo_dobre));
        soundsArray.add(new Sound("ani_kupy_ani_dupy", "ani kupy ani dupy", R.drawable.ani_kupy_ani_dupy));
        soundsArray.add(new Sound("az_mi_raczki_lataja", "aż mi rączki latają", R.drawable.az_mi_raczki_lataja));
        soundsArray.add(new Sound("byle_szmaciarstwa", "byle szmaciarstwa", R.drawable.byle_szmaciarstwa));
        soundsArray.add(new Sound("co_to_jest_do_jasnego_grzyba", "co to jest do jasnego grzyba", R.drawable.co_to_jest_do_jasnego_grzyba));
        soundsArray.add(new Sound("co_to_takie_kolorowe", "co to takie kolorowe", R.drawable.co_to_takie_kolorowe));
        soundsArray.add(new Sound("co_ty_sminkom_malowales_sie", "co ty śminkom malowałeś się", R.drawable.co_ty_sminkom_malowales_sie));
        soundsArray.add(new Sound("cos_kolwiek", "coś kolwiek kiedyś próbowałem", R.drawable.cos_kolwiek));
        soundsArray.add(new Sound("coz_to_bedzie", "cóż to będzie", R.drawable.coz_to_bedzie));
        soundsArray.add(new Sound("czuc_slodycza", "czuć słodyczą", R.drawable.czuc_slodycza));
        soundsArray.add(new Sound("czy_warto_brac", "czuć słodyczą", R.drawable.czy_warto_brac));
        soundsArray.add(new Sound("czym_sie_strules_tym_sie_lecz", "czym się strułeś tym się lecz", R.drawable.czym_sie_strules_tym_sie_lecz));
        soundsArray.add(new Sound("do_szyba_myc", "do szyba myć", R.drawable.do_szyba_myc));
        soundsArray.add(new Sound("dosc_piecze", "nawet dość piecze", R.drawable.dosc_piecze));
        soundsArray.add(new Sound("fanfara", "nawet dość piecze", R.drawable.fanfara));
        soundsArray.add(new Sound("fifty", "fifty", R.drawable.fifty));
        soundsArray.add(new Sound("homoniepewny", "homoniepewny", R.drawable.homoniepewny));
        soundsArray.add(new Sound("jakas_kukulka", "jakas kukułka", R.drawable.jakas_kukulka));
        soundsArray.add(new Sound("kamikaze", "kamikaze", R.drawable.kamikaze));
        soundsArray.add(new Sound("kapeluch_z_glow", "kapeluch z głów", R.drawable.kapeluch_z_glow));
        soundsArray.add(new Sound("kolowaty", "jakas kukułka", R.drawable.kolowaty));
        soundsArray.add(new Sound("koommm", "koommm", R.drawable.koommm));
        soundsArray.add(new Sound("niby_francuski", "niby francuski", R.drawable.niby_francuski));
        soundsArray.add(new Sound("niech_oglada_radio_maryje", "niech ogląda radio maryję", R.drawable.niech_oglada_radio_maryje));
        soundsArray.add(new Sound("nogi_z_waty", "nogi z waty", R.drawable.nogi_z_waty));
        soundsArray.add(new Sound("o_tu_ile_jeszcze_wodki", "o tu ile jeszcze wódki", R.drawable.o_tu_ile_jeszcze_wodki));
        soundsArray.add(new Sound("od_1_do_10", "od 1 do 10", R.drawable.od_1_do_10));
        soundsArray.add(new Sound("okej", "okej", R.drawable.okej));
        soundsArray.add(new Sound("piana_jak_pijana", "piana jak pijana", R.drawable.piana_jak_pijana));
        soundsArray.add(new Sound("picie_to_jest_zycie", "picie to jest życie", R.drawable.picie_to_jest_zycie));
        soundsArray.add(new Sound("pizdzi_jak_w_kieleckim", "piździ jak w kielieckim", R.drawable.pizdzi_jak_w_kieleckim));
        soundsArray.add(new Sound("pod_boczek", "pod boczek", R.drawable.pod_boczek));
        soundsArray.add(new Sound("przereklamowane", "przereklamowane", R.drawable.przereklamowane));
        soundsArray.add(new Sound("siema_na_flache_nie_ma", "siema na flachę nie ma", R.drawable.siema_na_flache_nie_ma));
        soundsArray.add(new Sound("smierdzi_spaleniznom", "śmierdzi spaleniznom", R.drawable.smierdzi_spaleniznom));
        soundsArray.add(new Sound("taki_wielki_portfel", "taki wielki portfel", R.drawable.taki_wielki_portfel));
        soundsArray.add(new Sound("torklo_mnie", "torkło mnie", R.drawable.torklo_mnie));
        soundsArray.add(new Sound("trzeba_rzepnac", "treba rzępnąć następną", R.drawable.trzeba_rzepnac));
        soundsArray.add(new Sound("ty_szantrapo", "ty szantrapo", R.drawable.ty_szantrapo));
        soundsArray.add(new Sound("umiar_umiarkowany", "umiar umiarkowany jest", R.drawable.umiar_umiarkowany));
        soundsArray.add(new Sound("w_majty_sie_oszczasz", "w majty się oszczasz", R.drawable.w_majty_sie_oszczasz));
        soundsArray.add(new Sound("was_nietypowy", "wąs nietypowy", R.drawable.was_nietypowy));
        soundsArray.add(new Sound("wiecej_piany_niz_piwa", "więcej piany niż piwa", R.drawable.wiecej_piany_niz_piwa));
        soundsArray.add(new Sound("wujta_opierdole", "wujta opierdole", R.drawable.wujta_opierdole));
        soundsArray.add(new Sound("z_etykietki_ladnie_wyglada", "z etykietki ładnie wygląda", R.drawable.z_etykietki_ladnie_wyglada));
        soundsArray.add(new Sound("za_zdolny", "za zdolny jesteś do mnie", R.drawable.za_zdolny));
        soundsArray.add(new Sound("za_pazernie_wypilem", "za pazernie wypiłem", R.drawable.za_pazernie_wypilem));
        soundsArray.add(new Sound("zagazuje_jak_ciagnij", "zagazuje jak ciągnik", R.drawable.zagazuje_jak_ciagnij));
        soundsArray.add(new Sound("zapach_jak_spirytus", "zapach jak spirytus", R.drawable.zapach_jak_spirytus));








        soundAdapter = new SoundsAdapter(AllSoundsActivity.this, R.layout.row,
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