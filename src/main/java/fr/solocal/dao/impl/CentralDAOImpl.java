package fr.solocal.dao.impl;

import com.codahale.metrics.annotation.Timed;
import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.expression.spel.ast.Indexer;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.*;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

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


       /* //---- Resolutions ----
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
        users.add(u3);*/
        try {
            sendGetRequest("http://91.134.242.201/elastic-pjrace/pjrace_challenge/_search");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public Challenge getChallengeById(String idChallenge) {

        for(Challenge c : challenges){
            if(c.getIdChallenge().equals(idChallenge)){
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
        List<Etablissement> etabsByPos = new ArrayList<>();
        for(Etablissement e : etablissements){
            if(e.getLatitude() == latitude && e.getLongitude() == longitude){
                etabsByPos.add(e);
            }
        }
        return etabsByPos.iterator();
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

        parsingJson(response.toString());
    }

    /**
     * Permet d'instanciater des objets métiers des données json retournées par ES
     *
     * @param response
     *      Chaîne de caractères contenant la réponse d'une requête au moteur ES
     * @throws JSONException
     */
    public void parsingJson(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArray = new JSONArray(hits);

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject hit = jsonArray.getJSONObject(i);
            JSONObject source  = jsonArray.getJSONObject(i).getJSONObject("_source");

            //Attributs Challenge
            String challengeId = hit.getString("_id");
            int points = source.getInt("points");

            //Attributs Etablissement
            String etabAdresse = source.getString("adresse");
            int codeEtab = source.getInt("code_etab");
            String denom = source.getString("denom");
            double latitude = source.getJSONObject("_geo").getDouble("lat");
            double longitude = source.getJSONObject("_geo").getDouble("lon");

            //Attributs ChallengeType
            String codeType = source.getString("code");

            //Instanciation des objets
            Etablissement etab = new Etablissement(codeEtab, denom, etabAdresse, latitude, longitude );
            etablissements.add(etab);

            ChallengeType challengeType = new ChallengeType(1, codeType, 100, "blabla");
            challengeTypes.add(challengeType);

            Challenge challenge = new Challenge(challengeId, etab, challengeType, points);
            challenges.add(challenge);
        }
    }

    /**
     * Retourne la map correspondant à la structure du document user lors de la première connexion
     *
     * @param userId
     * @param userGroupe
     * @return
     */
    public Map<String, Object> initialUserJsonDocument(String userId, String userGroupe){
        Map<String, Object> jsonDocument = new HashMap<String, Object>();

        jsonDocument.put("userId", userId);
        jsonDocument.put("userGroupe", userGroupe);
        jsonDocument.put("nbPoints", 0);
        jsonDocument.put("challenges", null);

        return jsonDocument;
    }

    /**
     * Requête POST pour créer un utilisateur
     * @param u
     *      Un objet User, qui permet d'initialiser un utilisateur dans ES lors de sa première connexion
     * @throws Exception
     */
    /*public void initializeUser(User pUser) throws Exception {
        ArrayList<String> lstTemp = new ArrayList<>();
        coll.add("test");
        coll.add("test2");

        String url="http://91.134.242.201/elastic-pjrace/pjrace_challenge/user/"+u.getEmail();
        URL object=new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");

        JSONObject jsonUser  = new JSONObject();
        jsonUser.put("lastname",u.getLastname());
        jsonUser.put("firstname", u.getFirstname());
        jsonUser.put("email", u.getEmail());
        jsonUser.put("challenges", coll);
        jsonUser.put("score", 0);

        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(jsonUser.toString());
        wr.flush();

        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }
    }*/

    public void updateUser(User u) throws Exception {
        String url="http://91.134.242.201/elastic-pjrace/pjrace_challenge/user/"+u.getEmail()+"/_update";
        URL object=new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");

        JSONObject jsonUser = new JSONObject();


        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(jsonUser.toString());
        wr.flush();

        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }
    }

    public void testGet() throws UnknownHostException {
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("client.transport.ignore_cluster_name", true)
                .put("client.transport.sniff", false)
                .build();
        TransportClient client = new TransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress("91.134.242.201", 9300));

        try{
            SearchResponse response = client.prepareSearch().execute().actionGet();
            String output = response.toString();
            System.out.println(output);
        }catch(Exception e){
            e.printStackTrace();
        }
        client.close();

    }

    /**
     * Renvoie le fichier JSON permettant d'update la liste des challenges et le score d'un utilisateur
     *
     * @param u
     *      L'utilisateur à update
     *
     * @return un objet JSONObject contenant les informations pour update l'utilisateur
     *
     * @throws JSONException
     */
    /*public JSONObject updateChallengesUser(User u) throws JSONException {
        JSONObject jsonUpdate2 = new JSONObject();
        jsonUpdate2.put("challenges","chall3");

        JSONObject jsonUpdate1 = new JSONObject();
        jsonUpdate1.put("inline", "ctx._source.score +="+u.getTotalScore()+";ctx._source.challenges.add(params.challenges)");
        jsonUpdate1.put("params", jsonUpdate2);

        JSONObject jsonUpdate = new JSONObject();
        jsonUpdate.put("script", jsonUpdate1);

        return jsonUpdate;
    }*/
}
