package com.luisazcarate.divinanatura;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Luis on 7/12/16.
 */

public class SignUpInteractor implements ISignUPInteractor {

    private FirebaseAuth mFirebaseAuth;


    public SignUpInteractor() {


        mFirebaseAuth = FirebaseAuth.getInstance();

    }


    @Override
    public void signUp(String nom, String email, String pass, final Callbacks callbacks) {

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


