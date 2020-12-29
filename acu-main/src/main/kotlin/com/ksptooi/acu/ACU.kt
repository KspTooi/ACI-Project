package com.ksptooi.acu

import com.google.inject.Guice
import com.ksptooi.acu.module.ExportAcuMain
import com.ksptooi.acu.service.cli.CliService
import org.slf4j.Logger

class ACU {

}

fun main() {

    println("Auxiliary Control Unit Starting...")
    println("[辅助控制单元] - 初始化...")

    val inject = Guice.createInjector(ExportAcuMain())

    val log = inject.getInstance(Logger::class.java)

    val cli = inject.getInstance(CliService::class.java)

    log.info("启动 - 辅助控制单元访问接口")
    cli.runCli()
    cli.cliInfo("")

}

