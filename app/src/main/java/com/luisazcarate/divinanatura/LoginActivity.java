package com.luisazcarate.divinanatura;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements IloginView {

    @Bind(R.id.input_email)
    TextInputEditText email;
    @Bind(R.id.input_password)
    TextInputEditText password;
    @Bind(R.id.btn_login)
    Button login;
    @Bind(R.id.link_signup)
    TextView enlaceRegistro;
    @Bind(R.id.login_progreso)
    ProgressBar progressBar;
    @Bind(R.id.linearLogin)
    LinearLayout linearLog;
    private ILoginPresenter mPresenter;
    private static final int REQUEST_SIGNUP = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //si no estamos registrados debemos hacerlo antes de iniciar sesion

        enlaceRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnSignUp();
            }
        });

    //Asignamos eventos a los Texts

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inicioSesion();

            }
        });

        mPresenter = new LoginPresenter(this);

}
    private void inicioSesion(){

        mPresenter.inicioSesion(email.getText().toString().trim(),
                password.getText().toString().trim());

    }


    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setEmailError(String msg) {

        email.setError(msg);

    }

    @Override
    public void setPasswordError(String msg) {

        password.setError(msg);

    }

    @Override
    public void aInicio() {

        //Generamos un intent a la actividad Principal
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        //Finalizamos la actividad en la que estamos
        this.finish();
        }

    @Override
    public void showLoginError(String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(msg)
                .setTitle(R.string.errorTitle)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        OnSignUp();
                    }
                }).create().show();


    }


    public void OnSignUp() {

        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
        this.finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

}
