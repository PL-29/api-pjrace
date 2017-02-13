package fr.solocal.dao.impl;

import com.codahale.metrics.annotation.Timed;
import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.*;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.http.client.HttpClient;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by stage01 on 10/02/17.
 */
@Repository("centralDAO")
public class CentralDAOImpl implements CentralDAO{
    private List<ChallengeType> challengeTypes = new ArrayList<ChallengeType>();
    private List<Challenge> challenges = new ArrayList<Challenge>();
    private List<Facility> facilities = new ArrayList<Facility>();
    private List<User> users = new ArrayList<>();
    private List<Achievement> achievements = new ArrayList<>();

    public CentralDAOImpl() {
        //---- ChallengeType : PHOTO ----
        ChallengeType type = new ChallengeType();
        type.setIdChallengeType(1);
        type.setDescription("Prenez une photo de la devanture de l'établissement");
        type.setDefaultNumberPoints(100);
        type.setTitle("Photo");
        challengeTypes.add(type);


        //---- Etablissements ----
        Facility etab1 = new Facility();
        etab1.setCodeEtab(1205);
        etab1.setAddress("1 rue de la République, 35000 Rennes");
        etab1.setDenomination("Bar des sports");

        Facility etab2 = new Facility();
        etab2.setCodeEtab(1326);
        etab2.setAddress("6 rue de la Liberté, 35000 Rennes");
        etab2.setDenomination("Gaumont");

        facilities.add(etab1);
        facilities.add(etab2);


        //---- Challenges ----
        Challenge c1 = new Challenge();
        c1.setIdChallenge(1);
        c1.setFacility(etab1);
        c1.setType(type);
        c1.setPoints(100);

        Challenge c2 = new Challenge();
        c2.setIdChallenge(2);
        c2.setFacility(etab1);
        c2.setType(type);
        c2.setPoints(200);

        Challenge c3 = new Challenge();
        c3.setIdChallenge(3);
        c3.setFacility(etab2);
        c3.setType(type);
        c3.setPoints(300);

        challenges.add(c1);
        challenges.add(c2);
        challenges.add(c3);

        //---- Resolutions ----
        Achievement r1 = new Achievement(1, c1,"xxx.png");
        Achievement r2 = new Achievement(2, c2, "yyyy.png");
        Achievement r3 = new Achievement(3, c3,"zzz.png");
        Achievement r4 = new Achievement(1, c2, "aaaa.png");
        Achievement r5 = new Achievement(1, c3, "bbb.png");

        //---- Users ----
        User u1 = new User();
        u1.setIdUser(1);
        u1.setEmail("blabla@gmail.com");
        u1.setLastname("Toto");
        u1.setPassword("xxxx");
        u1.setFirstname("Tata");
        u1.getAchievements().add(r1);
        u1.getAchievements().add(r2);
        u1.getAchievements().add(r3);

        User u2 = new User();
        u2.setIdUser(2);
        u2.setEmail("blablablibli@gmail.com");
        u2.setLastname("yqrmkljghio");
        u2.setPassword("xxxx");
        u2.setFirstname("qklhqh");
        u2.getAchievements().add(r4);

        User u3 = new User();
        u3.setIdUser(3);
        u3.setEmail("blablabloblo@gmail.com");
        u3.setLastname("Titi");
        u3.setPassword("xxxx");
        u3.setFirstname("Tutu");
        u3.getAchievements().add(r5);

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    @Override
    @Timed(absolute = true, name = "challenge_types")
    public Iterator<ChallengeType> getAllChallengeTypes(){
        return challengeTypes.iterator();
    }

    @Override
    @Timed(absolute = true, name = "challenges")
    public Iterator<Challenge> getAllChallenges() {
        return challenges.iterator();
    }

    @Override
    @Timed(absolute = true, name = "challenge_id")
    public Challenge getChallengeById(int idChallenge) {

        for(Challenge c : challenges){
            if(c.getIdChallenge() == idChallenge){
                return c;
            }
        }

        return null;
    }

    @Override
    @Timed(absolute = true, name = "challenge_codeEtab")
    public Iterator<Challenge> getChallengeByCodeEtab(int codeEtab) {
        List<Challenge> challengesEtablissement = new ArrayList<>();

        for(Challenge c : challenges){
            if(c.getFacility().getCodeEtab() == codeEtab){
                challengesEtablissement.add(c);
            }
        }

        return challengesEtablissement.iterator();
    }

    @Override
    @Timed(absolute = true, name = "facilities")
    public Iterator<Facility> getAllEtablissements() {
        return facilities.iterator();
    }

    @Override
    @Timed(absolute = true, name = "ranking")
    public Iterator<User> getRanking() {
        List<User> listRanking = new ArrayList<>();
        int i = 1;
        for(User u : users){
            u.setRank(i);
            i++;
            listRanking.add(u);
        }

        return listRanking.iterator();
    }

    @Override
    @Timed(absolute = true, name = "achievements")
    public Iterator<Achievement> getAllAchievements(int idUser) {
        for(User u : users){
            if(u.getIdUser() == idUser){
                return u.getAchievements().iterator();
            }
        }

        return null;
    }

    @Override
    public User connexion(String email, String password) {

        for(User u : users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    @Override
    public void achieveChallenge(int idChallenge, int idUser, String photo) {

    }

    /**
     * Permet d'envoyer une requête GET à l'URL spécifiée en paramètre
     *
     * @param url
     *
     * @throws Exception
     */
    public void sendGetRequest(String url) throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }


}
