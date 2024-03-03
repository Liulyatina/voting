package by.it_academy.jd2.first_web_app.dao.api;

import java.util.List;
import java.util.Map;

public interface IVoteDao {
    void save(String artist, String[] genres, String about);

    Map<String, Integer> getArtist();

    Map<String, Integer> getGenre();

    List<String> getAbout();
}