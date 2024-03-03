package by.it_academy.jd2.first_web_app.dao;

import by.it_academy.jd2.first_web_app.dao.api.IVoteDao;

import java.util.*;

public class VoteDaoRam implements IVoteDao {

    private Map<String, Integer> artistsScore = new HashMap<>();
    private Map<String, Integer> genresScore = new HashMap<>();
    private List<String> aboutList = new ArrayList<>();

    public VoteDaoRam() {
        artistsScore = new HashMap<>();
        genresScore = new HashMap<>();
        aboutList = new ArrayList<>();
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