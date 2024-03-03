package by.it_academy.jd2.first_web_app.service.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllStatDtoBuilder {
    private StatDto artistStat;
    private StatDto genreStat;
    private List<String> abouts = new ArrayList<>();

    private AllStatDtoBuilder() {
    }

    public static AllStatDtoBuilder builder(){
        return new AllStatDtoBuilder();
    }

    public AllStatDtoBuilder setArtistStat(StatDto artistStat) {
        this.artistStat = artistStat;
        return this;
    }

    public AllStatDtoBuilder setArtistStat(List<Map.Entry<String, Integer>> score) {
        this.artistStat = new StatDto(score);
        return this;
    }

    public AllStatDtoBuilder setGenreStat(StatDto genreStat) {
        this.genreStat = genreStat;
        return this;
    }

    public AllStatDtoBuilder setGenreStat(List<Map.Entry<String, Integer>> score) {
        this.genreStat = new StatDto(score);
        return this;
    }

    public AllStatDtoBuilder setAbouts(List<String> abouts) {
        this.abouts = abouts;
        return this;
    }

    public AllStatDtoBuilder addAbouts(String about) {
        this.abouts.add(about);
        return this;
    }

    public AllStatDto build(){
        return new AllStatDto(artistStat, genreStat, abouts);
    }
}
