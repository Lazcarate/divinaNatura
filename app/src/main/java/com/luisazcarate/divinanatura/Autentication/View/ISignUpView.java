package com.luisazcarate.divinanatura.Autentication.View;

/**
 * Created by Luis on 7/12/16.
 */

public interface ISignUpView {

    void aLogin();
    void setEmailError(String msg);
    void setPasswordError(String msg);
    void showSignUpError(String msg);
}
