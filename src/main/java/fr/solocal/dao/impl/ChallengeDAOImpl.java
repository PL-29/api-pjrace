package fr.solocal.dao.impl;

import fr.solocal.dao.ChallengeDAO;
import fr.solocal.domain.Challenge;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public class ChallengeDAOImpl extends Requester implements ChallengeDAO {

    public ChallengeDAOImpl(){
        super();
    }

    @Override
    public List<Challenge> getAllChallenges() throws Exception{
        String serverAddress = "91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/_search";
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return null;
    }

    @Override
    public Challenge getChallengeById(String pIdChallenge) throws Exception{
        String serverAddress = "91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/challenge/"+pIdChallenge;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return null;
    }

    @Override
    public List<Challenge> getChallengesByCodeEtab(int pCodeEtab) throws Exception{

        String serverAddress = "91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/_search?q=code_etab:"+pCodeEtab;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);

        return null;
    }

}
