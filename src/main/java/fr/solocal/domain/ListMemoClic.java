/**
 * 
 */
package fr.solocal.domain;

import java.util.List;

/**
 * @author fchantrel
 *
 */
public class ListMemoClic {
	
	private List<MemoClic> lstMemoClic;

	/**
	 * 
	 */
	public ListMemoClic() {
	}
	
	/**
	 * 
	 */
	public ListMemoClic(List<MemoClic> pLstClic) {
		this.lstMemoClic = pLstClic;
	}
	
	public List<MemoClic> getLstMemoClic() {
		return lstMemoClic;
	}

	public void setLstMemoClic(List<MemoClic> lstMemoClic) {
		this.lstMemoClic = lstMemoClic;
	}

}
