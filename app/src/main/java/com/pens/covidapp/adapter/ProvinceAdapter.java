package com.pens.covidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pens.covidapp.R;
import com.pens.covidapp.model.covid_02.Province;
import com.pens.covidapp.utils.Utils;

import org.w3c.dom.Text;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {
    private Context context;
    private List<Province> provinceList;
    private String totalKasus = "", totalSembuh = "", totalMati = "", totalPositif = "";

    public ProvinceAdapter(Context context, List<Province> provinceList, String totalKasus, String totalSembuh, String totalMati, String totalPositif) {
        this.context = context;
        this.provinceList = provinceList;
        this.totalKasus = totalKasus;
        this.totalSembuh = totalSembuh;
        this.totalMati = totalMati;
        this.totalPositif = totalPositif;
    }

    @NonNull
    @Override
    public ProvinceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_province, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvinceAdapter.ViewHolder holder, int position) {

        Province province = provinceList.get(position);

        int totKasus = Integer.parseInt(totalKasus);
        int totPositif = Integer.parseInt(totalPositif);
        int totSembuh = Integer.parseInt(totalSembuh);
        int totMati = Integer.parseInt(totalMati);

        holder.nama = province.getProvinsi();
        holder.positif = province.getKasusPosi();
        holder.sembuh = province.getKasusSemb();
        holder.mati = province.getKasusMeni();
        holder.kasus = province.getKasusPosi() + province.getKasusSemb() + province.getKasusMeni();

        holder.perKasus = Utils.persen(totKasus, province.getKasusPosi() + province.getKasusSemb() + province.getKasusMeni(), "2");
        holder.perPositif = Utils.persen(totPositif, province.getKasusPosi(), "2");
        holder.perSembuh = Utils.persen(totSembuh, province.getKasusSemb(), "2");
        holder.perMati = Utils.persen(totMati, province.getKasusMeni(), "2");


        if (holder.perKasus.equalsIgnoreCase("0.00"))
            holder.perKasus = Utils.persen(totKasus, holder.kasus, "3");
        if (holder.perPositif.equalsIgnoreCase("0.00"))
            holder.perPositif = Utils.persen(totPositif, holder.positif, "3");
        if (holder.perSembuh.equalsIgnoreCase("0.00"))
            holder.perSembuh = Utils.persen(totSembuh, holder.sembuh, "3");
        if (holder.perMati.equalsIgnoreCase("0.00"))
            holder.perMati = Utils.persen(totMati, holder.mati, "3");

        if (holder.perKasus.equalsIgnoreCase("0.000"))
            holder.perKasus = Utils.persen(totKasus, holder.kasus, "2");
        if (holder.perPositif.equalsIgnoreCase("0.000"))
            holder.perPositif = Utils.persen(totPositif, holder.positif, "2");
        if (holder.perSembuh.equalsIgnoreCase("0.000"))
            holder.perSembuh = Utils.persen(totSembuh, holder.sembuh, "2");
        if (holder.perMati.equalsIgnoreCase("0.000"))
            holder.perMati = Utils.persen(totMati, holder.mati, "2");

        holder.txtProvinsiNama.setText(holder.nama);
        holder.txtProvinsiKasus.setText(Utils.number(""+holder.kasus) + " Kasus");
        holder.txtProvinsiPositif.setText(Utils.number(""+holder.positif));
        holder.txtProvinsiSembuh.setText(Utils.number(""+holder.sembuh));
        holder.txtProvinsiMati.setText(Utils.number(""+holder.mati));

        holder.txtProvinsiKasusPersen.setText(holder.perKasus + "%");


    }

    @Override
    public int getItemCount() {
        return provinceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtProvinsiNama, txtProvinsiKasus, txtProvinsiPositif, txtProvinsiSembuh, txtProvinsiMati,
                txtProvinsiKasusPersen;

        CardView cvProvinsi;


        private int  kasus, positif, sembuh, mati;
        private String nama = "", perKasus = "", perPositif = "", perSembuh = "", perMati = "";

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProvinsiNama = itemView.findViewById(R.id.tv_provinsi_nama);
            txtProvinsiKasus = itemView.findViewById(R.id.tv_provinsi_kasus);
            txtProvinsiPositif = itemView.findViewById(R.id.tv_provinsi_positif);
            txtProvinsiSembuh = itemView.findViewById(R.id.tv_provinsi_sembuh);
            txtProvinsiMati = itemView.findViewById(R.id.tv_provinsi_mati);
            txtProvinsiKasusPersen = itemView.findViewById(R.id.tv_provinsi_kasus_persen);

            cvProvinsi = itemView.findViewById(R.id.cv_provinsi);


        }
    }
}
