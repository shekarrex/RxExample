package com.rx.common.injection.module;

import com.rx.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shekar on 7/3/15.
 */

@Module
public class BaseModule {
    BaseApplication application;

    public BaseModule(BaseApplication app) {
        application = app;
    }

    @Provides
    BaseApplication provideBaseApplication() {
        return application;
    }

    @Provides
    int provideGreeting() {
        return 2;
    }
}
