package fr.solocal.builder;

import fr.solocal.domain.*;


/**
 * Created by stage04 on 10/03/17.
 */
public class BuilderDTO {

    public UserDTO generateUserDTO (User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setLastname(user.getLastname());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRank(user.getIdUser());
        return userDTO;
    }

    public AchievementDTO generateAchievementDTO (Achievement achievement) {

        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setIdResolution(achievement.getIdResolution());
        achievementDTO.setChallenge(achievement.getChallenge());
        achievementDTO.setUrlPhoto(achievement.getUrlPhoto());

        return achievementDTO;
    }

    public ChallengeDTO generateChallengeDTO (Challenge challenge) {

        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setIdChallenge(challenge.getIdChallenge());
        challengeDTO.setEtablissement(challenge.getEtablissement());
        challengeDTO.setType(challenge.getType());
        challengeDTO.setPoints(challenge.getPoints());
        return challengeDTO;
    }

    public ChallengeTypeDTO generateChallengeDTO (ChallengeType challengeType) {

        ChallengeTypeDTO challengeTypeDTO = new ChallengeTypeDTO();
        challengeTypeDTO.setIdChallengeType(challengeType.getIdChallengeType());
        challengeTypeDTO.setTitle(challengeType.getTitle());
        challengeTypeDTO.setDefaultNumberPoints(challengeType.getDefaultNumberOfPoints());
        challengeTypeDTO.setDescription(challengeType.getDescription());
        return challengeTypeDTO;
    }

    public EtablissementDTO generateEtablissementDTO (Etablissement etablissement) {

        EtablissementDTO etablissementDTO = new EtablissementDTO();
        etablissementDTO.setChallenges(etablissement.getChallenges());
        etablissementDTO.setCodeEtab(etablissement.getCodeEtab());
        etablissementDTO.setDenomination(etablissement.getDenomination());
        etablissementDTO.setAddress(etablissement.getAddress());
        etablissementDTO.setLatitude(etablissement.getLatitude());
        etablissementDTO.setLongitude(etablissement.getLongitude());
        return etablissementDTO;
    }

    public CoordonneeDTO generateCoordonneeDTO ( Coordonnee coordonnee) {

        CoordonneeDTO coordonneeDTO = new CoordonneeDTO();
        coordonneeDTO.setLat(coordonnee.getLat());
        coordonneeDTO.setLng(coordonnee.getLng());
        return coordonneeDTO;

    }

}
