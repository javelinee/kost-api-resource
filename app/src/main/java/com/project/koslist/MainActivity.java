package com.project.koslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Kost> kostArrayList = new ArrayList<>();

    String url = "https://bit.ly/2zd4uhX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        mrecyclerView = findViewById(R.id.itemList);

        layoutManager = new LinearLayoutManager(this);
        mAdapter = new KostAdapter(this, kostArrayList);
        mrecyclerView.setHasFixedSize(true);

        loadList();
    }

    public void loadList(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0; i<response.length(); i++){
                            try {
                                JSONObject kosObject = response.getJSONObject(i);
                                Kost dataKost = new Kost();

                                dataKost.kosThumbnail = kosObject.getString("image");
                                dataKost.kosName = kosObject.getString("name");
                                dataKost.kosPrice = Integer.parseInt(kosObject.getString("price"));
                                dataKost.kosFacility = kosObject.getString("facilities");
                                kostArrayList.add(dataKost);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mrecyclerView.setLayoutManager(layoutManager);
                        mrecyclerView.setAdapter(mAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
