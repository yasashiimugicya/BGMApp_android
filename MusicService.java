package com.example.bgmapp01;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    private MediaPlayer player; //メディアプレイヤー

    @Override
    public void onCreate() {
        super.onCreate();

        //MediaPlayerのオブジェクトを生成
        player = MediaPlayer.create(this, R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start(); //再生開始
        player.setLooping(true); //繰り返し再生設定

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop(); //停止
        player.release(); //リソースの開放
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
