package com.gordenyou;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gordenyou.gdhttp.GDHttpClient;
import com.gordenyou.gdhttp.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button okGet, gdGet, okPost, gdPost;
    private final static String URL = "https://api.github.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //我们从最简单的Get请求开始。
        okGet = findViewById(R.id.ok_get);
        gdGet = findViewById(R.id.gd_get);

        okGet.setOnClickListener((view)->{
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(URL).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(MainActivity.this, "请求错误！", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(Call call, Response response) {
                    Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        gdGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GDHttpClient client = new GDHttpClient();

            }
        });
    }
}
