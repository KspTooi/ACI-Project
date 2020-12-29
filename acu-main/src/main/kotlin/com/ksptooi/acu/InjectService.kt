package com.ksptooi.acu

import com.google.inject.Guice
import com.google.inject.Injector
import com.ksptooi.acu.module.ExportAcuMain

object InjectService {


    private var inject:Injector = Guice.createInjector(ExportAcuMain())


    fun get():Injector{
        return inject
    }


}