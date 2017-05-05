package fr.solocal.builder;

import fr.solocal.domain.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by stage04 on 10/03/17.
 */
public class BuilderDTO {

    public static UserDTO generateUserDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(user.getIdUser());
        userDTO.setLastname(user.getLastname());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setEmail(user.getEmail());
        userDTO.setRank(user.getRank());
        userDTO.setScore(user.getScore());
        return userDTO;
    }

    public static AchievementDTO generateAchievementDTO (Achievement achievement) {
        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setIdAchievement(achievement.getIdAchievement());
        achievementDTO.setIdChallenge(achievement.getChallenge().getIdChallenge());
        achievementDTO.setUrlPhoto(achievement.getUrlPhoto());
        achievementDTO.setDateCreated(achievement.getChallenge().getDateCreated());
        achievementDTO.setIdUser(achievement.getUser().getIdUser());

        return achievementDTO;
    }

    public static ChallengeDTO generateChallengeDTO (Challenge challenge) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setIdChallenge(challenge.getIdChallenge());
        challengeDTO.setIdChallengeType(challenge.getType().getIdChallengeType());
        challengeDTO.setPoints(challenge.getPoints());
        challengeDTO.setDateCreated(challenge.getDateCreated());
        return challengeDTO;
    }

    public static EtablissementDTO generateEtablissementDTO (Etablissement etablissement) {
        EtablissementDTO etablissementDTO = new EtablissementDTO();
        etablissementDTO.setChallenges(etablissement.getChallenges());
        etablissementDTO.setCodeEtab(etablissement.getCodeEtab());
        etablissementDTO.setDenomination(etablissement.getDenomination());
        etablissementDTO.setAddress(etablissement.getAddress());
        etablissementDTO.setLatitude(etablissement.getLatitude());
        etablissementDTO.setLongitude(etablissement.getLongitude());
        return etablissementDTO;
    }

    public static MessageDTO generateMessageDTO (String denomination, Object content) {
        MessageDTO messageDTO = new MessageDTO("distance(m)", content);
        return messageDTO;
    }
}
