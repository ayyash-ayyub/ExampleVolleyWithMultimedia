package iak.ayyash.ar.aseaninfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import iak.ayyash.ar.aseaninfo.config.ConfigUmum;

public class DetailActivity extends AppCompatActivity {
    ImageView poster;
    TextView judul, detil, link;
    String id_negara;


    String getUrlVideo;



    String urlVideo ="rtsp://r17---sn-oguesn7l.googlevideo.com/Cj0LENy73wIaNAnWh-XD-V7bSBMYDSANFC3dWzpYMOCoAUIASARgisTtkrKnjY5YigELX004cE1YNWs0MHcM/6D44C03690331E3C612B108F2E1531C923161C4E.904915C0457360749905031694D88E45746F4ACE/yt6/1/video.3gp";
    VideoView myVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poster = (ImageView)findViewById(R.id.imageView);
        judul = (TextView)findViewById(R.id.txtTitle);
        detil = (TextView)findViewById(R.id.txtDetil);
        //link = (TextView)findViewById(R.id.txtlink);





        Intent i = getIntent();
        id_negara = i.getStringExtra ("id");

        GetData();
        System.out.println(ConfigUmum.URL_GET_DETIL+id_negara);


        //play video
        myVideoView = (VideoView)findViewById(R.id.videoView2 );

        myVideoView.setMediaController(new MediaController(this));
        myVideoView.requestFocus();
        myVideoView.start();


    }




    private void GetData(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        final JsonObjectRequest request = new JsonObjectRequest( ConfigUmum.URL_GET_DETIL+id_negara,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("response"+response);
                try {
                    JSONObject result = response.getJSONObject("result");

                    judul.setText(""+result.get("nama_negara"));
                    detil.setText(""+result.get("desekripsi"));
                  //  link.setText(""+result.get("url_youtube"));


                    myVideoView.setVideoURI(Uri.parse(""+result.get("url_youtube")));
                    Picasso.with(getApplicationContext()).load("http://103.43.45.237/android_kejar/img/"+""+result.get("bendera")).into(poster);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Masalah pada koneksi, atau data makan kurang lengkap", Toast.LENGTH_LONG).show();

            }
        });





        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        queue.add(request);
    }


}
