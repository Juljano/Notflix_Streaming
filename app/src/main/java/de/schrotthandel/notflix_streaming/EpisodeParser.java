package de.schrotthandel.notflix_streaming;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class EpisodeParser {

    private String provider, titleOfEpisode, descriptionOfEpisode, urls, title;
    private boolean inGerman;

    private final EpisodeDetailsActivity episodeDetailsActivity;


    public EpisodeParser(EpisodeDetailsActivity episodeDetailsActivity) {

        this.episodeDetailsActivity = episodeDetailsActivity;

    }

    public void getEpisodeInformation(String URL) {

        Log.d("EpParser-Link", URL);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Log.d("EpParser-Episode", "Episode_Parser");

                    Document document = Jsoup.connect(URL).get();
                    Elements watchEpisodeElements = document.select("a.watchEpisode");

                    for (Element link : watchEpisodeElements) {
                        urls = link.attr("href");
                        provider = link.select("h4").text();
                        Log.d("EpParser-StreamName", provider);
                        Log.d("EpParser-Episode", "https://www.s.to" + urls);

                    }

                    descriptionOfEpisode = document.select("p.descriptionSpoiler").text();
                    titleOfEpisode = document.select("span.episodeGermanTitle").text();

                    String ingerman = document.select("img.selectedLanguage").attr("title");
                    title = document.select("h1[itemprop=name] span").text();


                    if (ingerman.contains("Deutsch")) {
                        inGerman = true;
                    }

                    Log.d("EpParser-description", descriptionOfEpisode);
                    Log.d("EpParser-title", titleOfEpisode);
                    Log.d("EpParser-inGerman", String.valueOf(inGerman));

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {

                            episodeDetailsActivity.updateUI(title,titleOfEpisode,descriptionOfEpisode, provider, inGerman);


                        }
                    });

                } catch (IOException e) {
                    Log.e("Parsing", e.toString());

                }
            }
        }).start();


    }



}
