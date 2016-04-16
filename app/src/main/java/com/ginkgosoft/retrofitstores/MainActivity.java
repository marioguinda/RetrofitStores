package com.ginkgosoft.retrofitstores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        samplePOST();
    }

    private void samplePOST() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StoresService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        StoresService.ChinoStores chinoStores = retrofit.create(StoresService.ChinoStores.class);

        StoresService.StoreAdd storeAdd = new StoresService.StoreAdd("CHINO 3", 3, 3, "calle patata", "nota 3");
        chinoStores.addStore(storeAdd).enqueue(new Callback<StoresService.StoreAddResponse>() {
            @Override
            public void onResponse(Call<StoresService.StoreAddResponse> call, Response<StoresService.StoreAddResponse> response) {
                System.out.println("[RESPONSE]: " + response.body().message);
            }

            @Override
            public void onFailure(Call<StoresService.StoreAddResponse> call, Throwable t) {
                System.out.println("[ERROR]");
            }
        });
    }
}
