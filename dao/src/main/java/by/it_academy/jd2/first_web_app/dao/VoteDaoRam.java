package by.it_academy.jd2.first_web_app.dao;

import by.it_academy.jd2.first_web_app.dao.api.IVoteDao;

import java.util.*;

public class VoteDaoRam implements IVoteDao {

    private final Map<String, Integer> artistsScore;
    private final Map<String, Integer> genresScore;
    private final List<String> aboutList;

    public VoteDaoRam() {
        artistsScore = new HashMap<>();
        genresScore = new HashMap<>();
        aboutList = new ArrayList<>();
    }
    public VoteDaoRam(Map<String, Integer> artistsScore, Map<String, Integer> genresScore, List<String> aboutList) {
        this.artistsScore = artistsScore;
        this.genresScore = genresScore;
        this.aboutList = aboutList;
    }

    @Override
    public synchronized void save(String artist, String[] genres, String about) {
        this.artistsScore.compute(artist, (k, v) -> v != null ? v + 1 : 1);

        for (String genre : genres) {
            this.genresScore.compute(genre, (k, v) -> v != null ? v + 1 : 1);
        }

        this.aboutList.add(about);
    }

    @Override
    public Map<String, Integer> getArtist() {
        return Collections.unmodifiableMap(this.artistsScore);
    }

    @Override
    public Map<String, Integer> getGenre() {
        return Collections.unmodifiableMap(this.genresScore);
    }

    @Override
    public List<String> getAbout() {
        return Collections.unmodifiableList(this.aboutList);
    }
}