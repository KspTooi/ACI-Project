package com.ksptooi.aci.module

import com.google.inject.AbstractModule
import com.ksptooi.aci.service.CommandService
import com.ksptooi.aci.service.CommandServiceBlock

class ExportAciMain:AbstractModule() {

    override fun configure() {

        println("加载内部组件 - MainModule")
        println("模块加载 - ExportAciData()")
        println("模块加载 - ExportLogger()")
        install(ExportAciData())
        install(ExportLogger())

        bind(CommandService::class.java).to(CommandServiceBlock::class.java)

    }
}