package com.example.intentscalculareas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int RECTANGLE_REQ_CODE = 1;
    final static  int TRIANGLE_REQ_CODE = 1;

    Button rect_btn, tria_btn;
    TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rect_btn = findViewById(R.id.ui_btn_rectangle);
        tria_btn = findViewById(R.id.ui_btn_triangle);
        tv_main = findViewById(R.id.ui_tv_resultMain);

        rect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RectangleAreaActivity.class);
                startActivityForResult(intent, RECTANGLE_REQ_CODE);
            }
        });

        tria_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TriangleAreaActivity.class);
                startActivityForResult(intent, TRIANGLE_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RECTANGLE_REQ_CODE) {

             if (resultCode == RectangleAreaActivity.VALID_RESULT_CODE) {

                String oldText = tv_main.getText().toString();
                int NewArea = data.getIntExtra(RectangleAreaActivity.RECTANGLE_AREA_VALUE, 0);
                tv_main.setText(oldText + "\n Rectangle: " + NewArea);}

             else if (resultCode == RectangleAreaActivity.INVALID_RESULT_CODE) {

                String oldText = tv_main.getText().toString();
                int width = data.getIntExtra(RectangleAreaActivity.RECTANGLE_WIDTH_VALUE, 0);
                int height = data.getIntExtra(RectangleAreaActivity.RECTANGLE_HEIGHT_VALUE, 0);
                tv_main.setText(oldText + "\n Rectangle Error: " + width + " * " + height);}

         else /*if (requestCode == TriangleAreaActivity.VALID_RESULT_CODE) */{
               /* String oldText = tv_main.getText().toString();
                double NewArea = data.getDoubleExtra(TriangleAreaActivity.TRIANGLE_AREA_VALUE, 7);
                tv_main.setText(oldText + "\n Triangle: " + NewArea);*/
                 Toast.makeText(getBaseContext(),"Hello",Toast.LENGTH_SHORT).show();
            }


        }
    }
}