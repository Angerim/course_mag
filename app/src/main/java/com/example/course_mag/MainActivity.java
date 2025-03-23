package com.example.course_mag;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.CategoryAdapter;
import adapter.CourseAdapter;
import model.Category;
import model.Course;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Сайты"));
        categoryList.add(new Category(3,"Языки"));
        categoryList.add(new Category(4,"Прочее"));
        setCategoryRecycler(categoryList);

        List<Course> courseList=new ArrayList<>();
        courseList.add(new Course(1,"java","Профессия Java\nразработчик","1 января", "начальный", "#424345","Text"));
        courseList.add(new Course(2,"python","Профессия Python\nразработчик","5 января", "начальный", "#9FA52D","Text"));
        courseList.add(new Course(3,"backend","Профессия Backend\nразработчик","1 января", "начальный", "#2D55A5","Text"));
        courseList.add(new Course(4,"frontend","Профессия Frontend\nразработчик","5 января", "начальный", "#B04935","Text"));
        courseList.add(new Course(5,"unity","Профессия Unity\nразработчик","1 января", "начальный", "#65173D","Text"));
        courseList.add(new Course(6,"fullstack","Профессия Fullstack\nразработчик","5 января", "начальный", "#FFC007","Text"));

        setCourseRecycler(courseList);

    }
    public void setCategoryRecycler(List<Category> categoryList){
        RecyclerView.LayoutManager layoutManager
        =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecycler=findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
    public void setCourseRecycler(List<Course> courseList){
        RecyclerView.LayoutManager layoutManager
                =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
      courseRecycler=findViewById(R.id.   courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);
         courseAdapter = new CourseAdapter(courseList,this);
        courseRecycler.setAdapter(courseAdapter);
    }
}