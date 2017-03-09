package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;
import fr.solocal.service.ChallengeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("challengeService")
public class ChallengeServiceImpl implements ChallengeService{

    @Inject
    private CentralDAO dao;

    @Override
    public Iterator<Challenge> getAllChallenges() {
        return dao.getAllChallenges();
    }

    @Override
    public Challenge getChallengeById(String pIdChallenge) {
        return dao.getChallengeById(pIdChallenge);
    }

    @Override
    public Iterator<Challenge> getChallengeByCodeEtab(int pCodeEtab) {
        return dao.getChallengesByCodeEtab(pCodeEtab);
    }
}
