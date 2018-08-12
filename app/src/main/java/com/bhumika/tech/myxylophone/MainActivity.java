// specifying the package this class belongs to
package com.bhumika.tech.myxylophone;

// importing the in-built packages, so that we can use them
import android.content.Intent; // Intents are required to switch from 1 activity to another
import android.media.AudioManager; // For managing the audio files
import android.media.SoundPool; // For managing the audio files

// Basic app building components
import android.os.Build;
import android.support.v7.app.AppCompatActivity; //parent class for our activity
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // "extends" used to "inherit" classes. That is, get some basic properties/behaviours from parent class
    // "implements" used to "implement", i.e. give the logic for an interface

    // AppCompatActivity is a type on activity
    // View.OnClickListener listens/looks out for "click" events on views that are "registered" with it

    private static final int MAX_STREAMS = 8; // Maximum number of audio files that can be played "simultaneously"
    private Button note1_c, note2_d, note3_e, note4_f, note5_g, note6_a, note7_b; // These references will contain out Xylophone Buttons
    private Button libraryButton; // This reference will contain our "LIBRARY" button
    private SoundPool soundPool; // This reference will hold an object of the "SoundPool" class that is used to manage our audio files
    private int C_ID, D_ID, E_ID, F_ID, G_ID, A_ID, B_ID; // References to the audio files when present in the SoundPool

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // setting the UI contained in avtivity_main.xml

        initLayouts(); // get the different layout objects & assign them to corressponding references

        // Syntax of SoundPool for newer Android versions, after & including Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Build.VERSION.SDK_INT is a "constant" that holds our MinSDK version
            // Build.VERSION_CODES.LOLLIPOP is a "constant" that holds the version number of Lollipop
            soundPool = new SoundPool.Builder().setMaxStreams(MAX_STREAMS).build();
            // setMaxStream() sets the maximum number of sounds that can be played simultaneously
        }
        // Syntax of SoundPool for older Android versions, before Lollipop
        else {
            // The strike-through signifies that this is the old syntax & is deprecated
            soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }
        getAudioFileIDs();
    }

    private void initLayouts() {

        // Find the views by their ID & save them
        note1_c = findViewById(R.id.note1_c);
        note2_d = findViewById(R.id.note2_d);
        note3_e = findViewById(R.id.note3_e);
        note4_f = findViewById(R.id.note4_f);
        note5_g = findViewById(R.id.note5_g);
        note6_a = findViewById(R.id.note6_a);
        note7_b = findViewById(R.id.note7_b);
        libraryButton = findViewById(R.id.libraryButton);

        // register the views with the onClickListener so that "click" events on them can be detected
        note1_c.setOnClickListener(this);
        note2_d.setOnClickListener(this);
        note3_e.setOnClickListener(this);
        note4_f.setOnClickListener(this);
        note5_g.setOnClickListener(this);
        note6_a.setOnClickListener(this);
        note7_b.setOnClickListener(this);
        libraryButton.setOnClickListener(this);
    }

    private void getAudioFileIDs() {
        C_ID = soundPool.load(getApplicationContext(), R.raw.note1_c, 1);
        D_ID = soundPool.load(getApplicationContext(), R.raw.note2_d, 1);
        E_ID = soundPool.load(getApplicationContext(), R.raw.note3_e, 1);
        F_ID = soundPool.load(getApplicationContext(), R.raw.note4_f, 1);
        G_ID = soundPool.load(getApplicationContext(), R.raw.note5_g, 1);
        A_ID = soundPool.load(getApplicationContext(), R.raw.note6_a, 1);
        B_ID = soundPool.load(getApplicationContext(), R.raw.note7_b, 1);
    }

    @Override
    public void onClick(View view) {
        int buttonID = view.getId(); // get the ID of the view that was clicked

        // loop ---> how many times to "repeat" the audio file
        // rate ---> speed at which audio must be played. 0.5(half-speed) is min & 2(double-speed) is max
        switch (buttonID)
        {
            case R.id.note1_c: // if C note was clicked
                soundPool.play(C_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note2_d: // if D note was clicked
                soundPool.play(D_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note3_e: // if E note was clicked
                soundPool.play(E_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note4_f: // if F note was clicked
                soundPool.play(F_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note5_g: // if G note was clicked
                soundPool.play(G_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note6_a: // if A note was clicked
                soundPool.play(A_ID, 1, 1, 1, 0, 1);
                break;
            case R.id.note7_b: // if B note was clicked
                soundPool.play(B_ID, 1, 1, 1, 0, 1);
                break;

            case R.id.libraryButton: // If "LIBRARY" button was clicked

                // Intent is was to tell the system, "from" which screen/activity "to" which screen/activity you wish to switch
                Intent intent = new Intent(this, LibraryActivity.class);
                // Start the activity based on the intent specified
                startActivity(intent);
                // go to "LibraryActivity.java" for further details
                break;
        }
    }
}
