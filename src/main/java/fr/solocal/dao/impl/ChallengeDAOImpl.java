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

    public ChallengeDAOImpl(){
        super();
    }

    @Override
    public Challenge getChallengeById(String pIdChallenge) throws Exception{
        String serverAddress = "http://91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/challenge/"+pIdChallenge;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return challengeByIdFromJson(jsonResponse);
    }

    @Override
    public List<Challenge> getChallengesByCodeEtab(int pCodeEtab) throws Exception{

        String serverAddress = "http://91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/_search?q=code_etab:"+pCodeEtab;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return challengesByCodeEtabFromJson(jsonResponse);
    }

    @Override
    public List<ChallengeType> getAllChallengeTypes() throws Exception {
        return ChallengeTypeFactory.makeChallengeTypeList();
    }

    public Challenge challengeByIdFromJson(String pJsonString) throws JSONException {
        Challenge challenge = new Challenge();

        JSONObject jsonObject = new JSONObject(pJsonString);
        JSONObject source = jsonObject.getJSONObject("_source");

        //Attributs Challenge
        String challengeId = jsonObject.getString("_id");
        int points = source.getInt("points");
        String dateCreated = source.getString("update").substring(0,10);

        //Attributs ChallengeType
        String codeType = source.getString("code");

        //Attributs Etablissement
        String etabAdresse = source.getString("adresse");
        int codeEtab = source.getInt("code_etab");
        String denom = source.getString("denom");
        double latitude = source.getJSONObject("_geo").getDouble("lat");
        double longitude = source.getJSONObject("_geo").getDouble("lon");

        Etablissement etablissement = new Etablissement(codeEtab, denom, etabAdresse, latitude, longitude);

        challenge.setIdChallenge(challengeId);
        challenge.setEtablissement(etablissement);
        challenge.setType(ChallengeTypeFactory.makeChallengeType(codeType));
        challenge.setPoints(points);
        challenge.setDateCreated(dateCreated);

        return challenge;
    }

    public List<Challenge> challengesByCodeEtabFromJson(String pJsonString) throws JSONException {
        List<Challenge> lstChallenges = new ArrayList<>();


        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArray = new JSONArray(hits);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject hit = jsonArray.getJSONObject(i);
            JSONObject source = jsonArray.getJSONObject(i).getJSONObject("_source");

            //Attributs Challenge
            String challengeId = hit.getString("_id");
            int points = source.getInt("points");
            String dateCreated = source.getString("update").substring(0,10);

            //Attributs ChallengeType
            String codeType = source.getString("code");

            //Attributs Etablissement
            String etabAdresse = source.getString("adresse");
            int codeEtab = source.getInt("code_etab");
            String denom = source.getString("denom");
            double latitude = source.getJSONObject("_geo").getDouble("lat");
            double longitude = source.getJSONObject("_geo").getDouble("lon");

            Etablissement etablissement = new Etablissement(codeEtab, denom, etabAdresse, latitude, longitude);


            Challenge challenge = new Challenge();
            challenge.setIdChallenge(challengeId);
            challenge.setEtablissement(etablissement);
            challenge.setType(ChallengeTypeFactory.makeChallengeType(codeType));
            challenge.setPoints(points);
            challenge.setDateCreated(dateCreated);
            lstChallenges.add(challenge);
        }

        return lstChallenges;
    }
}
