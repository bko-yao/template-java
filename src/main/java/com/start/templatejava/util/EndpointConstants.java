package com.start.templatejava.util;

/**
 * Classe de endpoints pour chaque controller.
 */
public interface EndpointConstants {

    String APP_ROOT = "/api";

    String SERVICE_ACCOUNT_ENDPOINT = APP_ROOT + "/service-account";

    /**
     * All URLs allowed to everyone.
     */
    String TEST_ENDPOINT = APP_ROOT + "/test";

    String AUTHENTICATION_ENDPOINT = APP_ROOT + "/auth";

}
