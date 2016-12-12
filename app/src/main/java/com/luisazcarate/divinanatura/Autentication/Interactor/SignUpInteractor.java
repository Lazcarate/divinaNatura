package com.luisazcarate.divinanatura.Autentication.Interactor;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.luisazcarate.divinanatura.Autentication.Interactor.ISignUPInteractor;


/**
 * Created by Luis on 7/12/16.
 */

public class SignUpInteractor implements ISignUPInteractor {

    private FirebaseAuth mFirebaseAuth;


    public SignUpInteractor() {


        mFirebaseAuth = FirebaseAuth.getInstance();

    }

    private boolean isValidoEmail(String email, ISignUPInteractor.Callbacks callbacks){

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

    private boolean isValidoPassword(String pass, ISignUPInteractor.Callbacks callbacks){

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


    public void inicioSesion (String email, String pass, final Callbacks callbacks){

        //boolean checkNom = isValidoNombre(nom, callbacks);
        boolean checkEmail = isValidoEmail(email, callbacks);
        boolean checkPass = isValidoPassword(pass, callbacks);


        if(!(checkEmail && checkPass)){
            return;
        }

       // signUp(nom, email, pass, callbacks);
        signUp(email, pass, callbacks);

    }


    private void signUp(String email, String pass, final Callbacks callbacks) {

        mFirebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    //Retorna un objeto Task con el resultado de la comprobacion
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Si fue un exito
                        if (task.isSuccessful()) {
                            callbacks.onSuccessSignup();
                        }
                        else {
                            callbacks.onFalloAuth(task.getException().toString());

                        //Si no fue un exito
                       // callbacks.onFalloAuth(task.getException().toString());
                    }
                }
    });




                    }
                }


