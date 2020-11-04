package com.pens.covidapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.pens.covidapp.BuildConfig;
import com.pens.covidapp.R;
import com.pens.covidapp.adapter.ProvinceAdapter;
import com.pens.covidapp.api.ApiClient;
import com.pens.covidapp.api.ApiService;
import com.pens.covidapp.model.indonesia.DataProvince;
import com.pens.covidapp.model.indonesia.Province;
import com.pens.covidapp.utils.Constant;
import com.pens.covidapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProvinceActivity extends AppCompatActivity {
    final String TAG = "ProvinceActivity";
    SwipeRefreshLayout swipeProvince;
    TextView txtKasus;
    PieChart pieChart;
    CardView cvProvince;
    RecyclerView rvProvince;
    LinearLayout llMainProvince;

    ImageButton btnBack;

    private ProvinceAdapter provinceAdapter;
    private ArrayList<PieEntry> yValue;
    private ArrayList<Integer> listColor;

    private List<Province> listProvince;

    private String totalKasus = "", totalPositif = "", totalSembuh = "", totalMati = "", sKasus = "";
    private int iPositif = 0, iSembuh = 0, iMati = 0;
    private String sNama = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);

        llMainProvince = findViewById(R.id.page_province);
        swipeProvince = findViewById(R.id.swipe_layout_province);
        txtKasus = findViewById(R.id.txt_total);
        pieChart = findViewById(R.id.piechart_province);
        cvProvince = findViewById(R.id.cv_province);
        rvProvince = findViewById(R.id.rview_province);
        btnBack = findViewById(R.id.btn_back_province);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        listProvince = new ArrayList<>();
        Log.d(TAG, "total Kasus : " + totalKasus + " totalPositif : " + totalPositif + " totalSembuh : " + totalSembuh);

        setChart();

    }

    private void getData() {

        load();
        if (!Utils.internet(getApplicationContext())) {
            unload(getString(R.string.txt_koneksi_masalah));
            return;
        }

        ApiService apiService = ApiClient.getClient(BuildConfig.BASE_URL_INDONESIA).create(ApiService.class);
        Log.d(TAG, "url " + BuildConfig.BASE_URL_INDONESIA);

        apiService.getProvince().enqueue(new Callback<DataProvince>() {
            @Override
            public void onResponse(Call<DataProvince> call, Response<DataProvince> response) {
                try {
                    if (response.isSuccessful()) {
                        unload("");
                        if (listProvince.size() > 0)
                            listProvince.clear();

                        listProvince = response.body().getData();

                        listProvince.remove(listProvince.size() - 1);
                        sKasus = "(" + listProvince.size() + ")";

                        txtKasus.setText(sKasus);

                        provinceAdapter = new ProvinceAdapter(ProvinceActivity.this, listProvince,
                                totalKasus, totalPositif, totalSembuh, totalMati);
                        rvProvince.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
                        rvProvince.setAdapter(provinceAdapter);
                        rvProvince.setItemAnimator(new DefaultItemAnimator());
                        rvProvince.setHasFixedSize(true);
                        provinceAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    unload(getString(R.string.txt_koneksi_masalah));
                }

            }

            @Override
            public void onFailure(Call<DataProvince> call, Throwable t) {

            }
        });
    }

    private void setChart() {
        if (getIntent().hasExtra(Constant.send_kasus)
                && getIntent().hasExtra(Constant.send_positif)
                && getIntent().hasExtra(Constant.send_sembuh)
                && getIntent().hasExtra(Constant.send_mati)) {
            totalKasus = getIntent().getStringExtra(Constant.send_kasus);
            totalPositif = getIntent().getStringExtra(Constant.send_positif);
            totalSembuh = getIntent().getStringExtra(Constant.send_sembuh);
            totalMati = getIntent().getStringExtra(Constant.send_mati);

            if (!totalKasus.isEmpty() && !totalPositif.isEmpty() && !totalSembuh.isEmpty() && !totalMati.isEmpty()) {
                Log.d(TAG, "total Kasus : " + totalKasus + " totalPositif : " + totalPositif + " totalMati : " + totalMati);

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int w = metrics.widthPixels;
                pieChart.getLayoutParams().height = w - 14;

                yValue = new ArrayList<>();
                if (yValue.size() > 0) yValue.clear();
                yValue.add(new PieEntry(Float.parseFloat(totalPositif), "Positif"));
                yValue.add(new PieEntry(Float.parseFloat(totalSembuh), "Sembuh"));
                yValue.add(new PieEntry(Float.parseFloat(totalMati), "Meninggal"));
                listColor = new ArrayList<>();
                if (listColor.size() > 0) listColor.clear();
                listColor.add(getResources().getColor(R.color.colorRed));
                listColor.add(getResources().getColor(R.color.colorGreen));
                listColor.add(getResources().getColor(R.color.colorGrey));

                PieDataSet pieDataSet = new PieDataSet(yValue, "");
                pieDataSet.setColors(listColor);

                PieData pieData = new PieData(pieDataSet);
                pieData.setValueTextSize(12);
                pieData.setValueTextColor(getResources().getColor(R.color.colorWhite));
                pieChart.setDrawHoleEnabled(false);
                pieChart.setDrawEntryLabels(false);
                pieChart.invalidate();
                pieChart.setData(pieData);
                Description description = new Description();
                description.setText("Total kasus " + totalKasus);
                description.setTextSize(12);
                pieChart.setDescription(description);
                Legend legend = new Legend();
                legend.setTextSize(12);

                if (swipeProvince.isRefreshing()) swipeProvince.setRefreshing(false);
                swipeProvince.setOnRefreshListener(this::getData);
                swipeProvince.setColorScheme(R.color.colorPrimary);
                getData();

            }

        } else {
            return;
        }


    }

    private void load() {
        swipeProvince.setRefreshing(true);
    }

    private void unload(String msg) {
        swipeProvince.setRefreshing(false);

        if (!msg.isEmpty()) snackbar(msg);
    }

    private void snackbar(String msg) {
        Utils.snackbar(findViewById(R.id.page_province), msg);
    }

    @Override
    public void onBackPressed() {
        back();
    }

    void back() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
