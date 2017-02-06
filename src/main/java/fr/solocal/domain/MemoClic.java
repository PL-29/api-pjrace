/**
 *
 */
package fr.solocal.domain;

/**
 * @author fchantrel
 * Classe décrivant un clic sur un pro.
 *
 */
public class MemoClic {

    private String idProfessionnel;

    private String partenaire;

    private String typePage;

    private String strategie;

    private String quoi;

    private String ou;

    private int nbPros;

    private int positionPro;

    private String dateClic;

    private String serveur;

    private String ipClient;

    private String apiUtilisee;

    private String eventType;

    private String eventTarget;

    public String getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(final String pPartenaire) {
        this.partenaire = pPartenaire;
    }

    public String getIdProfessionnel() {
        return idProfessionnel;
    }

    public void setIdProfessionnel(final String idProfessionnel) {
        this.idProfessionnel = idProfessionnel;
    }

    public String getTypePage() {
        return typePage;
    }

    public void setTypePage(final String typePage) {
        this.typePage = typePage;
    }

    public String getStrategie() {
        return strategie;
    }

    public void setStrategie(final String strategie) {
        this.strategie = strategie;
    }

    public String getQuoi() {
        return quoi;
    }

    public void setQuoi(final String pQuoi) {
        quoi = pQuoi;
    }

    public String getOu() {
        return ou;
    }

    public void setOu(final String pOu) {
        ou = pOu;
    }

    public int getNbPros() {
        return nbPros;
    }

    public void setNbPros(final int pNbPros) {
        nbPros = pNbPros;
    }

    public int getPositionPro() {
        return positionPro;
    }

    public void setPositionPro(final int pPositionPro) {
        positionPro = pPositionPro;
    }

    public String getDateClic() {
        return dateClic;
    }

    public void setDateClic(final String pDateClic) {
        dateClic = pDateClic;
    }

    public String getServeur() {
        return serveur;
    }

    public void setServeur(final String pServeur) {
        serveur = pServeur;
    }

    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(final String pIpClient) {
        ipClient = pIpClient;
    }

    public String getApiUtilisee() {
        return apiUtilisee;
    }

    public void setApiUtilisee(final String pApiUtilisee) {
        apiUtilisee = pApiUtilisee;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(final String pEventType) {
        eventType = pEventType;
    }

    public String getEventTarget() {
        return eventTarget;
    }

    public void setEventTarget(final String pEventTarget) {
        eventTarget = pEventTarget;
    }

    /**
     *
     */
    public MemoClic() {
    }

    public MemoClic(final String idProfessionnel, final String partenaire, final String typePage, final String strategie) {
        super();
        this.idProfessionnel = idProfessionnel;
        this.partenaire = partenaire;
        this.typePage = typePage;
        this.strategie = strategie;
    }

    public MemoClic(final String idProfessionnel, final String partenaire, final String typePage, final String strategie, final String quoi, final String ou, final int nbPros,
            final int positionPro, final String dateClic, final String serveur, final String ipClient, final String apiUtilisee, final String eventType, final String eventTarget) {
        super();
        this.idProfessionnel = idProfessionnel;
        this.partenaire = partenaire;
        this.typePage = typePage;
        this.strategie = strategie;
        this.quoi = quoi;
        this.ou = ou;
        this.nbPros = nbPros;
        this.positionPro = positionPro;
        this.dateClic = dateClic;
        this.serveur = serveur;
        this.ipClient = ipClient;
        this.apiUtilisee = apiUtilisee;
        this.eventType = eventType;
        this.eventTarget = eventTarget;
    }

}
