package com.ksptooi.acu.service

import com.ksptooi.acu.entity.command.CommandIO
import kotlin.jvm.Throws

interface CmdSchedulerService {

    /**
     * 异步调度命令
     */
    @Throws(Exception::class)
    fun asyncSchedule(cio:CommandIO)

    /**
     * 同步调度命令
     */
    fun schedule(cio: CommandIO):Boolean

}