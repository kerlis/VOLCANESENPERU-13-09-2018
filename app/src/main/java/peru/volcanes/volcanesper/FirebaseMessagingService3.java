package peru.volcanes.volcanesper;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService3  extends com.google.firebase.messaging.FirebaseMessagingService {
    String nobrevolcan_r2;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String valor = remoteMessage.getData().get("body");
        //enviarnotificaciondatosreporteordinario(remoteMessage.getData().get("body"));
        String tiponotificacion = valor.split("&")[0];
        String volcan = valor.split("&")[1];
        String tipodevento = valor.split("&")[2];
        String fecha = valor.split("&")[3];
        String hora = valor.split("&")[4];
        String observaciones = valor.split("&")[5];
        String simulacro = valor.split("&")[6];
        String horautc = valor.split("&")[7];




        String va =  String.valueOf(volcan);

        if(va.equals("1493157379002")){
            nobrevolcan_r2 = "Volcán Ubinas";
        }
        else if(va.equals("1493157381161")) {
            nobrevolcan_r2 = "Volcán Sabancaya";
        }
        else if(va.equals("1506454510537")) {
            nobrevolcan_r2 = "Volcán Sara Sara";
        }
        else if(va.equals("1506455245814")) {
            nobrevolcan_r2 = "Volcán Cerro Auquihuato";
        }
        else if(va.equals("1506455248101")) {
            nobrevolcan_r2 = "Volcán Andahua";
        }
        else if(va.equals("1506455249661")) {
            nobrevolcan_r2 = "Volcán Coropuna";
        }
        else if(va.equals("1506455251429")) {
            nobrevolcan_r2 = "Volcán Huambo";
        }
        else if(va.equals("1506455253382")) {
            nobrevolcan_r2 = "Volcán Chachani";
        }
        else if(va.equals("1506455254838")) {
            nobrevolcan_r2 = "Volcán Tutupaca";
        }
        else if(va.equals("1506455256229")) {
            nobrevolcan_r2 = "Volcán Huaynaputina";
        }
        else if(va.equals("1506455257749")) {
            nobrevolcan_r2 = "Volcán Ticsani";
        }
        else if(va.equals("1506455257753")) {
            nobrevolcan_r2 = "Volcán Casiri";
        }
        else if(va.equals("1506455257755")) {
            nobrevolcan_r2 = "Volcán Cerros Purupuruni";

        }
        else if(va.equals("1506455257757")) {
            nobrevolcan_r2 = "Volcán Quimsachata";
        }
        else if(va.equals("1506455259126")) {
            nobrevolcan_r2 = "Volcán Yucamane";
        }
        else if(va.equals("1506455259128")) {
            nobrevolcan_r2 = "Volcán Misti";
        }
        else {
            nobrevolcan_r2 = "Volcán";
        }




        if (tiponotificacion.equals("n01")){
            enviarnotificaciondatosalertalahar(remoteMessage.getData().get("body"));
        }

        else if(tiponotificacion.equals("n02")){
            enviarnotificaciondatosreporteextraordinario(remoteMessage.getData().get("body"));
        }

        else if(tiponotificacion.equals("n03")){
            enviarnotificaciondatoalertadecenizas(remoteMessage.getData().get("body"));
        }

        else if(tiponotificacion.equals("n04")){
            enviarnotificaciondatosreporteordinario(remoteMessage.getData().get("body"));
        }

        else{
            enviarnotificaciondatoalertadecenizas(remoteMessage.getData().get("body"));
        }

    }

    private void enviarnotificaciondatoalertadecenizas(String messageBody) {




        String tiponotificacion2 = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String pueblos = messageBody.split("&")[2];
        String tipodevento = messageBody.split("&")[3];
        String direccion = messageBody.split("&")[4];
        String radio = messageBody.split("&")[5];
        String fecha = messageBody.split("&")[6];
        String hora = messageBody.split("&")[7];
        String recomendaciones = messageBody.split("&")[8];
        String observaciones = messageBody.split("&")[9];
        String simulacro = messageBody.split("&")[10];
        String horautc = messageBody.split("&")[11];

        String asubstring = fecha.substring(0, 10);

        Intent intent = new Intent(this, Alertando.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String tiponotificacion = messageBody;
        Intent intentlahar = new Intent(getApplicationContext(), Alertando.class);
        intentlahar.putExtra("NOTIFICACIONDATA", tiponotificacion);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentlahar, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alerta de Cenizas")
                .setContentText(nobrevolcan_r2  + " " + asubstring + " " + " " + hora +" " )
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notificationBuilder.build());
        //mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());

    }

    private void enviarnotificaciondatosalertalahar(String messageBody) {


        String tiponotificacion2 = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String tipodevento = messageBody.split("&")[2];
        String fecha = messageBody.split("&")[3];
        String hora = messageBody.split("&")[4];
        String horautc = messageBody.split("&")[5];
        String observaciones = messageBody.split("&")[6];
        String simulacro = messageBody.split("&")[7];

        String asubstring = fecha.substring(0, 10);

        Intent intent2 = new Intent(this, Alertadatoslahar.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String tiponotificacion3 = messageBody;
        Intent intentlahar3 = new Intent(getApplicationContext(), Alertadatoslahar.class);
        intentlahar3.putExtra("NOTIFICACIONDATA", tiponotificacion3);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentlahar3, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alerta de Lahar")
                .setContentText(nobrevolcan_r2  + " " + asubstring + " " + " " + hora +" " )
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notificationBuilder.build());
        //mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

    private void enviarnotificaciondatosreporteextraordinario(String messageBody) {

        String tiponotificacion2 = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        //String tipodevento = messageBody.split("&")[2];
        String fecha = messageBody.split("&")[2];
        String hora = messageBody.split("&")[3];
        String simulacro = messageBody.split("&")[4];
        String horautc = messageBody.split("&")[5];
        String reportepdf = messageBody.split("&")[6];
        String coloralerta = messageBody.split("&")[7];
        String analisis = messageBody.split("&")[8];
        String conclusiones = messageBody.split("&")[9];
        String fecha_subs = fecha.substring(0, 10);

        Intent intent = new Intent(this, Alertareporteactividad.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String tiponotificacion = messageBody;
        Intent intentlahar = new Intent(getApplicationContext(), Alertareporteactividad.class);
        intentlahar.putExtra("NOTIFICACIONDATA", tiponotificacion);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentlahar, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alerta de Reporte Extraordinario")
                .setContentText(nobrevolcan_r2  + " " + fecha_subs + " " + " " + hora +" " )
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notificationBuilder.build());
        //mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

    private void enviarnotificaciondatosreporteordinario(String messageBody) {

        String tiponotificacion2 = messageBody.split("&")[0];
        String volcan = messageBody.split("&")[1];
        String fecha = messageBody.split("&")[2];
        String hora = messageBody.split("&")[3];
        String simulacro = messageBody.split("&")[4];
        String horautc = messageBody.split("&")[5];
        String reportepdf = messageBody.split("&")[6];
        String coloralerta = messageBody.split("&")[7];
        String analisis = messageBody.split("&")[8];
        String conclusiones = messageBody.split("&")[9];

        String fecha_subs = fecha.substring(0, 10);



        Intent intent = new Intent(this, Alertareporteactividad.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String tiponotificacion = messageBody;
        Intent intentlahar = new Intent(getApplicationContext(), Alertareporteactividad.class);
        intentlahar.putExtra("NOTIFICACIONDATA", tiponotificacion);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentlahar, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alerta de Reporte Ordinario")
                .setContentText(nobrevolcan_r2  + " " + fecha_subs + " " + " " + hora +" " )
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notificationBuilder.build());
        //mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}