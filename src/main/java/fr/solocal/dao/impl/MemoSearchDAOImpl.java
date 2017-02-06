/**
 *
 */
package fr.solocal.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codahale.metrics.annotation.Timed;

import fr.solocal.dao.MemoSearchDAO;
import fr.solocal.domain.MemoSearch;
import fr.solocal.domain.MemoSearchElement;
import fr.solocal.utils.FifoQueue;

/**
 * @author fchantrel
 *
 */
@Repository("memoSearchDAO")
public class MemoSearchDAOImpl implements MemoSearchDAO {

    private final FifoQueue<MemoSearch> lstMemoSearch = new FifoQueue<MemoSearch>(50);

    /**
     * 
     */
    public MemoSearchDAOImpl() {
    	MemoSearch current = new MemoSearch();
    	current.setOu("ou 1");
    	current.setQuoi("quoi 1");
    	current.setPartenaire("partenaire 1");
    	MemoSearchElement elem = new MemoSearchElement();
    	elem.setIdEPJ("id epj1");
    	elem.setDenomination("denomination 1");
    	List<MemoSearchElement> liste1 = new ArrayList<MemoSearchElement>();
    	liste1.add(elem);
    	
    	current.setLstMemoSearchElement(liste1);
    	lstMemoSearch.add(new MemoSearch());
    }

    /* (non-Javadoc)
     * @see fr.solocal.dao.MemoSearchDAO#addSearch(fr.solocal.domain.MemoSearch)
     */
    @Override
    public void addMemoSearch(final MemoSearch pMemoSearch) {
        lstMemoSearch.add(pMemoSearch);
    }

    /* (non-Javadoc)
     * @see fr.solocal.dao.MemoSearchDAO#getAll()
     */
    @Override
    @Timed(absolute = true, name = "memo_search")
    public Iterator<MemoSearch> iterator() {
        return lstMemoSearch.iterator();
    }

}
