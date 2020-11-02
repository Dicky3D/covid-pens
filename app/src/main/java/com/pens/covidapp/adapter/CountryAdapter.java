package com.pens.covidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pens.covidapp.R;
import com.pens.covidapp.model.covid_country.Attributes;
import com.pens.covidapp.utils.Utils;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private Context context;
    private List<Attributes> countryList;
    private String totalKasus = "";

    public CountryAdapter(Context context, List<Attributes> countryList, String totalKasus) {
        this.context = context;
        this.countryList = countryList;
        this.totalKasus = totalKasus;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_country, parent, false);
        return new CountryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {

        Attributes attributes = countryList.get(position);
        String countryNama = attributes.getCountryRegion();
        int totKasus = attributes.getConfirmed();

        holder.tvCountryNama.setText(countryNama);
        holder.tvCountryKasus.setText(""+totKasus);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryNama, tvCountryKasus, tvCountryPersentase;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryNama = itemView.findViewById(R.id.list_main_country_nama);
            tvCountryKasus = itemView.findViewById(R.id.list_main_country_kasus);
            tvCountryPersentase = itemView.findViewById(R.id.list_main_country_kasus_persentase);

        }
    }
}
