package com.example.alunoinfo.meutaxi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

        public static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:8080/MeuTaxi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
