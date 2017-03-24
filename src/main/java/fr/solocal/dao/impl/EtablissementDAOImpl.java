package fr.solocal.dao.impl;

import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.Etablissement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
@Repository("etablissementDAO")
public class EtablissementDAOImpl extends Requester implements EtablissementDAO{
    @Override
    public List<Etablissement> getEtablissementsByPosition(double pLatitude, double pLongitude, int pRayon) throws Exception {
        String serverAddress = "http://91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/challenge/_search?q=_geo.lon:"+pLongitude+"%20 AND %20_geo.lat:"+pLatitude;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        etablissementsListFromJson(jsonResponse);
        return null;
    }

    public void etablissementsListFromJson(String response) throws JSONException {
        /*HashSet<Etablissement>
        List<Etablissement> lstEtablissements= new ArrayList<>();
        List<Challenge> lstChallenges = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(response);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArray = new JSONArray(hits);

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject hit = jsonArray.getJSONObject(i);
            JSONObject etablissementJson  = jsonArray.getJSONObject(i).getJSONObject("_source");

            //Attributs Etablissement
            String etabAdresse = etablissementJson.getString("adresse");
            int codeEtab = etablissementJson.getInt("code_etab");
            String denom = etablissementJson.getString("denom");
            double latitude = etablissementJson.getJSONObject("_geo").getDouble("lat");
            double longitude = etablissementJson.getJSONObject("_geo").getDouble("lon");

            Etablissement etab = new Etablissement();
            etab.setCodeEtab(codeEtab);
            etab.setDenomination(denom);
            etab.setAddress(etabAdresse);
            etab.setLatitude(latitude);
            etab.setLongitude(longitude);

            //Attributs Challenge
            String challengeId = hit.getString("_id");
            int challengePoints = etablissementJson.getInt("points");
            String challengeType = etablissementJson.getString("code");

            Challenge challenge = new Challenge(challengeId, etab, new ChallengeType(), challengePoints);
            lstChallenges.add(challenge);
        }

        for (Challenge challenge : lstChallenges){
            if(!lstEtablissements.contains(challenge.getEtablissement())){
                lstEtablissements.add(challenge.getEtablissement());
            }
        }

        System.out.println("nb etab: "+lstEtablissements.size());
        System.out.println("nb challenge"+lstChallenges.size());*/


    }
}
