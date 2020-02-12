package org.jenkinsci.plugins.tuleap_api;

import com.google.inject.Singleton;
import okhttp3.OkHttpClient;
import org.jenkinsci.plugins.tuleap_api.AccessKeyApi;
import org.jenkinsci.plugins.tuleap_api.TuleapApiClient;
import org.jenkinsci.plugins.tuleap_api.internals.guice.OkHttpClientProvider;

public class TuleapApiGuiceModule extends com.google.inject.AbstractModule {
    @Override
    protected void configure() {
        bind(OkHttpClient.class).toProvider(OkHttpClientProvider.class).asEagerSingleton();
        bind(AccessKeyApi.class).to(TuleapApiClient.class);
    }
}
