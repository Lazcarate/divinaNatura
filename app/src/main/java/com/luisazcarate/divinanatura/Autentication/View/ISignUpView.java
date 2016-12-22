package com.luisazcarate.divinanatura.Autentication.View;

/**
 * Created by Luis on 7/12/16.
 */

public interface ISignUpView {

    void aLogin();
    void setEmailError();
    void setPasswordError();
    void showSignUpError(String msg);
    void set_re_PasswordError();
}
