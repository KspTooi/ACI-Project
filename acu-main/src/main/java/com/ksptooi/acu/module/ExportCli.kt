package com.ksptooi.acu.module

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.Singleton
import java.io.BufferedReader
import java.io.InputStreamReader

class ExportCli:AbstractModule() {


    override fun configure() {
    }

    @Provides
    @Singleton
    fun consoleInput(): BufferedReader {
        return BufferedReader(InputStreamReader(System.`in`));
    }

}