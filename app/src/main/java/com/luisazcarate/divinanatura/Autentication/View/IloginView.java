package com.luisazcarate.divinanatura.Autentication.View;

/**
 * Created by Luis on 5/12/16.
 */

/**
 * Representa la funcionalidad de la vista Login
 */
public interface IloginView {

    void showProgress();
    void hideProgress();
    void setEmailError(String msg);
    void setPasswordError(String msg);
    void aInicio();
    void showLoginError(String msg);
}
