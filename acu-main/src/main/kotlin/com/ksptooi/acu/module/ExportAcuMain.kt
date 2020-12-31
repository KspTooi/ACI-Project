package com.ksptooi.acu.module

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import com.ksptooi.acu.service.cli.CliService
import com.ksptooi.acu.service.cli.CliServiceBlock
import com.ksptooi.acu.service.cmd.CmdSchedulerService
import com.ksptooi.acu.service.cmd.CmdSchedulerServiceBlock
import com.ksptooi.acu.service.cmd.CommandService
import com.ksptooi.acu.service.cmd.CommandServiceBlock
import com.ksptooi.acu.service.engine.CmdEngineService
import com.ksptooi.acu.service.engine.CmdEngineServiceBlock
import com.ksptooi.acu.service.target.TargetService
import com.ksptooi.acu.service.target.TargetServiceBlock

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
        bind(TargetService::class.java).to(TargetServiceBlock::class.java).`in`(Scopes.SINGLETON)
    }
}