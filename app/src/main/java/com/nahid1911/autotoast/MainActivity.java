package com.nahid1911.autotoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Handler mHandler;
    ConnectivityManager connectivityManager;
    int net =8 ;

    CardView online,offline;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        online = findViewById(R.id.online);
        offline = findViewById(R.id.offline);


        mHandler = new Handler();
        m_Runnable.run();

    }


    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        { /////////////////////////

            resp();




            mHandler.postDelayed(m_Runnable,50000);
        }

    };


    public void resp(){

        // Instantiate the RequestQueue.
        String url = "https://mdnahidhossen.com/youtube.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.

                        if(net==8){
                            net = 0;
                            net = net +1;

                        }else {
                            net = net +1;

                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                net = 0;



            }
        });

// Add the request to the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

        //////////work
        if(net==1){
            online.setVisibility(View.VISIBLE);
            offline.setVisibility(View.GONE);
        }else if (net>0){
            /////////////free
            online.setVisibility(View.GONE);
        }else if(net==0){
            online.setVisibility(View.GONE);
            offline.setVisibility(View.VISIBLE);

        }


    }

}