package com.ksptooi.acu.module

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.Singleton
import com.ksptooi.acu.ACI
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ExportLogger:AbstractModule() {

    override fun configure() {

    }

    @Provides
    @Singleton
    fun logger():Logger{
        println("加载内部组件 - LoggerModule")
        return LoggerFactory.getLogger(ACI::class.java)
    }

}