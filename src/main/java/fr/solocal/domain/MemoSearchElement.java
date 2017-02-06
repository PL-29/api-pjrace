/**
 * 
 */
package fr.solocal.domain;

/**
 * @author fchantrel
 *
 */
public class MemoSearchElement {
	
	private String denomination;
	
	private String idEPJ;

	private Coordonnee coordonnee;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}
	
	public String getIdEPJ() {
		return idEPJ;
	}

	public void setIdEPJ(String idEPJ) {
		this.idEPJ = idEPJ;
	}

	/**
	 * 
	 */
	public MemoSearchElement() {
	}

	public MemoSearchElement(String denomination, Coordonnee coordonnee) {
		super();
		this.denomination = denomination;
		this.coordonnee = coordonnee;
	}

}
