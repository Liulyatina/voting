package by.it_academy.jd2.first_web_app;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/stat")
public class StatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext servletContext = getServletContext();
        VotingServlet votingServlet = (VotingServlet) servletContext.getAttribute("votingServlet");

        out.println("<html><head><title>Статистика голосования</title></head><body>");
        out.println("<h1>Статистика голосования</h1>");

        out.println("<h2>Лучший артист</h2>");
        out.println(votingServlet.sortAndFormatVotes(votingServlet.bestArtistVotes));

        out.println("<h2>Популярные жанры</h2>");
        out.println(votingServlet.sortAndFormatVotes(votingServlet.bestGenreVotes));

        out.println("<h2>Информация о голосах</h2>");
        for (String vote : votingServlet.voteInfoVotes) {
            out.println("<p>" + vote + "</p>");
        }

        out.println("</body></html>");
    }
}

