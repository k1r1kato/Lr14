package com.example.lr14;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName, tvGroup, tvScore;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.tvName);
        tvGroup = findViewById(R.id.tvGroup);
        tvScore = findViewById(R.id.tvScore);
        btnBack = findViewById(R.id.btnBack);

        Student student = (Student) getIntent().getSerializableExtra("student");

        if (student != null) {
            tvName.setText("Имя: " + student.getName());
            tvGroup.setText("Группа: " + student.getGroup());
            tvScore.setText("Баллы: " + student.getScore());
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_message", "Данные успешно получены");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}