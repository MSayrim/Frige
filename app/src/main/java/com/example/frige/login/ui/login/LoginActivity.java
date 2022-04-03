package com.example.frige.login.ui.login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.frige.MainActivity;
import com.example.frige.R;
import com.example.frige.WebApi.ManagerAll;
import com.example.frige.login.ui.login.register.RegisterActivity;
import com.example.frige.models.CurrentUser;
import com.example.frige.models.LoginModel;
import com.example.frige.models.LoginRespondModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET;
    private EditText passwordET;
    private Button loginBTN;
    private Button registerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUI();
        loginBTN.setOnClickListener(loginClick);
        registerBTN.setOnClickListener(register);
    }

    private void setUI() {
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        loginBTN = findViewById(R.id.loginBTN);
        registerBTN = findViewById(R.id.registerBTN);
    }

    private View.OnClickListener loginClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LoginModel loginUser = new LoginModel(emailET.getText().toString(), passwordET.getText().toString());
            final Call<LoginRespondModel> request = ManagerAll.getInstance().login(loginUser);

            request.enqueue(new Callback<LoginRespondModel>() {
                @Override
                public void onResponse(Call<LoginRespondModel> call, Response<LoginRespondModel> response) {
                    LoginRespondModel loginRespondModel = response.body();
                    if (loginRespondModel.getUserID() != 0) {
                        CurrentUser.getInstance().setCurrentUserID(loginRespondModel.getUserID());
                        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(mainIntent);
                    }
                }

                @Override
                public void onFailure(Call<LoginRespondModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Giriş Başarısız.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    private View.OnClickListener register = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent mainIntent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(mainIntent);

        }
    };

}