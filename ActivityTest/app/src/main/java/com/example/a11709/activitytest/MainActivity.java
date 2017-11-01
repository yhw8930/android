package com.example.a11709.activitytest;

import android.content.Intent;
//import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("FirstActivity",this.toString());
        Log.d("FirstActivity","Task id is"+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*Toast.makeText(MainActivity.this,"You click button 1",
                        Toast.LENGTH_SHORT).show();*/
                //finish();
                //Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                /*Intent intent=new Intent("com.example.a11709.activitytest.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("com.example.a11709.activitytest.MY_CATEGORY");*/

                /*Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://baidu.com"));
                startActivity(intent);*/
                /*
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/
                /*String data="Hellow SecongActivity";
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/
                /*Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,1);*/
                /*Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);*/
                Main2Activity.actionStart(MainActivity.this, "data1", "data2");
            }
        });
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
