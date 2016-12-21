package com.luisazcarate.divinanatura.Autentication.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.luisazcarate.divinanatura.Autentication.Presenter.ILoginPresenter;
import com.luisazcarate.divinanatura.Autentication.Presenter.LoginPresenter;
import com.luisazcarate.divinanatura.ProductosActivity;
import com.luisazcarate.divinanatura.R;


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
    @Bind(R.id.label_email)
    TextInputLayout mLabelemail;
    @Bind(R.id.label_password)
    TextInputLayout mLabelpass;
    private ILoginPresenter mPresenter;
    private static final int REQUEST_SIGNUP = 0;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        //Configura un AuthStateListener que responda a los cambios en el estado de inicio de
        // sesión del usuario.

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //El usuario ya esta registrado inicia sesion automaticamente
                    showListadoProductos();

                }else{
                    //El usuario no tiene la sesion abierta y se queda a la pagina de inicio de sesion.
                }
            }
        };

        //si no estamos registrados debemos hacerlo antes de iniciar sesion

        enlaceRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnSignUp();
            }
        });

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                boolean procesado = false;

                if(i == EditorInfo.IME_ACTION_UNSPECIFIED){

                    inicioSesion();

                    //Para ocultar el teclado

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                }

                return procesado;
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inicioSesion();

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }
        });

        mPresenter = new LoginPresenter(this);

}

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
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
    public void setEmailError() {

        mLabelemail.setError(getString(R.string.errorEmail));
        email.setText("");

    }



    @Override
    public void setPasswordError() {

        mLabelpass.setError(getString(R.string.errorPassVacio));

    }

    @Override
    public void aInicio() {

        //Generamos un intent a la actividad de productos
        startActivity(new Intent(LoginActivity.this, ProductosActivity.class));
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
    private void showListadoProductos() {

        //Generamos un intent a la actividad
        startActivity(new Intent(LoginActivity.this, ProductosActivity.class));
        //Finalizamos la actividad en la que estamos
        LoginActivity.this.finish();
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
