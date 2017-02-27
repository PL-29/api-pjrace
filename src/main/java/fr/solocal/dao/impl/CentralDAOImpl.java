package fr.solocal.dao.impl;

import com.codahale.metrics.annotation.Timed;
import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
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
    private List<Etablissement> etablissements = new ArrayList<Etablissement>();
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
        Etablissement etab1 = new Etablissement();
        etab1.setCodeEtab(1205);
        etab1.setAddress("1 rue de la République, 35000 Rennes");
        etab1.setDenomination("Bar des sports");

        Etablissement etab2 = new Etablissement();
        etab2.setCodeEtab(1326);
        etab2.setAddress("6 rue de la Liberté, 35000 Rennes");
        etab2.setDenomination("Gaumont");

        etablissements.add(etab1);
        etablissements.add(etab2);


        //---- Challenges ----
        Challenge c1 = new Challenge();
        c1.setIdChallenge(1);
        c1.setEtablissement(etab1);
        c1.setType(type);
        c1.setPoints(100);

        Challenge c2 = new Challenge();
        c2.setIdChallenge(2);
        c2.setEtablissement(etab1);
        c2.setType(type);
        c2.setPoints(200);

        Challenge c3 = new Challenge();
        c3.setIdChallenge(3);
        c3.setEtablissement(etab2);
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

    /**
     * Renvoie la liste des types de challenges
     *
     * @return Un objet Iterator sur la liste des types de challenges
     */
    @Override
    @Timed(absolute = true, name = "challenge_types")
    public Iterator<ChallengeType> getAllChallengeTypes(){
        return challengeTypes.iterator();
    }


    /**
     * Renvoie la liste des challenges
     *
     * @return Un objet Iterator sur la liste des challenges
     */
    @Override
    @Timed(absolute = true, name = "challenges")
    public Iterator<Challenge> getAllChallenges() {
        return challenges.iterator();
    }


    /**
     * Renvoie un challenge en fonction de son id
     *
     * @return Un objet Challenge
     */
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

    /**
     * Renvoie la liste des challenges d'un établissement en fonction du code etab
     *
     * @return Un objet Iterator sur la liste des challenges d'un établissement
     */
    @Override
    @Timed(absolute = true, name = "challenge_codeEtab")
    public Iterator<Challenge> getChallengesByCodeEtab(int codeEtab) {
        List<Challenge> challengesEtablissement = new ArrayList<>();

        for(Challenge c : challenges){
            if(c.getEtablissement().getCodeEtab() == codeEtab){
                challengesEtablissement.add(c);
            }
        }

        return challengesEtablissement.iterator();
    }

    /**
     * Renvoie la liste des établissements en fonction de la position de l'utilisateur
     *
     * @param latitude
     *      La latitude de l'utilisateur
     * @param longitude
     *      La longitude de l'utilisateur
     *
     * @return un objet Iterator sur une liste d'établissements
     */
    @Override
    @Timed(absolute = true, name = "etablissements_position")
    public Iterator<Etablissement> getEtablissementsByPosition(double latitude, double longitude) {
        //Récupérer les etablissements dans un périmètre défini et calculé par une fonction
        //Retourner les établissements du périmètres
        return etablissements.iterator();
    }

    /**
     * Renvoie le classement des 10 premiers utilisateurs et de l'utilisateur lui même
     *
     * @return un objet Iterator sur une liste d'utilisateurs
     */
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

    /**
     * Permet d'avoir la liste des challenges resolus par un utilisateur
     *
     * @param idUser
     *      L'id de l'utilisateur
     *
     * @return Un objet Iterator sur une liste de challenges
     */
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

    /**
     * Permet la connexion de l'utilisateur à l'application
     *
     * @param email
     *      email de l'utilisateur
     * @param password
     *      password de l'utilisateur
     *
     * @return un objet User
     */
    @Override
    public User connexion(String email, String password) {

        for(User u : users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    /**
     * Enregistre la résolution d'un challenge dans ES
     *
     * @param idChallenge
     *     L'id du challenge résolu
     * @param idUser
     *      L'id de l'utilisateur qui le résoud
     * @param photo
     *      La photo encodée en base 64
     */
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
        //System.out.println(response.toString());
        stringToJsonToObject(response.toString());
    }


    public void stringToJsonToObject(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        String inter = jsonObject.getString("hits");
        JSONObject jsonObject1 = new JSONObject(inter);
        String inter1 = jsonObject1.getString("hits");
        JSONArray jsonArray = new JSONArray(inter1);

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObj  = jsonArray.getJSONObject(i);
            //System.out.println(jsonArray.getString(i));
            System.out.println("code : "+jsonObj.getString("_source"));
            //System.out.println("adresse : "+jsonObj.getString("adresse"));*/
        }
    }
}
