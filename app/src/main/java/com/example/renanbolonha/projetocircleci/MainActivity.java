package com.example.renanbolonha.projetocircleci;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textVersionCode;
    private TextView textVersionName;

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

    }
}
