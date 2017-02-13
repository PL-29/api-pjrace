package fr.solocal.controller;

import fr.solocal.domain.*;
import fr.solocal.service.*;
import org.springframework.web.bind.annotation.*;

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

    @Inject
    private EtablissementService etablissementService;

    @Inject
    private UserService userService;

    @Inject
    private AchievementService achievementService;


    @RequestMapping(value = "challengetypes", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<ChallengeType> getChallengeTypes() {
        Iterator<ChallengeType> lstChallengeTypes = challengeTypeService.getAllChallengeTypes();

        return lstChallengeTypes;
    }

    /**
     * Renvoie tous les challenges
     *
     * @return un itérateur sur la liste des challenges
     */
    @RequestMapping(value = "challenges", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Challenge> getChallenges() {
        Iterator<Challenge> lstChallenges = challengeService.getAllChallenges();

        return lstChallenges;
    }


    /**
     * Renvoie le challenge correspondant à l'id passé en paramètre
     *
     * @param idChallenge
     *
     * @return un objet Challenge
     */
    @RequestMapping(value = "challenge/{idChallenge}",  method = RequestMethod.GET, headers = "Accept=application/json")
    public Challenge getChallengeById(@PathVariable int idChallenge) {
        Challenge challenge = challengeService.getChallengeById(idChallenge);

        return challenge;
    }


    @RequestMapping(value = "challenge", params = "codeEtab",  method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Challenge> getChallengesByCodeEtab(@RequestParam(value = "codeEtab") int codeEtab) {

        Iterator<Challenge> lstChallenges = challengeService.getChallengeByCodeEtab(codeEtab);

        return lstChallenges;
    }

    @RequestMapping(value = "etablissements", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Facility> getAllEtablissements() {
        Iterator<Facility> lstChallenges = etablissementService.getAllEtablissements();

        return lstChallenges;
    }

    @RequestMapping(value = "ranking", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<User> getRanking() {
        Iterator<User> lstUser = userService.getRanking(1);

        return lstUser;
    }

    @RequestMapping(value = "achievements", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Achievement> getAllAchievements() {
        Iterator<Achievement> lstAchievements = achievementService.getAllResolutions(1);

        return lstAchievements;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET, headers = "Accept=application/json")
    public User connexion() {
        String email = "blabla@gmail.com";
        String password = "xxxx";
        User user = userService.connexion(email, password);

        return user;
    }

    @RequestMapping(value = "achievement", method = RequestMethod.POST, headers = "Accept=application/json")
    public void achieveChallenge() {
        int idChallenge = 0;
        int idUser = 0;
        String photo = "";

        achievementService.achieveChallenge(idChallenge, idUser, photo);
    }
}
