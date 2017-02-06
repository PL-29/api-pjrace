package fr.solocal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author gguillemot
 */
@RestController
public class SimpleErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleErrorController.class.getName());

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private final ErrorAttributes errorAttributes;

    @Autowired
    public SimpleErrorController(final ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping
    public Map<String, Object> error(final HttpServletRequest aRequest) {
        Map<String, Object> body = getErrorAttributes(aRequest, getTraceParameter(aRequest));
        String trace = (String) body.get("trace");
        if (trace != null) {
            String[] lines = trace.split("\n\t");
            body.put("trace", lines);
        }
        logger.warn("StatusCode: \"" + body.get("status") + "\" - Path: \"" + body.get("path") + "\" - Message: \"" + body.get("message") + "\"");
        return body;
    }

    private boolean getTraceParameter(final HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(final HttpServletRequest aRequest, final boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
