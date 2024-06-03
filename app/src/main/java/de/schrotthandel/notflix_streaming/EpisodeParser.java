package de.schrotthandel.notflix_streaming;

import android.util.Log;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EpisodeParser {

    private String provider, titleOfEpisode , descriptionOfEpisode;
    private boolean inGerman;

    public void getEpisodeInformation(){

        //    String spoiler_description = document.select("p.descriptionSpoiler").first().attr("description");


      /*  Elements watchEpisodeElements = document.select("a.watchEpisode");

        for (Element link : watchEpisodeElements) {
            String getUrls = link.attr("href");
            String streamingProvider = link.attr("h4");

            watchEpisodeLinks = getUrls;

            Log.d("Parsing-watchEpisode", "https://www.s.to" + watchEpisodeLinks);
            Log.d("Parsing-StreamName", "https://www.s.to" + streamingProvider);
        }*/



    }
}
