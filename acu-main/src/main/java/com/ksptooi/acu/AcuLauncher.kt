package com.ksptooi.acu

import com.ksptooi.acu.cmd.engines.AdvStarterEngine
import com.ksptooi.acu.cmd.engines.AdvStarterImportEngine
import com.ksptooi.acu.cmd.engines.DefaultCreateEngine
import com.ksptooi.acu.cmd.engines.DefaultSearchEngine
import com.ksptooi.acu.srv.engine.CmdEngineSrv
import com.ksptooi.acu.srv.cli.CliService
import com.ksptooi.acu.srv.cli.CliTable
import org.slf4j.Logger
import java.text.SimpleDateFormat
import java.util.*

class ACU {

}


fun main() {

    println("Auxiliary Control Unit Starting...")
    println("[辅助控制单元] - 初始化...")

    val inject = InjectService.get()

    val log = inject.getInstance(Logger::class.java)

    val cli = inject.getInstance(CliService::class.java)

    val engineSrv = inject.getInstance(CmdEngineSrv::class.java)

    val ct = CliTable()

    engineSrv.register(DefaultSearchEngine())
    engineSrv.register(DefaultCreateEngine())
    engineSrv.register(AdvStarterEngine())
    engineSrv.register(AdvStarterImportEngine())


    log.info("启动 - 辅助控制单元访问接口")

    log.info("当前版本:${AcuSystem.version}")
    log.info("ACU-System Done:${SimpleDateFormat("yyyy-MM-dd").format(Date())}")

    cli.runCli()
}