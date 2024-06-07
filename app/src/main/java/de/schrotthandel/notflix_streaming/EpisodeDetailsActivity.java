package de.schrotthandel.notflix_streaming;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class EpisodeDetailsActivity extends AppCompatActivity {

    private String getEpisodeURL;
    private String HOSTNAME = "https://s.to";

    private TextView textViewTitle,textViewEpisode,textViewDescription,inGermTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_episode_details);

         textViewTitle = findViewById(R.id.textViewTitle);
         textViewEpisode = findViewById(R.id.textViewEpisode);
         textViewDescription = findViewById(R.id.textViewDescription);
         inGermTextview = findViewById(R.id.textviewInGerman);


        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarEpisodeDetails);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }


    @Override
    protected void onStart() {

        super.onStart();

        EpisodeParser episodeParser = new EpisodeParser(EpisodeDetailsActivity.this);
        episodeParser.getEpisodeInformation(setEpisodeInfo());
    }

    private String setEpisodeInfo() {
        String info = null;
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            info = bundle.getString("Episode-URL");
            Log.d("EpisodeDetails", HOSTNAME + info);
            return HOSTNAME + info;
        }

        return null;
    }

    public void updateUI(String title,String titleOfEpisode, String descriptionOfEpisode, String provider, boolean inGerman) {

        textViewTitle.setText(title);
        textViewEpisode.setText(titleOfEpisode);
        textViewDescription.setText(shortenTextinTextview(descriptionOfEpisode));
        if (inGerman){

            inGermTextview.setText("In deutsch verfügbar");
        }


        Toast.makeText(getApplicationContext(), provider, Toast.LENGTH_LONG).show();

    }


    private String shortenTextinTextview(String descriptionOfEpisode){
        if (descriptionOfEpisode.length() > 484){
           return descriptionOfEpisode.substring(0,484) + "....";
        }
        return descriptionOfEpisode;
    }
}
