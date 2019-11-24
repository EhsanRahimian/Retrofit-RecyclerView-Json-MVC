package com.nicootech.retrofitrecyclerviewjsonmvc.controller;

import android.util.Log;

import com.nicootech.retrofitrecyclerviewjsonmvc.model.api.RestApiManager;
import com.nicootech.retrofitrecyclerviewjsonmvc.model.pojo.Flower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private FlowerCallbackListener mListener;
    private RestApiManager mApiManager;

    public Controller(FlowerCallbackListener listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        mApiManager.getFlowerApi().getFlowers(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
//            @Override
//            public void success(String s, Response response) {
//                Log.d(TAG, "JSON :: " + s);
//
//                try {
//                    JSONArray array = new JSONArray(s);
//
//                    for(int i = 0; i < array.length(); i++) {
//                        JSONObject object = array.getJSONObject(i);
//
//                        Flower flower = new Flower.Builder()
//                                .setCategory(object.getString("category"))
//                                .setPrice(object.getDouble("price"))
//                                .setInstructions(object.getString("instructions"))
//                                .setPhoto(object.getString("photo"))
//                                .setName(object.getString("name"))
//                                .setProductId(object.getInt("productId"))
//                                .build();
//
//                        mListener.onFetchProgress(flower);
//
//                    }
//
//                } catch (JSONException e) {
//                    mListener.onFetchFailed();
//                }
//
//
//                mListener.onFetchComplete();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.d(TAG, "Error :: " + error.getMessage());
//                mListener.onFetchComplete();
//            }
        });
    }

    public interface FlowerCallbackListener {

        void onFetchStart();
        void onFetchProgress(Flower flower);
        void onFetchProgress(List<Flower> flowerList);
        void onFetchComplete();
        void onFetchFailed();
    }
}
