package fr.solocal.controller;

import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.ListMemoClic;
import fr.solocal.domain.MemoSearch;
import fr.solocal.service.ChallengeService;
import fr.solocal.service.ChallengeTypeService;
import fr.solocal.service.MemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Iterator;

/**
 * Created by stage01 on 10/02/17.
 */
@RestController("CentralController")
@RequestMapping(value = "/pjrace_v1")
public class Controller {
    @Inject
    private ChallengeTypeService challengeTypeService;

    @Inject
    private ChallengeService challengeService;

    @RequestMapping(value = "challengetypes", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<ChallengeType> getChallengeTypes() {
        Iterator<ChallengeType> lstChallengeTypes = challengeTypeService.getAllChallengeTypes();

        return lstChallengeTypes;
    }

    @RequestMapping(value = "challenges", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Challenge> getChallenges() {
        Iterator<Challenge> lstChallenges = challengeService.getAllChallenges();

        return lstChallenges;
    }


    private MemoService memoService;

    @RequestMapping(value = "search", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<MemoSearch> getLastSearch() {
        Iterator<MemoSearch> lstMemoSearch = memoService.getLastSearch();

        return lstMemoSearch;
    }

    @RequestMapping(value = "clics", method = RequestMethod.GET, headers = "Accept=application/json")
    public ListMemoClic getLastClics() {
        ListMemoClic lstMemoClic = memoService.getAndRemoveLastClics();

        return lstMemoClic;
    }
}
