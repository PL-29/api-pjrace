package fr.solocal.dao;

import java.util.Iterator;

import fr.solocal.domain.MemoSearch;

/**
 * @author fchantrel
 *
 */
public interface MemoSearchDAO {
	
	public void addMemoSearch(MemoSearch pMemoSearch);
	
	public Iterator<MemoSearch> iterator();
}
