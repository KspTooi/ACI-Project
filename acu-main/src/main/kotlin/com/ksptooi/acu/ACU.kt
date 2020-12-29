package com.ksptooi.acu

import com.ksptooi.acu.cmd.engines.DefaultEngine
import com.ksptooi.acu.service.CmdEngineService
import com.ksptooi.acu.service.cli.CliService
import org.slf4j.Logger

class ACU {

}

fun main() {

    println("Auxiliary Control Unit Starting...")
    println("[辅助控制单元] - 初始化...")


    val inject = InjectService.get()

    val log = inject.getInstance(Logger::class.java)

    val cli = inject.getInstance(CliService::class.java)

    inject.getInstance(CmdEngineService::class.java).register(DefaultEngine())


    log.info("启动 - 辅助控制单元访问接口")

    cli.runCli()

}

