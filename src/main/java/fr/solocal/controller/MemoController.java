package fr.solocal.controller;

import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solocal.domain.ListMemoClic;
import fr.solocal.domain.MemoSearch;
import fr.solocal.service.MemoService;

/**
 * Historique des dernières recherches
 *
 * @author fchantrel
 *
 */
@RestController("MemoSearchController")
@RequestMapping(value = "/memo")
public class MemoController extends ExceptionController {

    @Inject
    private MemoService memoService;

    @RequestMapping(value = "search", method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterator<MemoSearch> getLastSearch() {
        Iterator<MemoSearch> lstMemoSearch = memoService.getLastSearch();
        
        return lstMemoSearch;
    }
    
    @RequestMapping(value = "clics", method = RequestMethod.GET, headers = "Accept=application/json")
    public ListMemoClic getLastClics() {
        ListMemoClic lstMemoClic = memoService.getAndRemoveLastClics();
        
        return lstMemoClic;
    }
}
