package org.jenkinsci.plugins.tuleap_api;

import com.google.inject.internal.asm.$ClassWriter;

import java.util.List;

public interface AccessKeyApi {
    public static String ACCESS_KEY_API = "/access_keys";
    public static String SELF_ID = "/self";

    Boolean checkAccessKeyIsValid(String accessKey);

    List<String> getAccessKeyScopes(String accessKey);
}
