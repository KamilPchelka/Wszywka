package com.gmail.siemaeniu500.wszywka.categories.utils;

/**
 * Created by Kamil on 2017-01-20.
 */

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.facebook.FacebookSdk;
import com.facebook.messenger.MessengerUtils;
import com.facebook.messenger.ShareToMessengerParams;
import com.gmail.siemaeniu500.wszywka.MainMenuActivity;
import com.gmail.siemaeniu500.wszywka.R;
import com.gmail.siemaeniu500.wszywka.StartActivity;
import com.gmail.siemaeniu500.wszywka.categories.AllSoundsActivity;
import com.gmail.siemaeniu500.wszywka.categories.FavouritesActivity;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.facebook.FacebookSdk.getApplicationContext;


public class SoundsAdapter extends ArrayAdapter<Sound> implements Filterable{
    Context context;
    private Filter soundsFilter;
    int layoutResourceId;
    List<Sound> data;
    List<Sound> data2;
    public static MediaPlayer mp;
    public ViewGroup parent;

    public SoundsAdapter(Context context, int layoutResourceId,
                         List<Sound> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.data2 = data;
    }

    @Override
    public Filter getFilter() {
        if (soundsFilter == null)
            soundsFilter = new SoundsFilter();

        return soundsFilter;
    }

    public int getCount() {
        return data.size();
    }



    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View row = convertView;
        this.parent = parent;
        UserHolder holder = null;
        final Sound sound = data.get(position);
        Log.i("POZYCJA", String.valueOf(position));

