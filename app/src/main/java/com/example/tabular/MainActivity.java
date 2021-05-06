package com.example.tabular;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView view;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<ExampleItem> arrayList = new ArrayList<>();
    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=findViewById(R.id.recylerview);
        bar=findViewById(R.id.progressbar);


        manager=new LinearLayoutManager(this);
        view.setLayoutManager(manager);

        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,
                    "https://date.nager.at/api/v2/PublicHolidays/2017/AT",
                    null, new Response.Listener<JSONArray>( ) {
                @Override

                public void onResponse(JSONArray response) {


                    for (int i = 0; i < response.length( ); i++) {

                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

//                            Log.d("Holiday", "on Response " + jsonObject.getString("name") + jsonObject.getString("date"));
                            arrayList.add(new ExampleItem(jsonObject.getString("name"), jsonObject.getString("date")));

                            Log.d("Holiday2", "on Response " + arrayList.get(i).getDate( ) + arrayList.get(i).getOcassion( ));
//                            Toast.makeText(MainActivity.this,
//                                    arrayList.get(i).getDate()+arrayList.get(i).getOcassion(),Toast.LENGTH_SHORT).show();


                        } catch (JSONException e) {
                            e.printStackTrace( );
                        }


//                    Toast.makeText(MainActivity.this,arrayList.get(i).getOcassion(),Toast.LENGTH_SHORT).show();
                        bar.setVisibility(View.INVISIBLE);
                    }
                    adapter=new CustomAdapter(arrayList);
                    view.setAdapter(adapter);



                }

            }, new Response.ErrorListener( ) {

                @Override
                public void onErrorResponse(VolleyError error) {
                    bar.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Not working", Toast.LENGTH_SHORT).show( );

                }
            });

            queue.add(arrayRequest);




//






    }


}