package by.it_academy.jd2.first_web_app.dao;

import by.it_academy.jd2.first_web_app.dao.api.IVoteDao;

import java.util.List;
import java.util.Map;

public class VoteDao implements IVoteDao {
    @Override
    public void save(String artist, String[] genres, String about) {
    }

    @Override
    public Map<String, Integer> getArtist() {
        return null;
    }

    @Override
    public Map<String, Integer> getGenre() {
        return null;
    }

    @Override
    public List<String> getAbout() {
        return null;
    }
}
