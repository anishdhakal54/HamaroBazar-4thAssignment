package com.anish.hamrobazarapi.API;

import com.anish.hamrobazarapi.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {
    @GET("products/")
    Call<List<Product>> getRecentProduct();

    @GET("products/trending")
    Call <List<Product>> getPopularProduct();
}
