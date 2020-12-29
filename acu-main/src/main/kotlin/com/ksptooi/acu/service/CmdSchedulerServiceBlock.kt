package com.ksptooi.acu.service

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.CommandIO
import org.slf4j.Logger

class CmdSchedulerServiceBlock:CmdSchedulerService {

    @Inject
    lateinit var log: Logger

    @Inject
    lateinit var engineService: CmdEngineService

    @Inject
    lateinit var cmdService: CommandService


    override fun asyncSchedule(cio: CommandIO) {

        if(cio.name.isBlank())
            return


        log.info("ACU命令调度(ASYNC) -> ${cio}")

        //获取到数据库命令
        val dbCmd = cmdService.getCommand(cio)
            ?:throw Exception("调度执行失败,在最近的一次数据库检索中没有找到关于该命令的记录.")


        //获取到命令引擎字符串 并通过相关服务获取到命令引擎实例
        val engine = engineService.getEngine(dbCmd.engine)
            ?:throw Exception("调度执行失败,虽然该命令确实存在于数据库中,但该命令的引擎实例已经失效.")


        log.info("Target Engine Instance ->>>>> ${engine}")

        engine.invoke(cio,dbCmd)

    }

    override fun schedule(cio: CommandIO): Boolean {
        TODO("Not yet implemented")
    }




}