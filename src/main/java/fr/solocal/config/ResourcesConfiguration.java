package fr.solocal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author fchantrel
 * Classe qui gère la configuration
 *
 */
@Component
public class ResourcesConfiguration {

    /** Host de l'API Interpretation pour récuperer les rubriques. */
    @Value("${interpretation.host}")
    private String interpretationHost;

    /** Clé de l'Api algolia. */
    @Value("${algolia.api.key}")
    private String algoliaApiKey;

    public void setInterpretationHost(final String interpretationHost) {
        this.interpretationHost = interpretationHost;
    }

    public String getInterpretationHost() {
        return interpretationHost;
    }

    public void setAlgoliaApiKey(final String algoliaApiKey) {
        this.algoliaApiKey = algoliaApiKey;
    }

    public String getAlgoliaApiKey() {
        return algoliaApiKey;
    }

}
