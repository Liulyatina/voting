package by.it_academy.jd2.first_web_app.service.api;

import by.it_academy.jd2.first_web_app.service.api.dto.AllStatDto;
import by.it_academy.jd2.first_web_app.service.api.dto.StatDto;

public interface IStatService {

    AllStatDto get();

    StatDto getArtistStat();

    long getByArtist(String artist);

    StatDto getGenreStat();

    long getByGenre(String genre);

}