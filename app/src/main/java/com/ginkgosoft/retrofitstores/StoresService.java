package com.ginkgosoft.retrofitstores;

/**
 * Created by Mario on 14/04/2016.
 */

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.*;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public final class StoresService {
    public static final String API_URL = "http://fortz.esy.es/";

    public static class StoreReponse {
        public final String status;
        public final String message;
        public final List<Store> stores;

        public StoreReponse(String status, String message, List<Store> stores) {
            this.status = status;
            this.message = message;
            this.stores = stores;
        }
    }

    public static class Store {
        public String store_id;
        public String store_name;
        public int latitude;
        public int longitud;
        public String street;
        public String notes;
    }

    public static class StoreAdd {

        public String store_name;
        public int latitude;
        public int longitude;
        public String street;
        public String notes;

        public StoreAdd(String store_name, int latitude, int longitude, String street, String notes) {
            this.store_name = store_name;
            this.latitude = latitude;
            this.longitude = longitude;
            this.street = street;
            this.notes = notes;
        }

    }

    public static class StoreAddResponse {
        String status;
        String message;

        StoreAddResponse() {
            this.status = "";
            this.message = "";
        }
    }

    public interface ChinoStores {
        @GET("stores")
        Call<StoreReponse> getStores();

        @POST("store")
        Call<StoreAddResponse> addStore(@Body StoreAdd storeAdd);
    }

    public static void main(String... args) throws IOException {

//        call.enqueue(new Callback<StoreAdd>() {
//            @Override
//            public void onResponse(Call<StoreAdd> call, Response<StoreAdd> response) {
//                System.out.println(response.message());
//            }
//
//            @Override
//            public void onFailure(Call<StoreAdd> call, Throwable t) {
//                System.out.println(t.getStackTrace());
//            }
//        });


        //chinoStores.addStore(new StoreAdd("CHINO 3", 3, 3, "calle patata", "nota 3"));


       /* Call<StoreReponse> call = chinoStores.getStores();
        StoreReponse response = call.execute().body();
        System.out.println(response.message);
        System.out.println(response.status);*/

        //Add a chino
        /*StoreAdd storeAdd = new StoreAdd("Chino nuevo", 1, 2, "Calle la Pera", "una nota nueva");
        Call<StoreAdd> call2 = chinoStores.addStore(storeAdd);
        call2.enqueue(new Callback<StoreAdd>() {
            @Override
            public void onResponse(Call<StoreAdd> call, Response<StoreAdd> response) {
                System.out.println(response.body().store_name);
                System.out.println(response.message());

            }

            @Override
            public void onFailure(Call<StoreAdd> call, Throwable t) {
            }
        });*/

        //Get the chinos
       /* int i = 0;
        if (response.stores.iterator().hasNext()) {
            System.out.println("Tienda " + i);
            Store s = response.stores.iterator().next();
            System.out.println(s.store_id);
            System.out.println(s.store_name);
            System.out.println(s.latitude);
            System.out.println(s.longitud);
            System.out.println(s.street);
            System.out.println(s.notes);
            System.out.println("-----------------------------------");
            i++;
        }*/
    }
}