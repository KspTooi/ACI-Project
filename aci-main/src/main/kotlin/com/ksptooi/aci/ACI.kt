package com.ksptooi.aci

import com.google.inject.Guice
import com.ksptooi.aci.entity.Command
import com.ksptooi.aci.jpa.mapper.AdvEntityManager
import com.ksptooi.aci.module.ExportAciData
import com.ksptooi.aci.module.ExportAciMain
import com.ksptooi.aci.service.CommandService
import com.ksptooi.mapper.CommandMapper

class ACI {

}

fun main() {

    println("Auxiliary Control Interface Starting...")

    val inject = Guice.createInjector(ExportAciMain())

    val service = inject.getInstance(CommandService::class.java)

    val createCmd = service.createCmd("testCommand", "example_cmd", "用于测试的命令")

    println("主键回填值:"+createCmd.id)

}