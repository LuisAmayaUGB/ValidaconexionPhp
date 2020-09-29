package com.example.validaconexionphp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
Button probar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        probar=findViewById(R.id.probar);
        probar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                probrar();
            }
        });
    }




    public  void probrar(){

        String URL="http://clasedeprogra3.vzpla.net/progra3/conexion.php";

        RequestQueue queue;
        queue= Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Response from server",Toast.LENGTH_LONG).show();

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"error"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

queue.add(stringRequest);



    }







}