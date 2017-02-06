/**
 *
 */
package fr.solocal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codahale.metrics.annotation.Timed;

import fr.solocal.dao.MemoClicDAO;
import fr.solocal.domain.MemoClic;
import fr.solocal.utils.FifoQueue;

/**
 * @author fchantrel
 *
 */
@Repository("memoClicDAO")
public class MemoClicDAOImpl implements MemoClicDAO {

    private final FifoQueue<MemoClic> lstMemoClic = new FifoQueue<MemoClic>(50);

    /**
     * 
     */
    public MemoClicDAOImpl() {
    }

    /* (non-Javadoc)
     * @see fr.solocal.dao.MemoClicDAO#addClic(fr.solocal.domain.MemoClic)
     */
    @Override
    public void addMemoClic(final MemoClic pMemoClic) {
        lstMemoClic.add(pMemoClic);
    }

    /* (non-Javadoc)
     * @see fr.solocal.dao.MemoClicDAO#getAll()
     */
    @Override
    @Timed(absolute = true, name = "memo_clic")
    public List<MemoClic> iterateAndRemove() {
        List<MemoClic> retour = new ArrayList<MemoClic>(lstMemoClic.size());
        while (!lstMemoClic.isEmpty()) {
            retour.add(lstMemoClic.poll());
        }

        return retour;
    }

}
