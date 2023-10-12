package com.example.transportead;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class NetworkService {

    private static final String BASE_URL = "http://localhost:5253/"; // Use the correct base URL from your launchSettings.json
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
