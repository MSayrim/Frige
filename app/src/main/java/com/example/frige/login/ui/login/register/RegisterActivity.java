package com.example.frige.login.ui.login.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.frige.R;
import com.example.frige.WebApi.ManagerAll;
import com.example.frige.login.ui.login.LoginActivity;
import com.example.frige.models.RegisterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailET;
    private EditText passwordET;
    private EditText repasswordET;
    private Button registerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUI();
        registerBTN.setOnClickListener(submitRegister);
    }

    private void setUI() {
        emailET = findViewById(R.id.emailRegisterET);
        passwordET = findViewById(R.id.passwordRegisterET);
        repasswordET = findViewById(R.id.repasswordRegisterET);
        registerBTN = findViewById(R.id.submitRegisterBTN);
    }

    private View.OnClickListener submitRegister = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (passwordET.getText().toString().equals(repasswordET.getText().toString())) {
                RegisterModel registerUser = new RegisterModel(emailET.getText().toString(), passwordET.getText().toString());
                final Call<RegisterModel> request = ManagerAll.getInstance().register(registerUser);

                request.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, @NonNull Response<RegisterModel> response) {


                        if (response.body().getEmail() != null || response.body().getEmail() != "") {
                            Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(mainIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {


                        Toast.makeText(getApplicationContext(), "Kayıt olma başarısız.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    };


}