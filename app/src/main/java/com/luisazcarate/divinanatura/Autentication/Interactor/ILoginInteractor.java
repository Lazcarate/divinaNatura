package com.luisazcarate.divinanatura.Autentication.Interactor;

/**
 * Created by Luis on 5/12/16.
 */

public interface ILoginInteractor {

    void login(String email, String pass, Callbacks callbacks);


    interface Callbacks {

        void onErrorEmail();

        void onErrorPassword();

        void onSuccess();

        void onFalloAuth(String msg);



    }
}
