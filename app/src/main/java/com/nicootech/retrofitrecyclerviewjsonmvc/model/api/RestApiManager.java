package com.nicootech.retrofitrecyclerviewjsonmvc.model.api;

import com.google.gson.GsonBuilder;
import com.nicootech.retrofitrecyclerviewjsonmvc.model.utilities.Constants;

import retrofit.Retrofit;
import retrofit.converter.gson.GsonConverterFactory;




public class RestApiManager {
    private Retrofit mFlowerApi;

    public Retrofit getFlowerApi() {

        if(mFlowerApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

           mFlowerApi = new RestApiManager()
        }
        return mFlowerApi;
    }
}
