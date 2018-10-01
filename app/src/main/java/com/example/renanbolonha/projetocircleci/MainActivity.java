package com.example.renanbolonha.projetocircleci;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textVersionCode;
    private TextView textVersionName;
    private Button buttonSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVersionCode = findViewById(R.id.text_version_code);
        textVersionName = findViewById(R.id.text_version_name);

        try {
            int versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            textVersionCode.setText(String.valueOf(versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            textVersionCode.setText("0");
            e.printStackTrace();
        }

        try {
            String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            textVersionName.setText(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            textVersionName.setText("X");
            e.printStackTrace();
        }

        buttonSendEmail = findViewById(R.id.button_send_email);
        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bolonha.renan@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
                intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automatica");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Escolha o App de e-mail"));
            }
        });


        // TODO: 06/08/2018 - AAAAAAAAAA 
        // TODO: 06/08/2018 - BBBBBBBBBB aasda
        corrigidoBug1();
    }

    private void corrigidoBug1() {
        Toast.makeText(getApplicationContext(), "BUG REMOVIDO", Toast.LENGTH_SHORT).show();

    }
}
