package com.luisazcarate.divinanatura;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Patterns;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

        if(!(isValidoEmail(email, callbacks) && isValidoPassword(pass, callbacks))){
            return;
        }
        mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    //Retorna un objeto Task con el resultado de la comprobacion
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Si fue un exito
                        if(task.isSuccessful()){
                            callbacks.onSuccess();

                        } else {
                            //Si no fue un exito
                            callbacks.onFalloAuth(task.getException().toString());


                        }
                    }
                });
    }


    public boolean isValidoEmail(String email, Callbacks callbacks){

        boolean esValido = true;

        if(TextUtils.isEmpty(email)){
            esValido = false;
            callbacks.onErrorEmail("email vacio");
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            esValido=false;
            callbacks.onErrorEmail("email incorrecto");
        }
        return esValido ;
    }

    public boolean isValidoPassword(String pass, Callbacks callbacks){

        boolean esValido = true;

        if(TextUtils.isEmpty(pass)){
            esValido = false;
            callbacks.onErrorPassword("pass vacio");
        }
        if(pass.length() < 4 || pass.length() > 10){
            esValido = false;
            callbacks.onErrorPassword("pass incorrecto");
        }
        return esValido ;

    }


}

