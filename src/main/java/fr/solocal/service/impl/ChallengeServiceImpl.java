package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.dao.ChallengeDAO;
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
    private ChallengeDAO challengeDAO;

    @Override
    public Challenge getChallengeById(String pIdChallenge) throws Exception {
        return challengeDAO.getChallengeById(pIdChallenge);
    }

    @Override
    public List<Challenge> getChallengeByCodeEtab(int pCodeEtab) throws Exception {
        return challengeDAO.getChallengesByCodeEtab(pCodeEtab);
    }
}
