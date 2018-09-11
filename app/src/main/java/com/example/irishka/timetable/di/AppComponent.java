package com.example.irishka.timetable.di;

import android.content.Context;

import com.example.irishka.timetable.App;
import com.example.irishka.timetable.di.module.BuilderModule;
import com.example.irishka.timetable.di.module.DatabaseModule;
import com.example.irishka.timetable.di.module.RepModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {DatabaseModule.class, RepModule.class, BuilderModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
        @BindsInstance
        public abstract Builder context(Context context);
    }
}