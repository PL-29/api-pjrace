package fr.solocal.controller;

import fr.solocal.builder.*;
import fr.solocal.dao.UserDAO;
import fr.solocal.dao.impl.UserDAOImpl;
import fr.solocal.domain.*;
import fr.solocal.service.*;
import fr.solocal.utils.ImageConverter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
     */
    @RequestMapping(value = "etablissements", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<EtablissementDTO> getAllEtablissements(@RequestParam(value = "lat") String pLatitude, @RequestParam(value = "lon") String pLongitude, @RequestParam(value = "ray") String pRayon) throws Exception {

        List<Etablissement> lstEtablissement = etablissementService.getEtablissementsByPosition(pLatitude, pLongitude, pRayon);
        List<EtablissementDTO> lstEtablissementDTO = new ArrayList<>();

        for (Etablissement etab : lstEtablissement){
            lstEtablissementDTO.add(BuilderDTO.generateEtablissementDTO(etab));
        }

        return lstEtablissementDTO;
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
    @ResponseBody
    public void achieveChallenge(@RequestParam(value = "idChallenge") String pIdChallenge, @RequestParam(value = "email") String pEmail, @RequestBody String requestBodyString) throws Exception {
       //achievementService.achieveChallenge(pIdChallenge, pEmail);*/
        JSONObject jsonImage = new JSONObject(requestBodyString);
        achievementService.achieveChallenge(jsonImage.getString("photo"), pIdChallenge, pEmail);
    }

    /**
     * Renvoie les informations d'un utilisateur, correspond à la connexion
     *
     * @return un objet UserDTO
     * //TODO : A FAIRE
     */
    @RequestMapping(value = "user", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserDTO connexion(@RequestParam(value = "email") String pEmail, @RequestParam(value = "pwd") String pPwd) throws Exception {
        User user = userService.connexion(pEmail, pPwd);
        UserDTO userDTO = BuilderDTO.generateUserDTO(user);

        return userDTO;
    }


    //TODO : FAIRE LA REQUETE PERMETTANT D'OBTENIR LA DISTANCE ENTRE L'UTILISATEUR ET LE CHALLENGE LE PLUS PROCHE
    @RequestMapping(value = "rayon", method = RequestMethod.GET, headers = "Accept=application/json")
    public Integer getDistanceToClosestChallenge(@RequestParam(value = "lat") String pLatitude, @RequestParam(value = "lon") String pLongitude) throws Exception {

        return 0;
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
