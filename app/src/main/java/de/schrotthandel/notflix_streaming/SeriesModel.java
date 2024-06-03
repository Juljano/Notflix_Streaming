package de.schrotthandel.notflix_streaming;

public class SeriesModel {
    private String title;
    private String description;
    private String imgCover;
    private int NumberofSeasons;
    private String currentSeason;
    private String allEpisodes;


    public SeriesModel(String title, String description, String imgCover, int NumberofSeasons, String allEpisodes, String currentSeason) {
        this.title = title;
        this.description = description;
        this.imgCover = imgCover;
        this.NumberofSeasons = NumberofSeasons;
        this.currentSeason = currentSeason;
        this.allEpisodes = allEpisodes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgCover() {
        return imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }

    public int getNumberofSeasons() {
        return NumberofSeasons;
    }

    public void setNumberofSeasons(int numberofSeasons) {
        this.NumberofSeasons = numberofSeasons;
    }


    public String getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(String currentSeason) {
        this.currentSeason = currentSeason;
    }

    public String getAllEpisodes() {
        return allEpisodes;
    }

    public void setAllEpisodes(String allEpisodes) {
        this.allEpisodes = allEpisodes;
    }
}
