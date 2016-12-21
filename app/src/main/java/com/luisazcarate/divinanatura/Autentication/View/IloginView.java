package com.luisazcarate.divinanatura.Autentication.View;

/**
 * Created by Luis on 5/12/16.
 */

import android.support.v7.app.AlertDialog;

/**
 * Representa la funcionalidad de la vista Login
 */
public interface IloginView {

    void showProgress();
    void hideProgress();
    void setEmailError();
    void setPasswordError();
    void aInicio();
    void showLoginError(String msg);
}
