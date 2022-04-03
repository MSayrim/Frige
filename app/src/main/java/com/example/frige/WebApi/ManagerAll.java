package com.example.frige.WebApi;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import com.example.frige.models.FrigeItemModel;
import com.example.frige.models.LoginModel;
import com.example.frige.models.LoginRespondModel;
import com.example.frige.models.RegisterModel;

import java.util.Date;
import java.util.List;

import retrofit2.Call;


public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<LoginRespondModel> login(LoginModel user) {
        Call<LoginRespondModel> x = getRestApi().loginControl(user);
        return x;
    }

    public Call<RegisterModel> register(RegisterModel user) {
        Call<RegisterModel> x = getRestApi().register(user);
        return x;
    }

    public Call<List<FrigeItemModel>> loadFrige(int userID) {
        Call<List<FrigeItemModel>> x = getRestApi().frigeLoader(userID);
        return x;
    }

}
