package by.it_academy.jd2.first_web_app.dao.factory;

import by.it_academy.jd2.first_web_app.dao.VoteDaoRam;
import by.it_academy.jd2.first_web_app.dao.api.IVoteDao;


public class DaoFactory {
    private volatile static IVoteDao voteDao;

    public static IVoteDao getVoteDao() {
        if (voteDao == null) {
            synchronized (DaoFactory.class) {
                if (voteDao == null) {
                    voteDao = new VoteDaoRam();
                }
            }
        }
        return voteDao;
    }
}
