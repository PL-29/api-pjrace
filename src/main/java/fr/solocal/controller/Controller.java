package fr.solocal.controller;

import fr.solocal.domain.*;
import fr.solocal.service.*;
import org.json.JSONException;
import org.json.JSONObject;
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


    /**
     * Retourne la liste des types de challenge
     *
     * @return Un objet Iterator sur la liste des types de challenge
     */
    @RequestMapping(value = "challengetypes", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<ChallengeType> getChallengeTypes() {
        Iterator<ChallengeType> itChallengeTypes = challengeTypeService.getAllChallengeTypes();

        return itChallengeTypes;
    }

    /**
     * Renvoie la liste des challenges
     *
     * @return un objet Iterator sur la liste des challenges
     */
    @RequestMapping(value = "challenges", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Challenge> getChallenges() {
        Iterator<Challenge> itChallenges = challengeService.getAllChallenges();

       return itChallenges;
    }


    /**
     * Renvoie le challenge correspondant à l'id passé en paramètre
     *
     * @param idChallenge
     *      L'id du challenge
     *
     * @return un objet Challenge
     */
    @RequestMapping(value = "challenge/{idChallenge}",  method = RequestMethod.GET, headers = "Accept=application/json")
    public Challenge getChallengeById(@PathVariable int idChallenge) {
        Challenge challenge = challengeService.getChallengeById(idChallenge);

        return challenge;
    }


    /**
     * Renvoie la liste des challenges correspondants à l'id passé en paramètre
     *
     * @param codeEtab
     *      Le code de l'établissement
     *
     * @return un objet Iterator sur la liste des challenges de l'établissement
     */
    @RequestMapping(value = "challenge", params = "codeEtab",  method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Challenge> getChallengesByCodeEtab(@RequestParam(value = "codeEtab") int codeEtab) {

        Iterator<Challenge> itChallenges = challengeService.getChallengeByCodeEtab(codeEtab);

        return itChallenges;
    }

    /**
     * Renvoie une liste d'établissements par rapport à la position de l'utilisateur (latitude, longitude)
     *
     * @return un objet Iterator sur une liste des établissements
     */
    @RequestMapping(value = "etablissements", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Etablissement> getAllEtablissements() {
        double latitude = 0.1555;
        double longitude = 151.6;
        Iterator<Etablissement> itEtablissement = etablissementService.getEtablissementsByPosition(latitude, longitude);

        return itEtablissement;
    }

    /**
     * Renvoie une liste d'utilisateurs correspondant au classement (les 10 premiers ainsi que l'utilisateur)
     *
     * @return un objet Iterator sur une liste d'utilisateurs
     */
    @RequestMapping(value = "ranking", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<User> getRanking() {
        Iterator<User> lstUser = userService.getRanking(1);

        return lstUser;
    }


    /**
     * Renvoie la liste des résolutions de challenges effectuées par un utilisateur en fonction de son id
     *
     * @return un objet Iterator sur une liste de résolutions de challenges
     */
    @RequestMapping(value = "achievements", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Achievement> getAllAchievements() {
        Iterator<Achievement> itAchievements = achievementService.getAllResolutions(1);

        return itAchievements;
    }

    /**
     * Renvoie les informations d'un utilisateur, correspond à la connexion
     *
     * @return un objet User
     */
    @RequestMapping(value = "user", method = RequestMethod.GET, headers = "Accept=application/json")
    public User connexion() {
        String email = "blabla@gmail.com";
        String password = "xxxx";
        User user = userService.connexion(email, password);

        return user;
    }


    /**
     *  Méthode permettant de résoudre un challenge
     */
    @RequestMapping(value = "achievement", method = RequestMethod.POST, headers = "Accept=application/json")
    public void achieveChallenge() {
        int idChallenge = 0;
        int idUser = 0;
        String photo = "";

        achievementService.achieveChallenge(idChallenge, idUser, photo);
    }
}
