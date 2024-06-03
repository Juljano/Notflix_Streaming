package de.schrotthandel.notflix_streaming;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {

    private static final String HostName = "https://s.to";
    private Context context;

    private final List<SeriesModel> seriesModelList = new ArrayList<>();

    private MainActivity mainActivity;

    private String title ,links;

    public Parsing(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public void getSeriesInformation(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(url).get();

                    String imgPath = HostName + document.select("div.seriesCoverBox > img").attr("data-src");
                    String description = document.select("p.seri_des").first().attr("data-full-description");

                    int numberofSeasons = Integer.parseInt(document.select("meta[itemprop=numberOfSeasons]").first().attr("content"));

                    Log.d("Parsing-numberofSeasons", String.valueOf(numberofSeasons));
                    String currentSeasons = String.valueOf(Integer.parseInt(document.select("meta[itemprop=seasonNumber]").first().attr("content")));

                    Log.d("current-numberofSeasons", String.valueOf(numberofSeasons));



                    //Show all Episodes of the series
                    Elements rows = document.select("tbody#season" + currentSeasons + " tr");

                    for (Element row : rows) {
                        title = row.select("td.seasonEpisodeTitle").first().text();
                        links = row.select("a").first().attr("href");

                        Log.d("Parsing-allEpisode", title);
                        Log.d("Parsing-titleElement", links);


                        seriesModelList.add(new SeriesModel(title, description, imgPath, numberofSeasons, links, currentSeasons));

                    }

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Daten erfolgreich abgerufen", Toast.LENGTH_SHORT).show();


                            EpisodeListFragment episodeListFragment = new EpisodeListFragment();
                            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.main, episodeListFragment);
                            fragmentTransaction.addToBackStack(null);
                            episodeListFragment.updateRecyclerView(seriesModelList);
                            fragmentTransaction.commit();

                        }
                    });

                } catch (IOException e) {
                    Log.e("Parsing", e.toString());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Fehler beim Abrufen der Daten", Toast.LENGTH_SHORT).show();

                        }
                    });


                }
            }
        }).start();
    }
}
