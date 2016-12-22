package com.luisazcarate.divinanatura.Autentication.Presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.luisazcarate.divinanatura.Autentication.Interactor.ISignUPInteractor;
import com.luisazcarate.divinanatura.Autentication.Interactor.SignUpInteractor;
import com.luisazcarate.divinanatura.Autentication.Presenter.ISignUpIPresenter;
import com.luisazcarate.divinanatura.Autentication.View.ISignUpView;

/**
 * Created by Luis on 7/12/16.
 */

public class SignUpPresenter implements ISignUpIPresenter, ISignUPInteractor.Callbacks{

    private final ISignUpView mSignUpView;
    private SignUpInteractor mSignUpInteractor;
    private FirebaseAuth firebaseAuth;



    public SignUpPresenter(ISignUpView mSignUpView) {

        firebaseAuth = FirebaseAuth.getInstance();
        this.mSignUpView = mSignUpView;
        this.mSignUpInteractor = new SignUpInteractor();
    }

    @Override
    public void inicioRegistro(String email, String password, String repass) {

        mSignUpInteractor.inicioSesion(email, password, repass, this);


    }

    @Override
    public void onErrorEmail() {

        mSignUpView.setEmailError();

    }

    @Override
    public void onErrorPassword() {

        mSignUpView.setPasswordError();

    }

    @Override
    public void onSuccessSignup() {

        mSignUpView.aLogin();

    }

    @Override
    public void onFalloAuth(String msg) {

        mSignUpView.showSignUpError(msg);

    }

    @Override
    public void onRe_PasswordError() {

        mSignUpView.set_re_PasswordError();

    }

}
