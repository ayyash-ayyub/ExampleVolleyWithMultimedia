package iak.ayyash.ar.aseaninfo.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.squareup.picasso.Picasso;

import java.util.List;

import iak.ayyash.ar.aseaninfo.DetailActivity;
import iak.ayyash.ar.aseaninfo.R;
import iak.ayyash.ar.aseaninfo.holder.ItemObject;
import iak.ayyash.ar.aseaninfo.holder.MainHolder;


public class MainAdapter extends RecyclerView.Adapter<MainHolder> {



    public List<ItemObject.ObjectNegara.Results> resultsList;
    public Context context;

    public MainAdapter(Context context, List<ItemObject.ObjectNegara.Results> resultsList) {
        this.context = context;
        this.resultsList = resultsList;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null);
        MainHolder mainHolder = new MainHolder(view);
        return mainHolder;
    }



    @Override
    public void onBindViewHolder(MainHolder holder, final int position) {
        holder.txtNegara.setText(resultsList.get(position).nama_negara);
        holder.txtIbuKota.setText(resultsList.get(position).ibu_kota);
        holder.txtDeskripsi.setText(resultsList.get(position).deskripsi);
        Picasso.with(context).load("http://103.43.45.237/android_kejar/img/"+resultsList.get(position).bendera).into(holder.imgFlag);


        holder.cardview_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent i =  new Intent(context, DetailActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id", resultsList.get(position).id);
                context.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return this.resultsList.size();
    }
}
