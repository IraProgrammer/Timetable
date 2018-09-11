package com.example.irishka.timetable.di.module;

import com.example.irishka.timetable.di.scopes.PerActivity;
import com.example.irishka.timetable.ui.mainScreen.MainActivity;
import com.example.irishka.timetable.ui.mainScreen.di.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class BuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity provideMoviesActivity();
}
