/**
 * 
 */
package fr.solocal.service;

import java.util.Iterator;

import fr.solocal.domain.ListMemoClic;
import fr.solocal.domain.MemoSearch;

/**
 * @author fchantrel
 *
 */
public interface MemoService {
	
	public void addMemoSearch(MemoSearch pMemoSearch);
	
	public Iterator<MemoSearch> getLastSearch();
	
	public ListMemoClic getAndRemoveLastClics();

}
