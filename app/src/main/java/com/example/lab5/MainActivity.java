package com.example.lab5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int createCount, startCount, resumeCount, pauseCount, restartCount, stopCount, destroyCount = 0;
    Button resetButton;
    TextView textBox;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        resetButton = findViewById(R.id.reset);
        textBox = findViewById(R.id.textbox);
        createCount = pref.getInt("create", 0);
        startCount = pref.getInt("start", 0);
        resumeCount = pref.getInt("resume", 0);
        pauseCount = pref.getInt("pause", 0);
        restartCount = pref.getInt("restart", 0);
        stopCount = pref.getInt("stop", 0);
        destroyCount = pref.getInt("destroy", 0);
        createCount++;
        editor.putInt("create", createCount);
        editor.commit();
        display();
    }
    public void onStart() {
        super.onStart();
        startCount++;
        editor.putInt("start", createCount);
        editor.commit();
        display();
    }
    public void onResume() {
        super.onResume();
        resumeCount++;
        editor.putInt("resume", resumeCount);
        editor.commit();
        display();
    }
    public void onPause() {
        super.onPause();
        pauseCount++;
        editor.putInt("pause", pauseCount);
        editor.commit();
        display();
    }
    public void onRestart() {
        super.onRestart();
        restartCount++;
        editor.putInt("restart", restartCount);
        editor.commit();
        display();
    }
    public void onStop() {
        super.onStop();
        stopCount++;
        editor.putInt("stop", stopCount);
        editor.commit();
        display();
    }
    public void onDestroy() {
        Log.i("destroy", "Currently being destroyed");
        super.onDestroy();
        destroyCount++;
        editor.putInt("destroy", destroyCount);
        Log.i("destroyVal", "" + destroyCount);
        editor.commit();
        display();
    }
    public void display(){
        textBox.setText("Create:" + createCount + ", Start:" + startCount + ", Resume:" + resumeCount + ", Pause:" + pauseCount + ", Restart:" + restartCount + ", Stop: " + stopCount + ", Destroy:" + destroyCount);
        Log.i("Create", "" + createCount);
        Log.i("Start", "" + startCount);
        Log.i("Resume", "" + resumeCount);
        Log.i("Pause", "" + pauseCount);
        Log.i("Restart", "" + restartCount);
        Log.i("Stop", "" + stopCount);
        Log.i("Destroy", "" + destroyCount);
    }
    public void resetVals(View view){
        createCount = 0;
        resumeCount = 0;
        startCount = 0;
        pauseCount = 0;
        restartCount = 0;
        stopCount = 0;
        destroyCount = 0;
        editor.putInt("create", createCount);
        editor.putInt("start", startCount);
        editor.putInt("resume", resumeCount);
        editor.putInt("pause", pauseCount);
        editor.putInt("restart", restartCount);
        editor.putInt("stop", stopCount);
        editor.putInt("destroy", destroyCount);
        editor.commit();
        display();
    }
}
