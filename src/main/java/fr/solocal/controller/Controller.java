package fr.solocal.controller;

import fr.solocal.builder.AchievementDTO;
import fr.solocal.builder.BuilderDTO;
import fr.solocal.builder.ChallengeDTO;
import fr.solocal.builder.UserDTO;
import fr.solocal.domain.*;
import fr.solocal.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
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
     * @return une liste des types de challenge
     */
    @RequestMapping(value = "challengetypes", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<ChallengeType> getChallengeTypes() throws Exception {
        List<ChallengeType> lstChallengeTypes = challengeTypeService.getAllChallengeTypes();

        return lstChallengeTypes;
    }

     /**
     * Renvoie le challenge correspondant à l'id passé en paramètre
     *
     * @param idChallenge
     *      L'id du challenge
     *
     * @return un objet ChallengeDTO
     */
    @RequestMapping(value = "challenge/{idChallenge}",  method = RequestMethod.GET, headers = "Accept=application/json")
    public ChallengeDTO getChallengeById(@PathVariable(value="idChallenge") String idChallenge) throws Exception {
        Challenge challenge = challengeService.getChallengeById(idChallenge);

        return BuilderDTO.generateChallengeDTO(challenge);
    }


    /**
     * Renvoie la liste des challenges correspondants à l'id passé en paramètre
     *
     * @param pCodeEtab
     *      Le code de l'établissement
     *
     * @return une liste des challenges de l'établissement
     */
    @RequestMapping(value = "challenge", params = "codeEtab",  method = RequestMethod.GET, headers = "Accept=application/json")
    public List<ChallengeDTO> getChallengesByCodeEtab(@RequestParam(value = "codeEtab") int pCodeEtab) throws Exception {
        List<ChallengeDTO> lstChallengesDTO = new ArrayList<>();
        List<Challenge> lstChallenges = challengeService.getChallengeByCodeEtab(pCodeEtab);

        for(Challenge challenge : lstChallenges){
            lstChallengesDTO.add(BuilderDTO.generateChallengeDTO(challenge));
        }

        return lstChallengesDTO;
    }

    /**
     * Renvoie une liste d'établissements par rapport à la position de l'utilisateur (latitude, longitude)
     *
     * @return une liste des établissements
     * TODO: cette méthode
     */
    @RequestMapping(value = "etablissements", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Etablissement> getAllEtablissements(@RequestParam(value = "lat") double pLatitude, @RequestParam(value = "lon") double pLongitude, @RequestParam(value = "ray") int pRayon) throws Exception {
        List<Etablissement> lstEtablissement = etablissementService.getEtablissementsByPosition(pLatitude, pLongitude, pRayon);

        return lstEtablissement;
    }

    /**
     * Renvoie la liste des résolutions de challenges effectuées par un utilisateur en fonction de son id
     *
     * @return une liste de résolutions de challenges
     */
    @RequestMapping(value = "achievement", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<AchievementDTO> getAllAchievements(@RequestParam(value = "email") String pEmail) throws Exception {
        List<AchievementDTO> lstAchievementsDTO = new ArrayList<>();
        List<Achievement> lstAchievements = achievementService.getAllResolutions(pEmail);

        for(Achievement achievement : lstAchievements){
            lstAchievementsDTO.add(BuilderDTO.generateAchievementDTO(pEmail, achievement));
        }

        return lstAchievementsDTO;
    }

    /**
     *  Méthode permettant de résoudre un challenge
     *  TODO: rajouter un retour comme dans le contrat d'interface
     */
    @RequestMapping(value = "achievement", method = RequestMethod.POST, headers = "Accept=application/json")
    public void achieveChallenge(@RequestParam(value = "idChallenge") String pIdChallenge, @RequestParam(value = "email") String pEmail, @RequestParam(value = "photo") String pPhoto) throws Exception {
       achievementService.achieveChallenge(pIdChallenge, pEmail, pPhoto);
    }

    /**
     * Renvoie les informations d'un utilisateur, correspond à la connexion
     *
     * @return un objet UserDTO
     */
    @RequestMapping(value = "user", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserDTO connexion(@RequestParam(value = "email") String pEmail, @RequestParam(value = "pwd") String pPwd) throws Exception {
        User user = userService.connexion(pEmail, pPwd);
        UserDTO userDTO = BuilderDTO.generateUserDTO(user);

        return userDTO;
    }

    /**
     * Renvoie une liste d'utilisateurs correspondant au classement (les 10 premiers ainsi que l'utilisateur)
     *
     * @return une liste d'utilisateurs
     */
    @RequestMapping(value = "ranking", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<UserDTO> getRanking(@RequestParam(value = "email") String pEmail) throws Exception {
        List<UserDTO> lstUsersDTO = new ArrayList<>();
        List<User> lstUser = userService.getRanking(pEmail);

        for(User user : lstUser){
            lstUsersDTO.add(BuilderDTO.generateUserDTO(user));
        }


        return lstUsersDTO;
    }
}
