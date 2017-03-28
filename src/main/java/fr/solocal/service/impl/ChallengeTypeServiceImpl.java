package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.dao.ChallengeDAO;
import fr.solocal.domain.ChallengeType;
import fr.solocal.service.ChallengeTypeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
@Service("challengeTypeService")
public class ChallengeTypeServiceImpl implements ChallengeTypeService{

    @Inject
    private ChallengeDAO challengeDAO;

    @Override
    public List<ChallengeType> getAllChallengeTypes() throws Exception {
        return challengeDAO.getAllChallengeTypes();
    }
}
