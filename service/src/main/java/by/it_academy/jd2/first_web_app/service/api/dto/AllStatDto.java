package by.it_academy.jd2.first_web_app.service.api.dto;

import java.util.List;
public class AllStatDto {
    private final StatDto artistStat;
    private final StatDto genreStat;
    private final List<String> abouts;

    public AllStatDto(StatDto artistStat, StatDto genreStat, List<String> abouts) {
        this.artistStat = artistStat;
        this.genreStat = genreStat;
        this.abouts = abouts;
    }

    public StatDto getArtistStat() {
        return artistStat;
    }

    public StatDto getGenreStat() {
        return genreStat;
    }

    public List<String> getAbouts() {
        return abouts;
    }
}