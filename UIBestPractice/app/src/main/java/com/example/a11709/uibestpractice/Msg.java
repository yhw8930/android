package com.example.a11709.uibestpractice;

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;
    private int type;
    private String content;
    public Msg(String content,int type){
        this.content=content;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
