package com.luisazcarate.divinanatura.Autentication.Presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.luisazcarate.divinanatura.Autentication.Interactor.ILoginInteractor;
import com.luisazcarate.divinanatura.Autentication.Interactor.LoginInteractor;
import com.luisazcarate.divinanatura.Autentication.Presenter.ILoginPresenter;
import com.luisazcarate.divinanatura.Autentication.View.IloginView;

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
    public void onErrorEmail() {

        mLoginView.setEmailError();
        mLoginView.hideProgress();

    }

    @Override
    public void onErrorPassword() {

        mLoginView.setPasswordError();
        mLoginView.hideProgress();

    }

    @Override
    public void onSuccess() {

        mLoginView.aInicio();
        mLoginView.hideProgress();

    }

    @Override
    public void onFalloAuth(String msg) {

        mLoginView.showLoginError(msg);
        mLoginView.hideProgress();

    }


}
