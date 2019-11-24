package com.nicootech.retrofitrecyclerviewjsonmvc.model.api;

import retrofit2.Callback;
import retrofit2.http.GET;

public interface FlowerApi {
    @GET("/feeds/flowers.json")
    void getFlowers(Callback<String>flowers);


}
