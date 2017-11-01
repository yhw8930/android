package com.example.a11709.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private EditText inputText;
    private MsgAdapter adapter;
    private RecyclerView msgRecyclerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        inputText=(EditText)findViewById(R.id.input_text);
        Button send=(Button)findViewById(R.id.send);
        msgRecyclerList=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerList.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerList.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    //当有新消息时，刷新RecyclerView中的显示
                    msgRecyclerList.scrollToPosition(msgList.size()-1);
                    //将RecyclerView定位到最后一行
                    inputText.setText("");
                    //清空输入框中的内容
                }
            }
        });
    }
    private void initMsg(){
        Msg msg1=new Msg("你好！", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("你好！请问你是谁？",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3=new Msg("我是帅哥。很高兴认识你！",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
