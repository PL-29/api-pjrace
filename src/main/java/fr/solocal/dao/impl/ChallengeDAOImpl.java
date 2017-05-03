package fr.solocal.dao.impl;

import fr.solocal.dao.ChallengeDAO;
import fr.solocal.domain.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
@Repository("challengeDAO")
public class ChallengeDAOImpl extends Requester implements ChallengeDAO {
    private static final String SERVER_ADDRESS  = "http://91.134.242.201";

    public ChallengeDAOImpl(){
        super();
    }

    @Override
    public Challenge getChallengeById(String pIdChallenge) throws Exception{
        String url = SERVER_ADDRESS+"/pjrace_challenge/etab/_search?q=challenges.id:\""+pIdChallenge+"\"";
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);

        return challengeByIdFromJson(jsonResponse, pIdChallenge);
    }

    @Override
    public List<Challenge> getChallengesByCodeEtab(int pCodeEtab) throws Exception{
        String url = SERVER_ADDRESS+"/pjrace_challenge/_search?q=code_etab:"+pCodeEtab;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);
        return challengesByCodeEtabFromJson(jsonResponse);
    }

    @Override
    public List<ChallengeType> getAllChallengeTypes() throws Exception {
        return ChallengeTypeFactory.makeChallengeTypeList();
    }

    public Challenge challengeByIdFromJson(String pJsonString, String pIdChallenge) throws JSONException {
        Challenge challenge = new Challenge();

        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArrayHits = new JSONArray(hits);

        for (int i = 0; i < jsonArrayHits.length(); i++) {
            JSONObject source = jsonArrayHits.getJSONObject(i).getJSONObject("_source");

            JSONArray jsonArrayChallenges = source.getJSONArray("challenges");
            int y = 0;
            while (y < jsonArrayChallenges.length() && !jsonArrayChallenges.getJSONObject(y).getString("id").equals(pIdChallenge)) {
                y++;
            }

            if (jsonArrayChallenges.getJSONObject(y).getString("id").equals(pIdChallenge)) {
                //Attributs Challenge
                String challengeId = jsonArrayChallenges.getJSONObject(y).getString("id");
                int points = jsonArrayChallenges.getJSONObject(y).getInt("points");
                String dateCreated = source.getString("update").substring(0, 10);


                //Attributs ChallengeType
                String codeType = jsonArrayChallenges.getJSONObject(i).getString("code");

                //Attributs Etablissement
                String etabAdresse = source.getString("adresse");
                int codeEtab = source.getInt("code_etab");
                String denom = source.getString("denom");
                double latitude = source.getJSONObject("location").getDouble("lat");
                double longitude = source.getJSONObject("location").getDouble("lon");

                Etablissement etablissement = new Etablissement(codeEtab, denom, etabAdresse, latitude, longitude);

                challenge.setIdChallenge(challengeId);
                challenge.setEtablissement(etablissement);
                challenge.setType(ChallengeTypeFactory.makeChallengeType(codeType));
                challenge.setPoints(points);
                challenge.setDateCreated(dateCreated);
            }
        }

        return challenge;
    }

    public List<Challenge> challengesByCodeEtabFromJson(String pJsonString) throws JSONException {
        List<Challenge> lstChallenges = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArrayHits = new JSONArray(hits);

        for (int i = 0; i < jsonArrayHits.length(); i++) {
            JSONObject source = jsonArrayHits.getJSONObject(i).getJSONObject("_source");

            //Attributs Etablissement
            String etabAdresse = source.getString("adresse");
            int codeEtab = source.getInt("code_etab");
            String denom = source.getString("denom");
            double latitude = source.getJSONObject("location").getDouble("lat");
            double longitude = source.getJSONObject("location").getDouble("lon");

            Etablissement etablissement = new Etablissement(codeEtab, denom, etabAdresse, latitude, longitude);

            JSONArray jsonArrayChallenge = source.getJSONArray("challenges");
            for (int y = 0; y < jsonArrayChallenge.length(); y++) {
                JSONObject jsonChallenge = jsonArrayChallenge.getJSONObject(y);

                //Attributs Challenge
                String challengeId = jsonChallenge.getString("id");
                int points = jsonChallenge.getInt("points");
                String dateCreated = source.getString("creation_date").substring(0, 10);

                //Attributs ChallengeType
                String codeType = jsonChallenge.getString("code");

                Challenge challenge = new Challenge();
                challenge.setIdChallenge(challengeId);
                challenge.setEtablissement(etablissement);
                challenge.setType(ChallengeTypeFactory.makeChallengeType(codeType));
                challenge.setPoints(points);
                challenge.setDateCreated(dateCreated);
                lstChallenges.add(challenge);
            }
        }

        return lstChallenges;
    }
}
