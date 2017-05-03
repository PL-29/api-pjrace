package fr.solocal.dao.impl;

import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.ChallengeTypeFactory;
import fr.solocal.domain.Etablissement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
@Repository("etablissementDAO")
public class EtablissementDAOImpl extends Requester implements EtablissementDAO{
    private static final String SERVER_ADDRESS  = "http://91.134.242.201";
    private static final int NB_ETAB  = 100;

    @Override
    public List<Etablissement> getEtablissementsByPosition(String pLatitude, String pLongitude, String pRayon) throws Exception {
        String url = SERVER_ADDRESS+"/pjrace_challenge/etab/_search";

        String jsonResponse = super.sendPostRequest(url, scriptQueryDistanceFilter(pLatitude, pLongitude, pRayon));

        return etablissementsListFromJson(jsonResponse);
    }

    @Override
    public JSONObject getDistanceToClosestChallenge(String pLatitude, String pLongitude) throws Exception {
        String url = SERVER_ADDRESS+"/pjrace_challenge/etab/_search";
        String jsonResponse = super.sendPostRequest(url, scriptQueryDistanceSort(pLatitude, pLongitude));
        System.out.println(jsonResponse);
        return distanceToClosestChallengeFromJson(jsonResponse);
    }

    public JSONObject distanceToClosestChallengeFromJson(String pJsonString) throws JSONException {
        Etablissement etablissement = new Etablissement();


        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArray = new JSONArray(hits);

        double sort = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            sort = jsonArray.getJSONObject(i).getDouble("sort");
        }

        System.out.println("---------------->"+sort);
        return null;
    }

    public List<Etablissement> etablissementsListFromJson(String pJsonString) throws JSONException {
        List<Etablissement> lstEtablissements = new ArrayList<>();


        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArrayEtab = new JSONArray(hits);

        for (int i = 0; i < jsonArrayEtab.length(); i++) {
            JSONObject source = jsonArrayEtab.getJSONObject(i).getJSONObject("_source");
            JSONArray jsonArrayChallenge = new JSONArray(source.getString("challenges"));
            List<Challenge> lstChallenges = new ArrayList<>();

            for (int y = 0; y < jsonArrayChallenge.length(); y++){
                String idChallenge = jsonArrayChallenge.getJSONObject(y).getString("id");
                ChallengeType challengeType = ChallengeTypeFactory.makeChallengeType(jsonArrayChallenge.getJSONObject(y).getString("code"));

                Challenge challenge = new Challenge();
                challenge.setIdChallenge(idChallenge);
                challenge.setType(challengeType);
                lstChallenges.add(challenge);
            }

            int codeEtab = source.getInt("code_etab");
            String address = source.getString("adresse");
            String denom = source.getString("denom");
            double lat = source.getJSONObject("location").getDouble("lat");
            double lon = source.getJSONObject("location").getDouble("lon");

            Etablissement etablissement = new Etablissement(codeEtab, denom, address, lat, lon);
            etablissement.setChallenges(lstChallenges);
            lstEtablissements.add(etablissement);

        }

        return lstEtablissements;
    }

    public JSONObject scriptQueryDistanceFilter(String pLatitude, String pLongitude, String pRayon) throws JSONException {
        JSONObject jsonLatLon = new JSONObject();
        jsonLatLon.put("lat", pLatitude);
        jsonLatLon.put("lon", pLongitude);

        JSONObject jsonGeoDistance = new JSONObject();
        jsonGeoDistance.put("distance", pRayon+"km");
        jsonGeoDistance.put("location", jsonLatLon);

        JSONObject jsonFilter = new JSONObject();
        jsonFilter.put("geo_distance",jsonGeoDistance);

        JSONObject jsonMust = new JSONObject();
        jsonMust.put("match_all", new JSONObject());

        JSONObject jsonBool = new JSONObject();
        jsonBool.put("must", jsonMust);
        jsonBool.put("filter", jsonFilter);

        JSONObject jsonQuery = new JSONObject();
        jsonQuery.put("bool", jsonBool);

        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("query", jsonQuery);
        jsonReturn.put("from", 0);
        jsonReturn.put("size", NB_ETAB);

        return jsonReturn;
    }

    public JSONObject scriptQueryDistanceSort(String pLatitude, String pLongitude) throws JSONException {
        JSONObject jsonLatLon = new JSONObject();
        jsonLatLon.put("lat", pLatitude);
        jsonLatLon.put("lon", pLongitude);

        JSONObject jsonLocation = new JSONObject();
        jsonLocation.put("location", jsonLatLon);
        jsonLocation.put("order", "asc");
        jsonLocation.put("unit", "m");
        jsonLocation.put("distance_type", "plane" );

        JSONObject jsonGeoDistance = new JSONObject();
        jsonGeoDistance.put("_geo_distance", jsonLocation);

        JSONObject jsonReturn = new JSONObject();
        jsonReturn.put("sort", jsonGeoDistance);

        return jsonReturn;
    }
}
