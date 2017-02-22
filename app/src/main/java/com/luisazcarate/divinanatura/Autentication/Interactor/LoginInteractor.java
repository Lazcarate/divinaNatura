package com.luisazcarate.divinanatura.Autentication.Interactor;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.luisazcarate.divinanatura.Autentication.Interactor.ILoginInteractor;
import com.luisazcarate.divinanatura.R;

/**
 * Created by Luis on 5/12/16.
 */

public class LoginInteractor implements ILoginInteractor {


    private FirebaseAuth mFirebaseAuth;


    public LoginInteractor() {


        mFirebaseAuth = FirebaseAuth.getInstance();

        }
    @Override
    public void login(String email, String pass, final Callbacks callbacks) {


        boolean onProblems = false;

        //Validamos correo

        if ((TextUtils.isEmpty(email)) || (!Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            callbacks.onErrorEmail();
            onProblems = true;
        }
        //Validamos password
        if(TextUtils.isEmpty(pass)){
            callbacks.onErrorPassword();
            onProblems = true;
        }
        if(!onProblems){
            //Logeamos
            mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        //Retorna un objeto Task con el resultado de la comprobacion
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Si no fue un exito
                            if(!task.isSuccessful()){
                                callbacks.onFalloAuth(task.getException().getMessage());

                            } else {
                                //Si fue un exito
                                callbacks.onSuccess();

                            }
                        }
                    });
        }
        }







}

