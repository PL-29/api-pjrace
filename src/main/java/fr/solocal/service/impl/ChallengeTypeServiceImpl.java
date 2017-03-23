package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
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
    private CentralDAO dao;

    @Override
    public List<ChallengeType> getAllChallengeTypes() {
        //return dao.getAllChallengeTypes();
        return null;
    }
}
