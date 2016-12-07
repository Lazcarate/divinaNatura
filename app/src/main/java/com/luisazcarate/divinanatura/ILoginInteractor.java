package com.luisazcarate.divinanatura;

/**
 * Created by Luis on 5/12/16.
 */

public interface ILoginInteractor {

    void login(String email, String pass, Callbacks callbacks);

    interface Callbacks {

        void onErrorEmail(String msg);

        void onErrorPassword(String msg);

        void onSuccess();

        void onFalloAuth(String msg);

    }
}
