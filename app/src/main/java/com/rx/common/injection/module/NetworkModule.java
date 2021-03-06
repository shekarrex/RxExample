package com.rx.common.injection.module;

import com.rx.guide.network.datamanager.CategoryAPI;
import com.rx.guide.network.model.ExampleModel;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by Shekar on 7/4/15.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint("http://api-v2.hearthis.at");
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint) {
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    @Provides
    @Singleton
    CategoryAPI provideCategoryAPI(RestAdapter restAdapter) {
        return restAdapter.create(CategoryAPI.class);
    }

    @Provides
    @Singleton
    Observable<List<ExampleModel>> getCategorys(CategoryAPI categoryAPIService) {
        return categoryAPIService.getCategorys();
    }
}
