package com.ksptooi.aci.module

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
    fun consoleInput():BufferedReader{
        val br = BufferedReader(InputStreamReader(System.`in`))
        return br;
    }

}