package com.luisazcarate.divinanatura.Notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.luisazcarate.divinanatura.R;

/**
 * Created by Luis on 14/12/16.
 */

public class Notifications extends FirebaseMessagingService {

    public Notifications() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(remoteMessage.getNotification() != null){

            mostrarNotificacion(remoteMessage.getNotification().getBody());
        }
    }

    private void mostrarNotificacion(String cuerpo) {

        Intent intent = new Intent(this, NotificacionActivity.class);
        intent.putExtra("cuerpo", cuerpo);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//Reorganiza la pila de actividades.
        PendingIntent pendIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri uriSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.pan)
                .setContentTitle("Mensaje de Divina Natura")
                .setSound(uriSound)
                .setContentIntent(pendIntent);
        NotificationManager noti = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        noti.notify(0, notificacion.build());
    }
}
