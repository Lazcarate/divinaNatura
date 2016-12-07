package com.luisazcarate.divinanatura;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @Bind(R.id.input_name)TextInputEditText nombre_Registro;
    @Bind(R.id.input_password)TextInputEditText pass_Registro;
    @Bind(R.id.input_email)TextInputEditText email_Registro;
    @Bind(R.id.input_reEnterPassword)TextInputEditText re_pass_Registro;
    @Bind(R.id.btn_signup)Button btnRegistro;
    @Bind(R.id.link_signup)TextView enlaceLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

    }
}
