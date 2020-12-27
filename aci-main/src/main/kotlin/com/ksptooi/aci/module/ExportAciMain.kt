package com.ksptooi.aci.module

import com.google.inject.AbstractModule
import com.ksptooi.aci.service.CommandService
import com.ksptooi.aci.service.CommandServiceBlock

class ExportAciMain:AbstractModule() {

    override fun configure() {

        install(ExportAciData())

        bind(CommandService::class.java).to(CommandServiceBlock::class.java)

    }
}