package by.it_academy.jd2.first_web_app.service.factory;

import by.it_academy.jd2.first_web_app.dao.factory.DaoFactory;
import by.it_academy.jd2.first_web_app.service.StatService;
import by.it_academy.jd2.first_web_app.service.VoteService;
import by.it_academy.jd2.first_web_app.service.api.IStatService;
import by.it_academy.jd2.first_web_app.service.api.IVoteService;

public class ServiceFactorySingleton {
    private static volatile IStatService statService;
    private static volatile IVoteService voteService;


    public static IStatService getStatService() {
        if (statService == null) {
            synchronized (ServiceFactorySingleton.class) {
                if (statService == null) {
                    statService = new StatService(getVoteService());
                }
            }
        }
        return statService;
    }

    public static IVoteService getVoteService() {
        if (voteService == null) {
            synchronized (ServiceFactorySingleton.class) {
                if (voteService == null) {
                    voteService = new VoteService(DaoFactory.getVoteDao());
                }
            }
        }
        return voteService;
    }
}
