package com.luisazcarate.divinanatura;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Luis on 5/12/16.
 */

public class LoginPresenter implements ILoginPresenter, ILoginInteractor.Callbacks{

    private final IloginView mLoginView;
    private LoginInteractor mLoginInteractor;
    private FirebaseAuth firebaseAuth;


    public LoginPresenter(IloginView mLoginView) {

        firebaseAuth = FirebaseAuth.getInstance();
        this.mLoginView = mLoginView;
        this.mLoginInteractor = new LoginInteractor();
    }


    @Override
    public void inicioSesion(String email, String password) {

        if(mLoginView != null){
            mLoginView.showProgress();
        }
        mLoginInteractor.login(email, password, this);

    }


    @Override
    public void onErrorEmail(String msg) {

        mLoginView.setEmailError(msg);

    }

    @Override
    public void onErrorPassword(String msg) {

        mLoginView.setPasswordError(msg);

    }

    @Override
    public void onSuccess() {

        mLoginView.aInicio();

    }

    @Override
    public void onFalloAuth(String msg) {

        mLoginView.showLoginError(msg);
        //Debemos mandar a Registrarse

    }


}
