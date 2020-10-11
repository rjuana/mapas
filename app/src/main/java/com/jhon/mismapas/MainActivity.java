package com.jhon.mismapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView t1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificacion(View V){
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        t1 = findViewById(R.id.textView);
                        t1.setText(msg);
                    }
                });

    }
    public void lanzar(View v){

    }
    public void irMapa(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("uno", 1);
        startActivity(i);
    }
    public void irMapa1(View v){
        Intent j = new Intent(this, MapsActivity.class);
        j.putExtra("dos", 2);
        startActivity(j);
    }
    public void irMapa2(View v){
        Intent j = new Intent(this, MapsActivity.class);
        j.putExtra("tres", 3);
        startActivity(j);
    }
    public void irMapa3(View v){
        Intent j = new Intent(this, MapsActivity.class);
        j.putExtra("cuatro", 4);
        startActivity(j);
    }
}