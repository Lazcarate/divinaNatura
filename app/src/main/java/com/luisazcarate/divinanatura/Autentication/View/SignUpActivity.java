package com.luisazcarate.divinanatura.Autentication.View;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.luisazcarate.divinanatura.R;
import com.luisazcarate.divinanatura.Autentication.Presenter.SignUpPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements ISignUpView {

    @Bind(R.id.input_name)TextInputEditText nombre_Registro;
    @Bind(R.id.input_password)TextInputEditText pass_Registro;
    @Bind(R.id.input_email)TextInputEditText email_Registro;
    @Bind(R.id.input_reEnterPassword)TextInputEditText re_pass_Registro;
    @Bind(R.id.btn_signup)Button btnRegistro;
    @Bind(R.id.link_login)TextView enlaceLogin;
    @Bind(R.id.label_nombre)TextInputLayout label_nome;
    @Bind(R.id.label_email_Signup) TextInputLayout label_email_signup;
    @Bind(R.id.label_pass_signup) TextInputLayout label_pass_sigup;
    @Bind(R.id.label_pass_signup_re) TextInputLayout label_pass_re;
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
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
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
    public void set_re_PasswordError() {

        label_pass_re.setError(getString(R.string.errorPass_no_coincide));
        re_pass_Registro.setText("");
    }

    @Override
    public void setEmailError() {

        label_email_signup.setError(getString(R.string.errorEmail));
        email_Registro.setText("");

    }

    @Override
    public void setPasswordError() {

        label_pass_sigup.setError(getString(R.string.errorPassNovalido));
        pass_Registro.setText("");

    }


    public void registro(){

        String mail = email_Registro.getText().toString().trim();
        String pass = pass_Registro.getText().toString().trim();
        String re_pass = re_pass_Registro.getText().toString();

        mSignupPresenter.inicioRegistro(mail, pass, re_pass);

    }


}

