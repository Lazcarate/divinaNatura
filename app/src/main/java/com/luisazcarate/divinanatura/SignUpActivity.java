package com.luisazcarate.divinanatura;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements ISignUpView{

    @Bind(R.id.input_name)TextInputEditText nombre_Registro;
    @Bind(R.id.input_password)TextInputEditText pass_Registro;
    @Bind(R.id.input_email)TextInputEditText email_Registro;
    @Bind(R.id.input_reEnterPassword)TextInputEditText re_pass_Registro;
    @Bind(R.id.btn_signup)Button btnRegistro;
    @Bind(R.id.link_login)TextView enlaceLogin;
    private SignUpPresenter mSignupPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        enlaceLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aLogin();
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro();
            }
        });

        mSignupPresenter = new SignUpPresenter(this);
    }

    @Override
    public void aLogin() {

        //Generamos un intent a la actividad Principal
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        //Finalizamos la actividad en la que estamos
        this.finish();
    }

    @Override
    public void showSignUpError(String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage(msg)
                .setTitle(R.string.errorTitleRegistro)
                .setPositiveButton(android.R.string.ok, null).create().show();
    }

    @Override
    public void setEmailError(String msg) {

    }

    @Override
    public void setPasswordError(String msg) {


    }
    public void registro(){

        String nom = nombre_Registro.getText().toString().trim();
        String mail = email_Registro.getText().toString().trim();
        String pass = pass_Registro.getText().toString().trim();

        mSignupPresenter.inicioRegistro(nom, mail, pass);

    }

}