        if (row == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new UserHolder();
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            boolean favourite = prefs.getBoolean(sound.getPath(), false);
            ImageButton buttonUnliked = (ImageButton) row.findViewById(R.id.unliked_button);





            row.setTag(holder);

        } else {

            holder = (UserHolder) row.getTag();

        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean favourite = prefs.getBoolean(sound.getPath(), false);
        ImageButton buttonUnliked = (ImageButton) row.findViewById(R.id.unliked_button);


        if (favourite == true) {



            buttonUnliked.setBackground(StartActivity.map.get("liked"));
            holder.unliked = buttonUnliked;

        }
        if (favourite == false) {
            buttonUnliked.setBackground(StartActivity.map.get("unliked"));
            holder.unliked = buttonUnliked;
        }

        holder.shareButton = (ImageButton) row.findViewById(R.id.share_button);
        holder.shareButton.setAdjustViewBounds(true);
        holder.shareButton.setBackground(StartActivity.map.get("share"));
        final ImageButton buttonSound = (ImageButton) row.findViewById(R.id.all_sounds_button);
        Drawable drawable = StartActivity.map.get(sound.getPath());
        buttonSound.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        buttonSound.setBackground(drawable);

        holder.buttonSound = buttonSound;


        holder.buttonSound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
                v.startAnimation(myAnim);

                if(StartActivity.isPlaying == true){
                    mp.release();
                }

                    mp = MediaPlayer.create(context, context.getResources().getIdentifier(sound.getPath(), "raw", context.getPackageName()));
                    StartActivity.isPlaying = true;
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {

                            StartActivity.isPlaying = false;
                            mp.release();
                        }
                    });



            }


        });

        holder.unliked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                boolean favourite = prefs.getBoolean(sound.getPath(), false);
                Toast toast = StartActivity.toast;
                GlideDrawable gbd = null;


                if (favourite == false) {
                    gbd = StartActivity.map.get("liked");
                    v.setBackground(gbd);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(sound.getPath(), true);
                    editor.commit();
                    if(StartActivity.toast !=null) {StartActivity.toast.cancel();}
                    StartActivity.toast = Toast.makeText(v.getContext(), "Dodałeś tekst do ulubionych",
                            Toast.LENGTH_SHORT);
                    StartActivity.toast.show();
                } else {

                    gbd = StartActivity.map.get("unliked");
                    v.setBackground(gbd);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(sound.getPath(), false);
                    editor.commit();
                    if(toast !=null) {toast.cancel();}
                    Iterator<Sound> iter = data.iterator();
                    try{
                        FavouritesActivity.soundAdapter.remove(sound);
                    } catch (Exception e){

                    }

                    StartActivity.toast = Toast.makeText(v.getContext(), "Usunałeś tekst z ulubionych",
                            Toast.LENGTH_SHORT);
                    StartActivity.toast.show();


                }


            }
        });

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(final View v) {

                  final PopupWindow popupWindow = new PopupWindow(context);
                  final Activity ac = (Activity) context;
                  final RelativeLayout back_dim_layout = (RelativeLayout) ac.findViewById(R.id.bac_dim_layout);

                  // inflate your layout or dynamically add view
                  LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                  View view = inflater.inflate(R.layout.popup_window_share, null);

                  //Button item = (Button) view.findViewById(R.id.button1);
                  back_dim_layout.setVisibility(View.VISIBLE);

                  popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                      @Override
                      public void onDismiss() {
                          back_dim_layout.setVisibility(View.GONE);
                      }
                  });
                  ImageButton closeButton = (ImageButton) view.findViewById(R.id.ib_close);
                  ImageButton messengerButton = (ImageButton) view.findViewById(R.id.messengerButton);
                  ImageButton otherButton = (ImageButton) view.findViewById(R.id.otherButton);
                  ImageButton notificationButton = (ImageButton) view.findViewById(R.id.notificationButton);
                  ImageButton ringtoneButton = (ImageButton) view.findViewById(R.id.ringtoneButton);
                  ImageButton savefileButton = (ImageButton) view.findViewById(R.id.savefilebutton);
                  popupWindow.setFocusable(true);
                  popupWindow.setBackgroundDrawable(new ColorDrawable(
                          android.graphics.Color.TRANSPARENT));
                  popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                  popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                  popupWindow.setContentView(view);

                  popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


                  closeButton.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          // Dismiss the popup window
                          popupWindow.dismiss();
                      }
                  });

                  messengerButton.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          if(StartActivity.ismessenger == false){
                              if(StartActivity.toast !=null) {StartActivity.toast.cancel();}
                              StartActivity.toast = Toast.makeText(getContext(), "Musisz mieć zainstalowanego messengera!",
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              return;

                          }

                          try{
                              popupWindow.dismiss();
                              String mimeType = "image/jpeg";
                              InputStream ins = getContext().getResources().openRawResource(
                                      getContext().getResources().getIdentifier(sound.getPath(),
                                              "raw", getContext().getPackageName()));

                              File tempFile = File.createTempFile(sound.getPath(), ".mp3", getContext().getExternalCacheDir());
                              FileOutputStream out = new FileOutputStream(tempFile);
                              IOUtils.copy(ins, out);
                              Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", tempFile);

                              ShareToMessengerParams shareToMessengerParams =
                                      ShareToMessengerParams.newBuilder(uri, mimeType)
                                              .build();
                              MessengerUtils.shareToMessenger(
                                      (Activity) getContext(),
                                      1,
                                      shareToMessengerParams);

                          } catch (Exception e) {
                              StartActivity.toast = Toast.makeText(getContext(), "Aby to zrobić nadaj aplikacji uprawnienia",
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              grantPermission();
                              e.printStackTrace();

                          }
                      }
                  });

                  otherButton.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {

                          try {
                              InputStream ins = getContext().getResources().openRawResource(
                                      getContext().getResources().getIdentifier(sound.getPath(),
                                              "raw", getContext().getPackageName()));
                              File tempFile = File.createTempFile(sound.getPath(), ".mp3", getContext().getExternalCacheDir());
                              FileOutputStream out = new FileOutputStream(tempFile);
                              IOUtils.copy(ins, out);
                              Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", tempFile);
                              Intent share = new Intent();
                              share.setType("audio/*");
                              share.setAction(Intent.ACTION_SEND);
                              share.putExtra(Intent.EXTRA_STREAM, uri);
                              StartActivity.context.startActivity(share);
                              popupWindow.dismiss();

                          } catch (Exception e) {
                              StartActivity.toast = Toast.makeText(getContext(), "Aby to zrobić nadaj aplikacji uprawnienia",
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              e.printStackTrace();
                          }

                      }
                  });


                  notificationButton.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {

                          try {

                              File ringtoneFile = new File(String.valueOf(getContext().getExternalCacheDir() + "/" + sound.getPath()+ ".mp3"));
                              InputStream ins = getContext().getResources().openRawResource(
                                      getContext().getResources().getIdentifier(sound.getPath(),
                                              "raw", getContext().getPackageName()));
                              if(!ringtoneFile.exists()){

                                  FileOutputStream out = new FileOutputStream(ringtoneFile);
                                  IOUtils.copy(ins, out);
                              }



                              ContentValues content = new ContentValues();
                              content.put(MediaStore.MediaColumns.DATA,ringtoneFile.getAbsolutePath());
                              content.put(MediaStore.MediaColumns.TITLE, sound.getPath());
                              content.put(MediaStore.MediaColumns.SIZE, 215454);
                              content.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
                              //  content.put(MediaStore.Audio.Media.ARTIST, "Madonna");
                              content.put(MediaStore.Audio.Media.DURATION, 230);
                              content.put(MediaStore.Audio.Media.IS_RINGTONE, false);
                              content.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
                              content.put(MediaStore.Audio.Media.IS_ALARM, false);
                              content.put(MediaStore.Audio.Media.IS_MUSIC, false);


                              Uri Ringtone1 = Uri.parse("current song file path");
                              //Insert it into the database
                              Log.i("TAG", "the absolute path of the file is :"+
                                      ringtoneFile.getAbsolutePath());
                              Uri uri = MediaStore.Audio.Media.getContentUriForPath(
                                      ringtoneFile.getAbsolutePath());




                              context.getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + ringtoneFile.getAbsolutePath() + "\"",
                                      null);
                              Uri newUri = context.getContentResolver().insert(uri, content);
                              System.out.println("uri=="+uri);
                              Log.i("TAG","the ringtone uri is :"+newUri);
                              RingtoneManager.setActualDefaultRingtoneUri(
                                      context.getApplicationContext(), RingtoneManager.TYPE_NOTIFICATION,
                                      newUri);

                              StartActivity.toast = Toast.makeText(getContext(), String.valueOf("Ustawiłeś tekst jako dzwięk SMSa i powiadomienia :)"),
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();




                          } catch (Exception e) {
                              StartActivity.toast = Toast.makeText(getContext(), "Aby to zrobić nadaj aplikacji uprawnienia",
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              grantPermission();
                              e.printStackTrace();

                          }
                          popupWindow.dismiss();
                      }
                  });

                  ringtoneButton.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          try {


                              File ringtoneFile = new File(String.valueOf(getContext().getExternalCacheDir() + "/" + sound.getPath()+ ".mp3"));
                              InputStream ins = getContext().getResources().openRawResource(
                                      getContext().getResources().getIdentifier(sound.getPath(),
                                              "raw", getContext().getPackageName()));
                              if(!ringtoneFile.exists()){

                                  FileOutputStream out = new FileOutputStream(ringtoneFile);
                                  IOUtils.copy(ins, out);
                              }



                              ContentValues content = new ContentValues();
                              content.put(MediaStore.MediaColumns.DATA,ringtoneFile.getAbsolutePath());
                              content.put(MediaStore.MediaColumns.TITLE, sound.getPath());
                              content.put(MediaStore.MediaColumns.SIZE, 215454);
                              content.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
                              //  content.put(MediaStore.Audio.Media.ARTIST, "Madonna");
                              content.put(MediaStore.Audio.Media.DURATION, 230);
                              content.put(MediaStore.Audio.Media.IS_RINGTONE, true);
                              content.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
                              content.put(MediaStore.Audio.Media.IS_ALARM, false);
                              content.put(MediaStore.Audio.Media.IS_MUSIC, false);


                              Uri Ringtone1 = Uri.parse("current song file path");
                              //Insert it into the database
                              Log.i("TAG", "the absolute path of the file is :"+
                                      ringtoneFile.getAbsolutePath());
                              Uri uri = MediaStore.Audio.Media.getContentUriForPath(
                                      ringtoneFile.getAbsolutePath());




                              context.getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + ringtoneFile.getAbsolutePath() + "\"",
                                      null);
                              Uri newUri = context.getContentResolver().insert(uri, content);
                              System.out.println("uri=="+uri);
                              Log.i("TAG","the ringtone uri is :"+newUri);
                              RingtoneManager.setActualDefaultRingtoneUri(
                                      context.getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                                      newUri);

                              StartActivity.toast = Toast.makeText(getContext(), String.valueOf("Ustawiłeś tekst jako dzwonek telefonu :)"),
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();






                          } catch (Exception e) {
                              StartActivity.toast = Toast.makeText(getContext(), "Aby to zrobić nadaj aplikacji uprawnienia",
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              grantPermission();
                              e.printStackTrace();

                          }
                          popupWindow.dismiss();
                      }
                  });


                  savefileButton.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {

                          try {
                              File file = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)) + "/" + sound.getPath() + ".mp3");
                              InputStream ins = getContext().getResources().openRawResource(
                                      getContext().getResources().getIdentifier(sound.getPath(),
                                              "raw", getContext().getPackageName()));
                              if(!file.exists()){

                                  FileOutputStream out = new FileOutputStream(file);
                                  IOUtils.copy(ins, out);
                              }
                              StartActivity.toast = Toast.makeText(getContext(), String.valueOf("Zapisano w folderze " + file.getPath()),
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              popupWindow.dismiss();

                          } catch (Exception e) {
                              StartActivity.toast = Toast.makeText(getContext(), "Aby to zrobić nadaj aplikacji uprawnienia",
                                      Toast.LENGTH_SHORT);
                              StartActivity.toast.show();
                              grantPermission();
                              e.printStackTrace();
                          }

                      }
                  });







              }
          }
        );
        return row;
    }

    static class UserHolder {
        ImageButton shareButton;
        ImageButton buttonSound;
        ImageButton unliked;
    }





    private class SoundsFilter extends Filter {



        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = data2;
                results.count = data2.size();
            }
            else {
                List<Sound> nSoundsList = new ArrayList<Sound>();

                for (Sound s : data2) {
                    if (s.getName().toLowerCase().contains(constraint.toString().toLowerCase()))
                        nSoundsList.add(s);
                }

                results.values = nSoundsList;
                results.count = nSoundsList.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                data = (List<Sound>) results.values;
                notifyDataSetChanged();
            }

        }


    }

    public void grantPermission(){
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return;
            }

            if (!Settings.System.canWrite(getApplicationContext())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + context.getPackageName()));
                Activity ac = (Activity) context;
                ac.startActivityForResult(intent, 200);


        }

    }


    }
}

