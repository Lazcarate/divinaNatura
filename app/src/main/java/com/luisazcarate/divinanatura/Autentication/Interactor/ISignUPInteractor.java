package com.luisazcarate.divinanatura.Autentication.Interactor;

/**
 * Created by Luis on 7/12/16.
 */

public interface ISignUPInteractor {

    void inicioSesion(String email, String pass, String repass, ISignUPInteractor.Callbacks callbacks);

    interface Callbacks{

        void onErrorEmail();

        void onErrorPassword();

        void onSuccessSignup();

        void onFalloAuth(String msg);

        void onRe_PasswordError();


    }
}
