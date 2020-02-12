package org.jenkinsci.plugins.tuleap_api;

import com.google.inject.Inject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jenkinsci.plugins.tuleap_git_branch_source.config.TuleapConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TuleapApiClient implements TuleapAuthorization, AccessKeyApi {
    private static final Logger LOGGER = Logger.getLogger(TuleapApiClient.class.getName());

    private OkHttpClient client;

    private TuleapConfiguration tuleapConfiguration;

    @Inject
    public TuleapApiClient(TuleapConfiguration tuleapConfiguration, OkHttpClient client) {
        this.tuleapConfiguration = tuleapConfiguration;
        this.client = client;
    }

    @Override
    public Boolean checkAccessKeyIsValid(String accessKey) {
        Request request = new Request.Builder()
            .url(tuleapConfiguration.getApiBaseUrl() + this.ACCESS_KEY_API + this.SELF_ID)
            .header(this.AUTHORIZATION_HEADER, accessKey)
            .get()
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.code() == 200;
        } catch (IOException exception) {
            return false;
        }
    }

    @Override
    public List<String> getAccessKeyScopes(String accessKey) {
//        Request request = new Request.Builder()
//            .url(tuleapConfiguration.getApiBaseUrl() + this.ACCESS_KEY_API + this.SELF_ID)
//            .header(this.AUTHORIZATION_HEADER, accessKey)
//            .get()
//            .build();
//
//        try (Response response = client.newCall(request).execute()) {
//        } catch (IOException exception) {
//        }
        return null;
    }
}
