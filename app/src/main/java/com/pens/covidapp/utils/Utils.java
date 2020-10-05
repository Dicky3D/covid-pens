package com.pens.covidapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static void snackbar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    public static String timeConverter(String tanggal, String fAwal, String fAkhir) {
        SimpleDateFormat formatAwal, formatAkhir;
        formatAwal = new SimpleDateFormat(fAwal);
        formatAkhir = new SimpleDateFormat(fAkhir);

        String hasil = "";

        try {
            Date date = formatAwal.parse(tanggal);
            hasil = formatAkhir.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return hasil;
    }

    public static boolean internet(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnectedOrConnecting()) {
            NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo data = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (wifi != null && wifi.isConnectedOrConnecting() || data != null && data.isConnectedOrConnecting()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String removeCharacter(String data) {
        return data.replace(",", "")
                .replace(".", "");
    }

    public static String number(String harga) {
        double dHarga = Double.valueOf(removeCharacter(harga));
        Locale locale = new Locale("in", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(dHarga).replace("Rp", "");
    }

    public static String getTimezone(String date) throws ParseException {

        Calendar mCalendar = new GregorianCalendar();
        TimeZone mTimeZone = mCalendar.getTimeZone();
        int mGMTOffset = mTimeZone.getRawOffset();
        long timeZone = TimeUnit.HOURS.convert(mGMTOffset, TimeUnit.MILLISECONDS);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.date_05, Locale.US);

        cal.setTime(sdf.parse(date));
        cal.add(Calendar.HOUR, Integer.parseInt(String.valueOf(timeZone)));
        String time = String.valueOf(cal.getTime());

        SimpleDateFormat formatAwal, formatAkhir;
        formatAwal = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        formatAkhir = new SimpleDateFormat(Constant.date_02);
        Date dateTime = formatAwal.parse(time);
        return formatAkhir.format(dateTime);
    }


    public static String getDate(String ourDate)
    {
        try
        {

            SimpleDateFormat formatter = new SimpleDateFormat(Constant.date_01);
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy HH:mm"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            ourDate = dateFormatter.format(value);

            //Log.d("ourDate", ourDate);
        }
        catch (Exception e)
        {
            ourDate = "00-00-0000 00:00";
        }
        return ourDate;
    }

    public static String persen(int pembagi, int pembilang, String i) {
        Log.d("MainActivity","pembagi : "+pembagi+" pembilang : "+pembilang);

        double a = pembagi;
        double b = pembilang;
        double hasil = (b / a) * 100;
        return String.format("%." + i + "f", hasil);
    }

    public static String getTime(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    public static Uri bitmapToUri(Context context, Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, Utils.getTime(Constant.date_04), null);
        return Uri.parse(path);
    }


}
