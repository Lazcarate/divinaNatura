package com.luisazcarate.divinanatura.Autentication.Interactor;

/**
 * Created by Luis on 7/12/16.
 */

public interface ISignUPInteractor {

    void inicioSesion(String email, String pass, ISignUPInteractor.Callbacks callbacks);

    interface Callbacks{

        void onErrorEmail(String msg);

        void onErrorPassword(String msg);

        void onSuccessSignup();

        void onFalloAuth(String msg);


    }
}
