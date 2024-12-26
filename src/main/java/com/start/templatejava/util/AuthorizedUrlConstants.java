package com.start.templatejava.util;

import static com.start.templatejava.util.EndpointConstants.*;

/**
 * Classe pour toutes les urls à autorisées par defaut.
 */
public interface AuthorizedUrlConstants {
    String AUTHENTICATION_ALL = AUTHENTICATION_ENDPOINT + "/**";
    String TEST_ALL = TEST_ENDPOINT + "/**";
    String V3_API_DOCS_ALL = "/v3/api-docs/**";
    String SWAGGER_UI_ALL = "/swagger-ui/**";
    String SWAGGER_UI_HTML_ONLY = "/swagger-ui.html";
    String EXTERNAL_URL = "http://localhost:4200";
}
