package com.ksptooi.acu.module

import com.google.inject.AbstractModule
import com.ksptooi.acu.service.CommandService
import com.ksptooi.acu.service.CommandServiceBlock
import com.ksptooi.acu.service.cli.CliService
import com.ksptooi.acu.service.cli.CliServiceBlock

class ExportAcuMain:AbstractModule() {

    override fun configure() {

        println("加载内部组件 - MainModule")
        println("模块加载 - ExportAciData()")
        println("模块加载 - ExportLogger()")
        install(ExportAciData())
        install(ExportLogger())
        install(ExportCli())

        bind(CommandService::class.java).to(CommandServiceBlock::class.java)
        bind(CliService::class.java).to(CliServiceBlock::class.java)

    }
}