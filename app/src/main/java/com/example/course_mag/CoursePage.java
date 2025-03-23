package com.example.course_mag;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoursePage extends AppCompatActivity {
    ConstraintLayout courseBg;
    ImageView courseImg;
    TextView courseTitle, courseLevel, courseDate, courseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.coursePageBg), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        courseBg=findViewById(R.id.coursePageBg);
        courseImg=findViewById(R.id.coursePageImg);
        courseTitle=findViewById(R.id.couraePageTitle);
        courseLevel=findViewById(R.id.coursePageLevel);
        courseDate=findViewById(R.id.coursePageDate);
        courseText=findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImg.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));
    }
}