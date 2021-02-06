package com.ksptooi.acu.module

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import com.ksptooi.acu.srv.cli.CliService
import com.ksptooi.acu.srv.cli.CliServiceBlock
import com.ksptooi.acu.srv.cmd.CmdSchedulerSrv
import com.ksptooi.acu.srv.cmd.CmdSchedulerSrvBlock
import com.ksptooi.acu.srv.cmd.CommandSrv
import com.ksptooi.acu.srv.cmd.CommandSrvBlock
import com.ksptooi.acu.srv.engine.CmdEngineSrv
import com.ksptooi.acu.srv.engine.CmdEngineSrvBlock
import com.ksptooi.acu.srv.runtime.RuntimeSrv
import com.ksptooi.acu.srv.runtime.RuntimeSrvBlock
import com.ksptooi.acu.srv.target.TargetSrv
import com.ksptooi.acu.srv.target.TargetSrvBlock

class ExportAcuMain:AbstractModule() {

    override fun configure() {

        println("加载内部组件 - MainModule")
        println("模块加载 - ExportAciData()")
        println("模块加载 - ExportLogger()")
        install(ExportAciData())
        install(ExportLogger())
        install(ExportCli())

        bind(CommandSrv::class.java).to(CommandSrvBlock::class.java).`in`(Scopes.SINGLETON)
        bind(CliService::class.java).to(CliServiceBlock::class.java).`in`(Scopes.SINGLETON)
        bind(CmdEngineSrv::class.java).to(CmdEngineSrvBlock::class.java).`in`(Scopes.SINGLETON)
        bind(CmdSchedulerSrv::class.java).to(CmdSchedulerSrvBlock::class.java).`in`(Scopes.SINGLETON)
        bind(TargetSrv::class.java).to(TargetSrvBlock::class.java).`in`(Scopes.SINGLETON)
        bind(RuntimeSrv::class.java).to(RuntimeSrvBlock::class.java).`in`(Scopes.SINGLETON)
    }
}