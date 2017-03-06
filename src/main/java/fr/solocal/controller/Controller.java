package fr.solocal.controller;

import fr.solocal.domain.*;
import fr.solocal.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

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
     * Renvoie le challenge correspondant à l'id passé en paramètre
     *
     * @param idChallenge
     *      L'id du challenge
     *
     * @return un objet Challenge
     */
    @RequestMapping(value = "challenge/{idChallenge}",  method = RequestMethod.GET, headers = "Accept=application/json")
    public Challenge getChallengeById(@PathVariable String idChallenge) {
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
    public Iterator<Etablissement> getAllEtablissements(@RequestParam(value = "lat") double latitude, @RequestParam(value = "lon") double longitude, @RequestParam(value = "ray") int rayon) {
        Iterator<Etablissement> lstEtablissement = etablissementService.getEtablissementsByPosition(latitude, longitude, rayon);

        return lstEtablissement;
    }

    /**
     * Renvoie la liste des résolutions de challenges effectuées par un utilisateur en fonction de son id
     *
     * @return un objet Iterator sur une liste de résolutions de challenges
     */
    @RequestMapping(value = "achievement", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<Achievement> getAllAchievements(@RequestParam(value = "id") int idUser) {
        Iterator<Achievement> itAchievements = achievementService.getAllResolutions(idUser);

        return itAchievements;
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
     * Renvoie une liste d'utilisateurs correspondant au classement (les 10 premiers ainsi que l'utilisateur)
     *
     * @return un objet Iterator sur une liste d'utilisateurs
     */
    @RequestMapping(value = "ranking", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<User> getRanking() {
        Iterator<User> lstUser = userService.getRanking(1);

        return lstUser;
    }
}
