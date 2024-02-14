package com.etiqa.assessment.config;

import static com.etiqa.assessment.config.Constants.Global.UTILITY_CLASS;

public final class Constants {
    private Constants() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    /**
     * HTTP related constants.
     */
    public static final class HttpCodes {
        public static final int HTTP_200_CODE = 200;
        public static final int HTTP_400_CODE = 400;
        public static final String HTTP_400_MESSAGE = "Bad Request";
        public static final int HTTP_401_CODE = 401;
        public static final String HTTP_401_MESSAGE = "Unauthorized request";
        public static final int HTTP_403_CODE = 403;
        public static final String HTTP_403_MESSAGE = "Access Denied for the Service";
        public static final int HTTP_404_CODE = 404;
        public static final String HTTP_404_MESSAGE = "Resource Not Found";
        public static final int HTTP_429_CODE = 429;
        public static final String HTTP_429_MESSAGE = "Rate limiting - user has sent too many requests in a given amount of time";
        public static final int HTTP_500_CODE = 500;
        public static final String HTTP_500_MESSAGE = "Internal Server Errors";
        public static final String HTTP_200_OK_MESSAGE = "OK";

        private HttpCodes() {
            throw new IllegalStateException(UTILITY_CLASS);
        }
    }

    /**
     * Global constants.
     */
    public static final class Global {
        public static final String UID_HEADER_NAME = "UID";
        public static final String UTILITY_CLASS = "Utility class";

        private Global() {
            throw new IllegalStateException(UTILITY_CLASS);
        }
    }

    /**
     * Dummy database table column names and JSON mappings.
     */
    public static final class BaseEntityConstants {
        public static final String CREATED_TS = "insert_ts";
        public static final String MODIFIED_TS = "modified_ts";
        public static final String MODIFIED_BY = "modified_by";
        public static final String CREATED_BY = "created_by";

        private BaseEntityConstants() {
            throw new IllegalStateException(UTILITY_CLASS);
        }
    }
}
