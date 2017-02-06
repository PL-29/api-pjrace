package fr.solocal.dao;

import java.util.List;

import fr.solocal.domain.MemoClic;

/**
 * @author fchantrel
 * DAO d'accès aux clics entegistrés.
 *
 */
public interface MemoClicDAO {
	
	public void addMemoClic(MemoClic pMemoClic);
	
	public List<MemoClic> iterateAndRemove();
}
