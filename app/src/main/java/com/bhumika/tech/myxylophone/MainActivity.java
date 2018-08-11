package com.bhumika.tech.myxylophone;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MAX_STREAMS = 8;
    private Button note1_c, note2_d, note3_e, note4_f, note5_g, note6_a, note7_b, note8_c;
    private Button libraryButton;
    private SoundPool soundPool;
    private int C_ID, D_ID, E_ID, F_ID, G_ID, A_ID, B_ID, HC_IC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayouts();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //new version
            soundPool = new SoundPool.Builder().setMaxStreams(MAX_STREAMS).build();
        } else {
            //use deprecated one
            soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }
        C_ID = soundPool.load(getApplicationContext(), R.raw.note1_c, 1);
        D_ID = soundPool.load(getApplicationContext(), R.raw.note2_d, 1);
        E_ID = soundPool.load(getApplicationContext(), R.raw.note3_e, 1);
        F_ID = soundPool.load(getApplicationContext(), R.raw.note4_f, 1);
        G_ID = soundPool.load(getApplicationContext(), R.raw.note5_g, 1);
        A_ID = soundPool.load(getApplicationContext(), R.raw.note6_a, 1);
        B_ID = soundPool.load(getApplicationContext(), R.raw.note7_b, 1);
        //HC_ID = soundPool.load(getApplicationContext(), R.raw.note8_c, 1);
    }

    private void initLayouts() {
        note1_c = findViewById(R.id.note1_c);
        note2_d = findViewById(R.id.note2_d);
        note3_e = findViewById(R.id.note3_e);
        note4_f = findViewById(R.id.note4_f);
        note5_g = findViewById(R.id.note5_g);
        note6_a = findViewById(R.id.note6_a);
        note7_b = findViewById(R.id.note7_b);
        note8_c = findViewById(R.id.note8_c);
        libraryButton = findViewById(R.id.libraryButton);

        note1_c.setOnClickListener(this);
        note2_d.setOnClickListener(this);
        note3_e.setOnClickListener(this);
        note4_f.setOnClickListener(this);
        note5_g.setOnClickListener(this);
        note6_a.setOnClickListener(this);
        note7_b.setOnClickListener(this);
        note8_c.setOnClickListener(this);
        libraryButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int buttonID = view.getId();
        switch (buttonID)
        {
            case R.id.note1_c:
                soundPool.play(C_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note2_d:
                soundPool.play(D_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note3_e:
                soundPool.play(E_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note4_f:
                soundPool.play(F_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note5_g:
                soundPool.play(G_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note6_a:
                soundPool.play(A_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note7_b:
                soundPool.play(B_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note8_c:
                //soundPool.play(HC_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.libraryButton:
                Intent intent = new Intent(this, LibraryActivity.class);
                startActivity(intent);
                break;
        }
    }
}
