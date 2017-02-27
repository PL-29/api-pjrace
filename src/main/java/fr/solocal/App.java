package fr.solocal;

import fr.solocal.dao.CentralDAO;
import fr.solocal.dao.impl.CentralDAOImpl;
import fr.solocal.utils.ImageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fchantrel
 *
 */
@ComponentScan
@EnableAutoConfiguration(exclude = { MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class })
@EnableCaching
public class App {

    /**
     * Fonction principale qui démarre l'appli
     *
     * @param args Arguments given on launch
     * @throws Exception If something bad happens
     */
    public static void main(final String[] args) throws Exception {
        //SpringApplication.run(App.class, args);
        System.out.println("PJRace API is successfully started!");
        CentralDAOImpl dao = new CentralDAOImpl();
        dao.sendGetRequest("http://91.134.242.201/elastic-pjrace/pjrace_challenge/_search");
    }
}
