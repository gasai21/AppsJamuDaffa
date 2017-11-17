package com.example.pangling.appsjamu.api;

import com.example.pangling.appsjamu.model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Pangling on 10/26/2017.
 */
public interface RegisteterAPI {

    @FormUrlEncoded
    @POST("login.php")
    Call<Value> Login(@Field("username") String username,
                      @Field("passwordd") String passwordd);

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> insert(@Field("username") String username,
                       @Field("konsul") String konsulan);

    @FormUrlEncoded
    @POST("view2.php")
    Call<Value> view(@Field("username") String username);

    @GET("viewlistartikel.php")
    Call<Value> viewartikel();

    @FormUrlEncoded
    @POST("delete.php")
    Call<Value> delete(@Field("id") String id);

    @FormUrlEncoded
    @POST("detail.php")
    Call<Value> detail(@Field("judul") String judul);

    @FormUrlEncoded
    @POST("regis.php")
    Call<Value> daftar(@Field("nama") String nama,
                       @Field("username") String username,
                       @Field("password") String pass);
}
