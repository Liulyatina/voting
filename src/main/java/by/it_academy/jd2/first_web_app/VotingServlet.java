package by.it_academy.jd2.first_web_app;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/vote")
public class VotingServlet extends HttpServlet {

    private final static String ARTIST_PARAM_NAME = "best_artist";
    private final static String GENRE_PARAM_NAME = "favorite_genres";
    private final static String ABOUT_PARAM_NAME = "about_me";
    private final Map<String, Integer> bestArtistVotes = new HashMap<>();
    private final Map<String, Integer> bestGenreVotes = new HashMap<>();
    private final List<String> voteInfoVotes = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String bestArtist = request.getParameter(ARTIST_PARAM_NAME);
        String[] bestGenres = request.getParameterValues(GENRE_PARAM_NAME);
        String aboutMe = request.getParameter(ABOUT_PARAM_NAME);

        // Обновление счётчика лучшего артиста
        bestArtistVotes.put(bestArtist, bestArtistVotes.getOrDefault(bestArtist, 0) + 1);

        // Обновление счётчика лучших жанров
        if (bestGenres != null) {
            for (String genre : bestGenres) {
                bestGenreVotes.put(genre, bestGenreVotes.getOrDefault(genre, 0) + 1);
            }
        }

        if (bestGenres == null || bestGenres.length < 3 || bestGenres.length > 5) {
            response.sendRedirect("/first_web_app-1.0-SNAPSHOT/learn.html"); // Добавляем перенаправление на страницу /learn.html
            return;
        }

        String voteInfo = "Лучший исполнитель))))))))))): " + bestArtist + " , Жанры: " + String.join(",", bestGenres) + ", О вас: " + aboutMe;
        voteInfoVotes.add(voteInfo);

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head><title>Результаты голосования</title></head><body>");
        printWriter.println("<h1>Результаты голосования</h1>");

        printWriter.println("<h2>Лучший артист</h2>");
        bestArtistVotes.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> printWriter.println("<p>" + e.getKey() + " : " + e.getValue() + " голосов </p>"));

        printWriter.println("<h2>Популярные жанры</h2>");
        bestGenreVotes.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> printWriter.println("<p>" + e.getKey() + " : " + e.getValue() + "</p>"));

        printWriter.println("<h2>Информация о голосах</h2>");
        for(String vote : voteInfoVotes){
            printWriter.println("<p>" + vote + "</p>");
        }
        printWriter.println("</body></html>");
    }
}
