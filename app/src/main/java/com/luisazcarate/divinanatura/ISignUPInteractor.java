package com.luisazcarate.divinanatura;

/**
 * Created by Luis on 7/12/16.
 */

public interface ISignUPInteractor {

    void inicioSesion(String nombre, String email, String pass, ISignUPInteractor.Callbacks callbacks);

    interface Callbacks{

        void onErrorEmail(String msg);

        void onErrorPassword(String msg);

        void onSuccessSignup();

        void onFalloAuth(String msg);

        void onErrorNombre(String msg);
    }
}
