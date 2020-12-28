package com.ksptooi.acu

import com.google.inject.Guice
import com.ksptooi.acu.module.ExportAcuMain
import com.ksptooi.acu.service.cli.CliService

class ACI {

}

fun main() {

    println("Auxiliary Control Unit Starting...")
    println("[辅助控制单元] - 初始化...")

    val inject = Guice.createInjector(ExportAcuMain())

    val cli = inject.getInstance(CliService::class.java)

    cli.runCli()
/*    val service = inject.getInstance(CommandService::class.java)

    val createCmd = service.createCmd("testCommand", "example_cmd", "用于测试的命令")

    println("主键回填值:"+createCmd.id)*/

}

