package iak.ayyash.ar.aseaninfo.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import iak.ayyash.ar.aseaninfo.R;


public class MainHolder extends RecyclerView.ViewHolder {


    public TextView txtNegara, txtIbuKota,txtDeskripsi;
    public CardView cardview_item;
    public ImageView imgFlag;

    public MainHolder(View itemView) {
        super(itemView);
        txtNegara = (TextView) itemView.findViewById(R.id.txtJudul);
        txtIbuKota = (TextView) itemView.findViewById(R.id.txtKet);
        imgFlag = (ImageView)itemView.findViewById(R.id.imgFlag);
        txtDeskripsi = (TextView)itemView.findViewById(R.id.txtDeskripsi);
        cardview_item = (CardView) itemView.findViewById(R.id.cardview_item);
    }
}
