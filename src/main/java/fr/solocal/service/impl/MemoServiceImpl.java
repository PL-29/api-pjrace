/**
 * 
 */
package fr.solocal.service.impl;

import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.solocal.dao.MemoClicDAO;
import fr.solocal.dao.MemoSearchDAO;
import fr.solocal.domain.ListMemoClic;
import fr.solocal.domain.MemoSearch;
import fr.solocal.service.MemoService;

/**
 * @author fchantrel
 *
 */
@Service("memoService")
public class MemoServiceImpl implements MemoService {

    @Inject
    private MemoClicDAO memoClicDAO;
	
    @Inject
    private MemoSearchDAO memoSearchDAO;
	/**
	 * 
	 */
	public MemoServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.solocal.service.MemoSearchService#addSearch(fr.solocal.domain.MemoSearch)
	 */
	@Override
	public void addMemoSearch(MemoSearch pMemoSearch) {
		memoSearchDAO.addMemoSearch(pMemoSearch);
	}

	/* (non-Javadoc)
	 * @see fr.solocal.service.MemoSearchService#getAll()
	 */
	@Override
	public Iterator<MemoSearch> getLastSearch() {
		return memoSearchDAO.iterator();
	}
	
	/* (non-Javadoc)
	 * @see fr.solocal.service.MemoService#getLastClics()
	 */
	@Override
	public ListMemoClic getAndRemoveLastClics() {
		return new ListMemoClic(memoClicDAO.iterateAndRemove());
	}

}
