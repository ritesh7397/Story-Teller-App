
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

public class Foolish_Donkey extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

    int i = 0;
    int j = 0;
    float speed = 0.7f;
    float pitch = 0.8f;
    private TextToSpeech tts;

    @BindView(R.id.fool_donkey_textview)
    TextView foolDonkeySentence;
    @BindView(R.id.fool_donkey_TextWord)
    TextView foolDonkeyWord;
    @BindView(R.id.fool_donkey_Button_speak)
    ImageButton foolDonkeyButtonSpeak;
    @BindView(R.id.fool_donkey_button_stop)
    ImageButton foolDonkeyButtonStop;
    @BindView(R.id.fool_donkey_SignImage)
    GifImageView foolDonkeySignGifs;


    String[] foolish = {
            "A", "salt", "seller", "used", "to", "carry", "the", "salt", "bag", "on", "his",
            "donkey", "to", "the", "market", "every", "day", " ",
            "On", "the", "way", "they", "had", "to", "cross", "a", "stream", " ",
            "One", "day", "the", "donkey", "suddenly", "tumbled", "down", "the", "stream",
            "and", "the", "salt", "bag", "also", "fell", "into", "the", "water", " ",
            "The", "salt", "dissolved", "in", "the", "water", "and", "hence", "the", "bag", "became", "very", "light", "to", "carry", " ",
            "The", "donkey", "was", "happy", " ",
            "Then", "the", "donkey", "started", "to", "play", "the", "same", "trick", "every", "day", " ",
            "The", "salt", "seller", "came", "to", "understand", "the", "trick", "and", "decided", "to", "teach", "a", "lesson", "to", "it", " ",
            "The", "next", "day", "he", "loaded", "a", "cotton", "bag", "on", "the", "donkey", " ",
            "Again", "it", "played", "the", "same", "trick", "hoping", "that", "the", "cotton", "bag", "would", "be", "still", "become", "lighter", " ",
            "But", "the", "dampened", "cotton", "became", "very", "heavy", "to", "carry", "and", "the", "donkey", "suffered", " ",
            "It", "learnt", "a", "lesson", " ",
            "It", "didn't", "play", "the", "trick", "anymore", "after", "that", "day", "and", "the", "seller", "was", "happy"
    };

    String[] donkey = {
            "A salt seller used to carry the salt bag on his donkey to the market every day.\n",
            "On the way they had to cross a stream.\n",
            "One day the donkey suddenly tumbled down the stream and the salt bag also fell into the water.\n",
            "The salt dissolved in the water and hence the bag became very light to carry.\n",
            "The donkey was happy.\n",
            "Then the donkey started to play the same trick every day.\n",
            "The salt seller came to understand the trick and decided to teach a lesson to it.\n",
            "The next day he loaded a cotton bag on the donkey.\n",
            "Again it played the same trick hoping that the cotton bag would be still become lighter.\n",
            "But the dampened cotton became very heavy to carry and the donkey suffered.\n",
            "It learnt a lesson.\n",
            "It didn’t play the trick anymore after that day, and the seller was happy."
    };

    String[] stopwords = {
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



    UtteranceProgressListener mProgressListener = new UtteranceProgressListener() {
        @Override
        public void onStart(String utteranceId) {

            // For Highlighting Spoken Words
            String Replace = "<span style= 'background-color:green'>" + utteranceId + "</span>";
            foolDonkeyWord.setText(Html.fromHtml(Replace));


            if (utteranceId.toLowerCase(Locale.getDefault()).equals("try") || utteranceId.toLowerCase(Locale.getDefault()).equals("catch") || utteranceId.toLowerCase(Locale.ROOT).equals("while")) {
                int gif_view = getResources().getIdentifier(utteranceId.toLowerCase(Locale.getDefault()) + "1", "raw", getPackageName());
                foolDonkeySignGifs.setImageResource(gif_view);
            }else if(utteranceId.toLowerCase(Locale.getDefault()).equals("play")|| utteranceId.toLowerCase(Locale.getDefault()).equals("played")){
                int gif_view = getResources().getIdentifier("fiddle", "raw", getPackageName());
                foolDonkeySignGifs.setImageResource(gif_view);
            } else {
                int gif_view = getResources().getIdentifier(utteranceId.toLowerCase(Locale.getDefault()), "raw", getPackageName());
                foolDonkeySignGifs.setImageResource(gif_view);
            }

        }

        @Override
        public void onDone(String utteranceId) {


            if (utteranceId.equals(" ")) {
                new Thread(){
                    @Override
                    public void run() {
                        j++;
                        foolDonkeySentence.setText(donkey[j]);
                    }
                }.start();
            }

            i = i + 1;
            speak(foolish, i);

        }

        @Override
        public void onError(String utteranceId) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_story);
        ButterKnife.bind(this);
        Foolish_Donkey.this.setTitle("Foolish Donkey");

        foolDonkeySentence.setText(donkey[0]);
        foolDonkeyWord.setText(foolish[0]);

        // Initialization of Text To Speech
        tts = new TextToSpeech(Foolish_Donkey.this, this);

        // Tracking of Words
        tts.setOnUtteranceProgressListener(mProgressListener);

        /* @OnClick Listener */
        foolDonkeyButtonSpeak.setOnClickListener(this);
        foolDonkeyButtonStop.setOnClickListener(this);

    }

    private void stop() {
        tts.stop();
        tts.shutdown();
        foolDonkeySentence.setText(donkey[0]);
        foolDonkeyWord.setText(foolish[0]);
        foolDonkeySignGifs.setVisibility(View.INVISIBLE);
    }

    private void speak(String[] text, int i) {
        tts.setSpeechRate(speed);
        tts.setPitch(pitch);
        HashMap<String, String> map = new HashMap<>();

        for (String stopword : stopwords) {
            if (foolish[i].toLowerCase(Locale.getDefault()).equals(stopword)) {
                char[] alphabet_array = stopword.toCharArray();

                for (char c : alphabet_array) {
                    map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, String.valueOf(c));
                    tts.setSpeechRate(0.5f);
                    tts.speak(String.valueOf(c), TextToSpeech.QUEUE_ADD, map);
                }

            }
        }


        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, foolish[i]);
        tts.speak(foolish[i], TextToSpeech.QUEUE_ADD, map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.speedmeter, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.Slow:
                speed = 0.4f;
                Toast.makeText(this, "Slow is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Normal:
                speed = 0.8f;
                Toast.makeText(this, "Normal is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Fast:
                speed = 1.2f;
                Toast.makeText(this, "Fast is selected", Toast.LENGTH_SHORT).show();
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
            case  R.id.fool_donkey_Button_speak:
                foolDonkeyButtonSpeak.setEnabled(false);
                speak(foolish,i);
                break;

            case  R.id.fool_donkey_button_stop:
                foolDonkeyButtonSpeak.setEnabled(true);
                stop();
                break;
        }
    }

}
