package com.example.lr14;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etGroup, etScore;
    private Button btnSendData, btnOpenWeb;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String message = data.getStringExtra("result_message");
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGroup = findViewById(R.id.etGroup);
        etScore = findViewById(R.id.etScore);
        btnSendData = findViewById(R.id.btnSendData);
        btnOpenWeb = findViewById(R.id.btnOpenWeb);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String group = etGroup.getText().toString();
                int score = Integer.parseInt(etScore.getText().toString());

                Student student = new Student(name, group, score);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("student", student);
                activityResultLauncher.launch(intent);
            }
        });

        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
    }
}