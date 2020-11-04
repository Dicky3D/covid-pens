package com.pens.covidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pens.covidapp.R;
import com.pens.covidapp.model.summary.Country;
import com.pens.covidapp.utils.Utils;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private Context context;
    private List<Country> countryList;
    private int totalKasus ;

    public CountryAdapter(Context context, List<Country> countryList, int totalKasus) {
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

        Country country = countryList.get(position);
        String countryNama = country.getCountry();
        int kasusBaru = country.getNewConfirmed();
        int totKasus = country.getTotalConfirmed();


        holder.tvCountryNama.setText(countryNama);
        holder.tvCountryKasus.setText(Utils.number(""+totKasus));
        holder.tvKasusBaru.setText("(+" + kasusBaru + ")");

        String persentase = Utils.persen(totalKasus, totKasus, "2") + "%";

        if (persentase.equalsIgnoreCase("0.0%")
                || persentase.equalsIgnoreCase("0.00%"))
            persentase = Utils.persen(totalKasus, totKasus, "4") + "%";
        holder.tvCountryPersentase.setText(persentase);


    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryNama, tvCountryKasus, tvCountryPersentase, tvKasusBaru;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryNama = itemView.findViewById(R.id.list_main_country_nama);
            tvCountryKasus = itemView.findViewById(R.id.list_main_country_kasus);
            tvCountryPersentase = itemView.findViewById(R.id.list_main_country_kasus_persentase);
            tvKasusBaru = itemView.findViewById(R.id.list_main_country_kasus_new);


        }
    }
}
