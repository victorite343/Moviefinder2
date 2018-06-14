package com.example.administrator.moviefinder;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends MainActivityMovieFinder{
    EditText mobileno,message;
    Button sendsms;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smstocontacts);

        mobileno = (EditText) findViewById(R.id.editText1);
        message = (EditText) findViewById(R.id.editText2);
        sendsms = (Button) findViewById(R.id.button1);
        sendsms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String no = mobileno.getText().toString();
                String msg = message.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MovieDetails.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi, null);

                Toast.makeText(getApplicationContext(), "Message Sent successfully!", Toast.LENGTH_LONG).show();
            }
        });

    }
}




