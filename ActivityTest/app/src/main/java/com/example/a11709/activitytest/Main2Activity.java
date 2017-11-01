package com.example.a11709.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends BaseActivity {

    public static void actionStart(Context context,String data1,String data2){
        Intent intent=new Intent(context,Main2Activity.class);
        intent.putExtra("p1",data1);
        intent.putExtra("p2",data2);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("SecondActivity",this.toString());
        Log.d("SecondActivity","Task id is"+getTaskId());
        setContentView(R.layout.second_layout);
        /*Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("输出信息",data);*/
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent();
                intent.putExtra("data_return","Hellow FirstActivity");
                setResult(RESULT_OK,intent);
                finish();*/
                Intent intent=new Intent(Main2Activity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return","Hellow FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
