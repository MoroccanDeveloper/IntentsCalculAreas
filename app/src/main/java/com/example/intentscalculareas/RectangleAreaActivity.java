package com.example.intentscalculareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RectangleAreaActivity extends AppCompatActivity {

    final static int VALID_RESULT_CODE = 1;
    final static int INVALID_RESULT_CODE = 2;

    final static String RECTANGLE_WIDTH_VALUE = "rectangle_width";
    final static String RECTANGLE_HEIGHT_VALUE = "rectangle_height";
    final static String RECTANGLE_AREA_VALUE = "rectangle_area";

    EditText et_width, et_height;
    TextView tv_result;
    Button btn_calculate, btn_backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_area);

        et_height = findViewById(R.id.rect_et_height);
        et_width = findViewById(R.id.rect_et_width);
        tv_result = findViewById(R.id.rect_tv_result);
        btn_calculate = findViewById(R.id.rect_btn_calculate);
        btn_backHome = findViewById(R.id.rect_btn_backHome);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String comp_height = et_height.getText().toString();
                String comp_width = et_width.getText().toString();


                if (comp_height.matches("") && comp_width.matches("")) {

                    Toast.makeText(getBaseContext(),"Empty Fields",Toast.LENGTH_SHORT).show();


                } else {

                    int width = Integer.parseInt(et_width.getText().toString());
                    int height = Integer.parseInt(et_height.getText().toString());


                    int area = width * height;

                    Intent intent = new Intent();

                    if (area < 0) {

                        intent.putExtra(RECTANGLE_WIDTH_VALUE, width);
                        intent.putExtra(RECTANGLE_HEIGHT_VALUE, height);
                        setResult(INVALID_RESULT_CODE, intent);

                    } else {

                        intent.putExtra(RECTANGLE_AREA_VALUE, area);
                        setResult(VALID_RESULT_CODE, intent);

                    }
                finish();
                 }
                }

        });



        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(homeIntent);
            }
        });


    }
}