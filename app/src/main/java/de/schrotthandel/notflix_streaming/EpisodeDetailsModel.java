package de.schrotthandel.notflix_streaming;

public class EpisodeDetailsModel {
    String NameOfEpisode;
    String descriptionOfEpisode;
    String Provider;
    boolean inGerman;


    public EpisodeDetailsModel(String nameOfEpisode, String descriptionOfEpisode, String provider, boolean inGerman) {
        NameOfEpisode = nameOfEpisode;
        this.descriptionOfEpisode = descriptionOfEpisode;
        Provider = provider;
        this.inGerman = inGerman;
    }

    public String getNameOfEpisode() {
        return NameOfEpisode;
    }

    public void setNameOfEpisode(String nameOfEpisode) {
        NameOfEpisode = nameOfEpisode;
    }

    public String getDescriptionOfEpisode() {
        return descriptionOfEpisode;
    }

    public void setDescriptionOfEpisode(String descriptionOfEpisode) {
        this.descriptionOfEpisode = descriptionOfEpisode;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String provider) {
        Provider = provider;
    }

    public boolean isInGerman() {
        return inGerman;
    }

    public void setInGerman(boolean inGerman) {
        this.inGerman = inGerman;
    }
}
