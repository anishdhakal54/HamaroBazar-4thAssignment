package com.anish.hamrobazarapi.bll;

import com.anish.hamrobazarapi.API.UsersAPI;
import com.anish.hamrobazarapi.serverresponse.SignupResponse;
import com.anish.hamrobazarapi.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Loginbll {
    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignupResponse> usersCall = usersAPI.checkUser(username, password);

        try {
            Response<SignupResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
