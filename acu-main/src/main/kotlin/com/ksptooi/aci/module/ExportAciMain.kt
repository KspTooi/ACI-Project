package com.ksptooi.aci.module

import com.google.inject.AbstractModule
import com.ksptooi.aci.service.CommandService
import com.ksptooi.aci.service.CommandServiceBlock
import com.ksptooi.aci.service.cli.CliService
import com.ksptooi.aci.service.cli.CliServiceBlock

class ExportAciMain:AbstractModule() {

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