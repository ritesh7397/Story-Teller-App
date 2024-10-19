
package com.Pbcoe.Final.StoryTellar.stories;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Pbcoe.Final.StoryTellar.R;

import java.util.HashMap;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

public class Scared_Lil_Mouse extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

    @BindView(R.id.Lil_Mouse_textSent)
    TextView LilMouseTextSent;
    @BindView(R.id.Lil_Mouse_TextWord)
    TextView LilMouseTextWord;
    @BindView(R.id.Lil_Mouse_Button_speak)
    ImageButton LilMouseButtonSpeak;
    @BindView(R.id.Lil_Mouse_button_stop)
    ImageButton LilMouseButtonStop;
    @BindView(R.id.Lil_Mouse_Sign_Gif)
    GifImageView LilMouseSignGif;

    int i = 0;
    int j = 0;
    float speed = 0.7f;
    float pitch = 0.8f;
    private TextToSpeech tts;

    String[] mouseWord = {"One", "day", "there", "was", "a", "mouse", "that", "was", "very", "afraid"," ",
            "A", "big", "cat", "was", "chasing", "him"," ",
            "The", "mouse", "was", "running", "as", "fast", "as", "he", "could", "to", "save", "his", "life"," ",
            "The", "mouse", "saw", "a", "big", "grandfather", "clock"," ",
            "It", "climbed", "up", "the", "clock"," ",
            "It", "reached", "the", "top", "and", "sat", "down", "to", "rest"," ",
            "Not", "long", "after", "that", "the", "clock", "struck", "one", "Dong!", " ",
            "The", "mouse", "had", "such", "a", "shock", "that", "he", "ran", "down", "the", "clock"};

    String[] mouseSentence = {"One day, there was a mouse that was very afraid.",
            "A big cat was chasing him.",
            "The mouse was running as fast as he could to save his life.",
            "The mouse saw a big grandfather clock.",
            "It climbed up the clock.",
            "It reached the top and sat down to rest." ,
            "Not long after that, the clock struck one, ‘Dong!’ ",
            "The mouse had such a shock that he ran down the clock."};

    String[] stop_words = {
            "the", "all", "into", "loaf", "but", "for", "and", "at", "found", "of", "in", "squeezed", "hole", "to",
            "have", "caught", "gave", "came", "on", "become", "trick", "with", "carry", "cotton", "that", "felt",
            "every", "stream", "lesson", "let", "upon", "tremble", "fear", "left", "another", "other", "by", "hunter",
            "thus", "afterwards", "used", "cross", "tumbled", "also", "fell", "hence", "loaded", "would", "be", "still",
            "become", "dampened", "wet", "anymore", "an", "feeling", "den", "find", "only", "hesitation", "can", "fill",
            "as", "about", "instead", "went", "letting", "off","it","was","but","didn't","could","were","over","just",
            "even","that","became","him","chasing","struck","dong","such","fairy","tale","if","therefore","story","will",
            "every","spring","villagers","noticed","nobody","over","shed","later","them","moral","oak","fence",
            "worse","observant","this","bush","through","where","customer","generously","dues","order","glittering",
            "capsized","speechless","grief","what","cheating","dealings","supreme","anymore","seller","won't","favor","about","instead"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scared__lil__mouse);
        ButterKnife.bind(this);
        Scared_Lil_Mouse.this.setTitle("Scared Little Mouse");

        LilMouseTextSent.setText(mouseSentence[0]);
        LilMouseTextWord.setText(mouseWord[0]);

        // Initialization of Text To Speech
        tts = new TextToSpeech(this, this);

        // Tracking of Words
        tts.setOnUtteranceProgressListener(mProgressListener);

        /* @OnClick Listener */
        LilMouseButtonSpeak.setOnClickListener(this);
        LilMouseButtonStop.setOnClickListener(this);
    }

    private void stop() {
        tts.stop();
        tts.shutdown();
        LilMouseTextWord.setText(mouseWord[0]);
        LilMouseTextSent.setText(mouseSentence[0]);
        LilMouseSignGif.setVisibility(View.INVISIBLE);
    }


    private void speak(String[] text, int i) {
        tts.setSpeechRate(speed);  // 0.7f
        tts.setPitch(pitch);
        HashMap<String, String> map = new HashMap<>();


        for (String s : stop_words) {
            if (mouseWord[i].toLowerCase(Locale.getDefault()).equals(s)) {
                char[] alphabet_array = s.toCharArray();

                for (char c : alphabet_array) {
                    map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, String.valueOf(c).toLowerCase(Locale.getDefault()));
                    tts.setSpeechRate(0.3f);
                    tts.speak(String.valueOf(c), TextToSpeech.QUEUE_ADD, map);
                }
            }
        }

        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, mouseWord[i]);
        tts.speak(mouseWord[i].toLowerCase(Locale.getDefault()), TextToSpeech.QUEUE_ADD, map);

    }

    UtteranceProgressListener mProgressListener = new UtteranceProgressListener() {
        @Override
        public void onStart(String utteranceId) {
            // For Highlighting Spoken Words
            String Replace = "<span style= 'background-color:green'>" + utteranceId + "</span>";
            LilMouseTextWord.setText(Html.fromHtml(Replace));

            new Thread(){
                @Override
                public void run() {

                }
            }.start();

            if(utteranceId.toLowerCase(Locale.getDefault()).equals("try") || utteranceId.toLowerCase(Locale.getDefault()).equals("catch") || utteranceId.toLowerCase(Locale.ROOT).equals("while")){
                int gif_view = getResources().getIdentifier(utteranceId.toLowerCase(Locale.getDefault()) +"1", "raw", getPackageName());
                LilMouseSignGif.setImageResource(gif_view);
            }else if(utteranceId.toLowerCase(Locale.getDefault()).equals("running")|| utteranceId.toLowerCase(Locale.getDefault()).equals("ran") ){
                int gif_view = getResources().getIdentifier("run", "raw", getPackageName());
                LilMouseSignGif.setImageResource(gif_view);
            }else if(utteranceId.toLowerCase(Locale.getDefault()).equals("reached")){
                int gif_view = getResources().getIdentifier("reach", "raw", getPackageName());
                LilMouseSignGif.setImageResource(gif_view);
            } else {
                int gif_view = getResources().getIdentifier(utteranceId.toLowerCase(Locale.getDefault()), "raw", getPackageName());
                LilMouseSignGif.setImageResource(gif_view);
            }
        }

        @Override
        public void onDone(String utteranceId) {

            if(utteranceId.equals(" ")){
               new Thread(){
                   @Override
                   public void run() {
                       j++;
                       LilMouseTextSent.setText(mouseSentence[j]);
                   }
               };
            }

            i = i + 1;
            speak(mouseWord, i);
        }

        @Override
        public void onError(String utteranceId) {
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.speedmeter,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.Slow :
                speed = 0.4f;
                Toast.makeText(this,"Slow is selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Normal :
                speed = 0.8f;
                Toast.makeText(this,"Normal is selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Fast :
                speed = 1.2f;
                Toast.makeText(this,"Fast is selected",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        stop();
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.ENGLISH);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.Lil_Mouse_Button_speak:
                speak(mouseWord,i);
                LilMouseButtonSpeak.setEnabled(false);
                break;

            case  R.id.Lil_Mouse_button_stop:
                LilMouseButtonSpeak.setEnabled(true);
                stop();
                break;
        }
    }
}
