package by.it_academy.jd2;

import by.it_academy.jd2.first_web_app.service.StatService;
import by.it_academy.jd2.first_web_app.service.api.IStatService;
import by.it_academy.jd2.first_web_app.service.api.IVoteService;
import by.it_academy.jd2.first_web_app.service.api.dto.AllStatDto;
import by.it_academy.jd2.first_web_app.service.factory.ServiceFactorySingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatServiceTest {
    @Test
    public void test() {
        IStatService statService = ServiceFactorySingleton.getStatService();

        AllStatDto allStatDto = statService.get();

        int maxScore = -1;
        for (Map.Entry<String, Integer> entry : allStatDto.getArtistStat().getScore()) {
            if (maxScore == -1) {
                maxScore = entry.getValue();
            } else {
                if (maxScore >= entry.getValue()) {
                    maxScore = entry.getValue();
                } else {
                    Assertions.fail("Статистика вернулась не в правильном порядке");
                }
            }
        }
    }

    public static class TestVoteService implements IVoteService {
        @Override
        public void save(String artist, String[] genres, String about) {

        }

        @Override
        public Map<String, Integer> getArtist() {
            return new HashMap<>() {{
                put("Скриптонит", 1);
                put("ЛСП", 3);
                put("Тима Белорусских", 5);
                put("Макс Корж", 2);
            }};
        }

        @Override
        public Map<String, Integer> getGenre() {
            return new HashMap<>() {{
                put("поп", 1);
                put("рок", 3);
                put("кейпоп", 5);
                put("техно", 2);
            }};
        }

        @Override
        public List<String> getAbout() {
            return Arrays.asList("test1", "test2", "test3");
        }
    }
}
