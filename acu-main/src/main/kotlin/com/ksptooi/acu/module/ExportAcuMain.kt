package com.ksptooi.acu.module

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import com.ksptooi.acu.service.*
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

        bind(CommandService::class.java).to(CommandServiceBlock::class.java).`in`(Scopes.SINGLETON)
        bind(CliService::class.java).to(CliServiceBlock::class.java).`in`(Scopes.SINGLETON)
        bind(CmdEngineService::class.java).to(CmdEngineServiceBlock::class.java).`in`(Scopes.SINGLETON)
        bind(CmdSchedulerService::class.java).to(CmdSchedulerServiceBlock::class.java).`in`(Scopes.SINGLETON)

    }
}