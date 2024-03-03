package by.it_academy.jd2.first_web_app.service;

import by.it_academy.jd2.first_web_app.service.api.IStatService;
import by.it_academy.jd2.first_web_app.service.api.IVoteService;
import by.it_academy.jd2.first_web_app.service.api.dto.AllStatDto;
import by.it_academy.jd2.first_web_app.service.api.dto.AllStatDtoBuilder;
import by.it_academy.jd2.first_web_app.service.api.dto.StatDto;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatService implements IStatService {

    private final IVoteService voteService;

    public StatService(IVoteService voteService) {
        this.voteService = voteService;
    }

    @Override
    public AllStatDto get() {

        return AllStatDtoBuilder.builder()
                .setArtistStat(getArtistStat())
                .setGenreStat(getGenreStat())
                .setAbouts(voteService.getAbout())
                .build();
    }

    @Override
    public StatDto getArtistStat() {
        return new StatDto(getTopWithScore(voteService.getArtist()));
    }

    @Override
    public long getByArtist(String artist) {
        return voteService.getArtist().getOrDefault(artist, 0);
    }

    @Override
    public StatDto getGenreStat() {
        return new StatDto(getTopWithScore(voteService.getGenre()));
    }

    @Override
    public long getByGenre(String genre) {
        return voteService.getGenre().getOrDefault(genre, 0);
    }


    private List<String> getTop(Map<String, Integer> data) {
        return data.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Map.Entry<String, Integer>> getTopWithScore(Map<String, Integer> data) {
        if (data == null) {
            return null;
        }
        return data.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());
    }
}