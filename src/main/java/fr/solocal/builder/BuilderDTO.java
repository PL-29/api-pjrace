package fr.solocal.builder;

import fr.solocal.domain.*;


/**
 * Created by stage04 on 10/03/17.
 */
public class BuilderDTO {

    public UserDTO generateUserDTO (User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setpLastname(user.getpLastname());
        userDTO.setpFirstname(user.getpFirstname());
        userDTO.setpEmail(user.getpEmail());
        userDTO.setpPassword(user.getpPassword());
        userDTO.setpRank(user.getpIdUser());
        return userDTO;
    }

    public AchievementDTO generateAchievementDTO (Achievement achievement) {

        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setpIdResolution(achievement.getpIdResolution());
        achievementDTO.setpChallenge(achievement.getChallenge());
        achievementDTO.setpUrlPhoto(achievement.getpUrlPhoto());

        return achievementDTO;
    }

    public ChallengeDTO generateChallengeDTO (Challenge challenge) {

        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setpIdChallenge(challenge.getpIdChallenge());
        challengeDTO.setpEtablissement(challenge.getpEtablissement());
        challengeDTO.setpType(challenge.getpType());
        challengeDTO.setpPoints(challenge.getpPoints());
        return challengeDTO;
    }

    public ChallengeTypeDTO generateChallengeDTO (ChallengeType challengeType) {

        ChallengeTypeDTO challengeTypeDTO = new ChallengeTypeDTO();
        challengeTypeDTO.setPidChallengeType(challengeType.getpIdChallengeType());
        challengeTypeDTO.setpTitle(challengeType.getpTitle());
        challengeTypeDTO.setpDefaultNumberPoints(challengeType.getpDefaultNumberPoints());
        challengeTypeDTO.setpDescription(challengeType.getpDescription());
        return challengeTypeDTO;
    }

    public EtablissementDTO generateEtablissementDTO (Etablissement etablissement) {

        EtablissementDTO etablissementDTO = new EtablissementDTO();
        etablissementDTO.setChallenges(etablissement.getChallenges());
        etablissementDTO.setpCodeEtab(etablissement.getpCodeEtab());
        etablissementDTO.setpDenomination(etablissement.getpDenomination());
        etablissementDTO.setpAddress(etablissement.getpAddress());
        etablissementDTO.setpLatitude(etablissement.getpLatitude());
        etablissementDTO.setpLongitude(etablissement.getpLongitude());
        return etablissementDTO;
    }

    public CoordonneeDTO generateCoordonneeDTO ( Coordonnee coordonnee) {

        CoordonneeDTO coordonneeDTO = new CoordonneeDTO();
        coordonneeDTO.setLat(coordonnee.getLat());
        coordonneeDTO.setLng(coordonnee.getLng());
        return coordonneeDTO;

    }

}
