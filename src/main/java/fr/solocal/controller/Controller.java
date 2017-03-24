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
    public List<ChallengeType> getChallengeTypes() {
        List<ChallengeType> itChallengeTypes = challengeTypeService.getAllChallengeTypes();

        return itChallengeTypes;
    }

     /**
     * Renvoie le challenge correspondant à l'id passé en paramètre
     *
     * @param idChallenge
     *      L'id du challenge
     *
     * @return un objet ChallengeSpring
     */
    @RequestMapping(value = "challenge/{idChallenge}",  method = RequestMethod.GET, headers = "Accept=application/json")
    public Challenge getChallengeById(@PathVariable(value="idChallenge") String idChallenge) throws Exception {
        Challenge challenge = challengeService.getChallengeById(idChallenge);

        return challenge;
    }


    /**
     * Renvoie la liste des challenges correspondants à l'id passé en paramètre
     *
     * @param pCodeEtab
     *      Le code de l'établissement
     *
     * @return un objet Iterator sur la liste des challenges de l'établissement
     */
    @RequestMapping(value = "challenge", params = "codeEtab",  method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Challenge> getChallengesByCodeEtab(@RequestParam(value = "codeEtab") int pCodeEtab) throws Exception {
        List<Challenge> itChallenges = challengeService.getChallengeByCodeEtab(pCodeEtab);

        return itChallenges;
    }

    /**
     * Renvoie une liste d'établissements par rapport à la position de l'utilisateur (latitude, longitude)
     *
     * @return un objet Iterator sur une liste des établissements
     */
    @RequestMapping(value = "etablissements", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Etablissement> getAllEtablissements(@RequestParam(value = "lat") double pLatitude, @RequestParam(value = "lon") double pLongitude, @RequestParam(value = "ray") int pRayon) throws Exception {
        List<Etablissement> lstEtablissement = etablissementService.getEtablissementsByPosition(pLatitude, pLongitude, pRayon);

        return lstEtablissement;
    }

    /**
     * Renvoie la liste des résolutions de challenges effectuées par un utilisateur en fonction de son id
     *
     * @return un objet Iterator sur une liste de résolutions de challenges
     */
    @RequestMapping(value = "achievement", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Achievement> getAllAchievements(@RequestParam(value = "email") String pEmail) throws Exception {
        List<Achievement> itAchievements = achievementService.getAllResolutions(pEmail);

        return itAchievements;
    }

    /**
     *  Méthode permettant de résoudre un challenge
     *  TODO: Rajouter idChallenge, idUser, photo en paramètre
     */
    @RequestMapping(value = "achievement", method = RequestMethod.POST, headers = "Accept=application/json")
    public void achieveChallenge(@RequestParam(value = "idChallenge") String pIdChallenge, @RequestParam(value = "email") String pEmail, @RequestParam(value = "photo") String pPhoto) throws Exception {
       achievementService.achieveChallenge(pIdChallenge, pEmail, pPhoto);
    }

    /**
     * Renvoie les informations d'un utilisateur, correspond à la connexion
     * TODO:Rajouter email et password en paramètre
     *
     * @return un objet User
     */
    @RequestMapping(value = "user", method = RequestMethod.GET, headers = "Accept=application/json")
    public User connexion() throws Exception {
        String email = "plollivier@test.com";
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
    public List<User> getRanking(@RequestParam(value = "email") String pEmail) throws Exception {
        List<User> lstUser = userService.getRanking(pEmail);

        return lstUser;
    }
}
