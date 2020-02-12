package org.jenkinsci.plugins.tuleap_api.internals.guice;

import com.google.inject.Provider;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttpClientProvider implements Provider<OkHttpClient> {

    @Override
    public OkHttpClient get() {
    return new OkHttpClient
            .Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .cache(null)
            .build();
    }
}
