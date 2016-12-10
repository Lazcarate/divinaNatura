package com.luisazcarate.divinanatura;

import com.google.firebase.auth.FirebaseAuth;

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
    public void inicioRegistro(String email, String password) {

        mSignUpInteractor.inicioSesion(email, password, this);


    }

    @Override
    public void onErrorEmail(String msg) {

    }

    @Override
    public void onErrorPassword(String msg) {

    }

    @Override
    public void onSuccessSignup() {

        mSignUpView.aLogin();

    }

    @Override
    public void onFalloAuth(String msg) {

        mSignUpView.showSignUpError(msg);


    }


}
