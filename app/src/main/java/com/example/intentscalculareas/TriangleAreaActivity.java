package com.example.intentscalculareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriangleAreaActivity extends AppCompatActivity {

    final static int VALID_RESULT_CODE = 1;
    //final static int INVALID_RESULT_CODE = 2;

    final static String TRIANGLE_AREA_VALUE = "triangle_area";

    EditText et_base, et_height;
    TextView tv_result;
    Button btn_calculate, btn_backHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_area);

        et_height = findViewById(R.id.trian_et_height);
        et_base = findViewById(R.id.trian_et_base);
        tv_result = findViewById(R.id.trian_tv_result);
        btn_calculate = findViewById(R.id.trian_btn_calculate);
        btn_backHome = findViewById(R.id.trian_btn_backHome);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String comp_height = et_height.getText().toString();
                String comp_base = et_base.getText().toString();


                if (comp_height.matches("") && comp_base.matches("")) {

                    Toast.makeText(getBaseContext(),"Empty Fields",Toast.LENGTH_SHORT).show();


                } else {

                    int base = Integer.parseInt(et_base.getText().toString());
                    int height = Integer.parseInt(et_height.getText().toString());


                    double area = 0.5 * base * height;


                    Intent intent = new Intent();
                    intent.putExtra(TRIANGLE_AREA_VALUE, area);

                    setResult(VALID_RESULT_CODE, intent);
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