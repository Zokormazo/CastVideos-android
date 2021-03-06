package com.codesyntax.jarrion.di.module;

import com.codesyntax.jarrion.di.scope.ActivityScope;
import com.codesyntax.jarrion.domain.interactor.EnableNotificationsInteractor;
import com.codesyntax.jarrion.domain.interactor.EnableNotificationsInteractorImpl;
import com.codesyntax.jarrion.domain.interactor.RegisterDeviceInteractor;
import com.codesyntax.jarrion.domain.interactor.RegisterDeviceInteractorImpl;
import com.codesyntax.jarrion.navigation.WebviewActivityNavigator;
import com.codesyntax.jarrion.navigation.WebviewActivityNavigatorImpl;
import com.codesyntax.jarrion.ui.main.presenter.MainPresenter;
import com.codesyntax.jarrion.ui.main.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    EnableNotificationsInteractor provideEnableNotificationsInteractor(EnableNotificationsInteractorImpl interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    RegisterDeviceInteractor provideRegisterDeviceInteractor(RegisterDeviceInteractorImpl interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    WebviewActivityNavigator pprovideWebviewActivityNavigator(WebviewActivityNavigatorImpl navigator) {
        return navigator;
    }
}
