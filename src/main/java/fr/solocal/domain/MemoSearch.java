/**
 * 
 */
package fr.solocal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fchantrel
 * Classe représentant une liste de pros liée à une recherche déjà effectuée
 *
 */
public class MemoSearch implements Serializable {
	
	private static final long serialVersionUID = 7154841486817087339L;

	private String quoi;
	
	private String ou;
	
	private String partenaire;
	
	private List<MemoSearchElement> lstMemoSearchElement;

	/**
	 * 
	 */
	public MemoSearch() {
		
	}

	public MemoSearch(String quoi, String ou, String partenaire) {
		super();
		this.quoi = quoi;
		this.ou = ou;
		this.partenaire = partenaire;
	}

	public String getQuoi() {
		return quoi;
	}

	public void setQuoi(String quoi) {
		this.quoi = quoi;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public String getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(String partenaire) {
		this.partenaire = partenaire;
	}
	
	public List<MemoSearchElement> getLstMemoSearchElement() {
		return lstMemoSearchElement;
	}

	public void addMemoSearchElement(MemoSearchElement pMemoSearchElement) {
		if(lstMemoSearchElement == null){
			lstMemoSearchElement = new ArrayList<MemoSearchElement>(3);
		}
		this.lstMemoSearchElement.add(pMemoSearchElement);
	}
	
	public void setLstMemoSearchElement(List<MemoSearchElement> lstMemoSearchElement) {
		this.lstMemoSearchElement = lstMemoSearchElement;
	}

}
