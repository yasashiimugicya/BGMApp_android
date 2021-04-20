package com.example.bgmapp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STARTボタンのオブジェクトの取得とイベントリスナ登録
        Button start = (Button)findViewById(R.id.button1);
        start.setOnClickListener(this);

        //STOPボタンのオブジェクトの取得とイベントリスナ登録
        Button stop = (Button)findViewById(R.id.button2);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId(); //押されたボタンのリソースIDを取得

        //インテントの生成
        Intent intent = new Intent(this, MusicService.class);

        switch (id) {
            case R.id.button1 : //「START」ボタンを押した時の処理
                startService(intent);
                break;
            case R.id.button2 : //「STOP」ボタンを押した時の処理
                stopService(intent);
                break;
        }
    }

}
