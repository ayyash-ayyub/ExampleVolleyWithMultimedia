package iak.ayyash.ar.aseaninfo.holder;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ItemObject {
    public class ObjectNegara {
        @SerializedName("result")
        public List<Results> result;

        public class Results {
            @SerializedName("id")
            public String id;

            @SerializedName("nama_negara")
            public String nama_negara;

            @SerializedName("ibu_kota")
            public String ibu_kota;

            @SerializedName("deskripsi")
            public String deskripsi;

            @SerializedName("bendera")
            public String bendera;
        }
    }
}
