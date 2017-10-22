package com.vvn.vocavocani.network;

import com.vvn.vocavocani.network.format.DTOUserRegister;
import com.vvn.vocavocani.network.format.DTOUserLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by soo13 on 2017-10-23.
 */

public interface ApiList {
    @FormUrlEncoded
    @POST("users/register")
    Call<List<DTOUserRegister>> postUserRegister(
            @Field("id") String id,
            @Field("pw1") String pw1,
            @Field("pw2") String pw2,
            @Field("nickname") String nickname);

    @FormUrlEncoded
    @POST("users/login")
    Call<List<DTOUserLogin>> postUserLogin(
            @Field("id") String id,
            @Field("pw") String pw);

    @GET("users/:user_idx")
    Call<List<DTOUserRegister>> getUser(@Path("user_idx") String user_id);

    @GET("teams")
    Call<List<DTOUserRegister>> getTeamList(@Header("token") String token);
}
