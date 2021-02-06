package com.ksptooi.acu.srv.cmd

import com.ksptooi.acu.entity.cli.CommandInput
import kotlin.jvm.Throws

interface CmdSchedulerSrv {

    /**
     * 异步调度命令
     */
    @Throws(Exception::class)
    fun asyncSchedule(cio: CommandInput)

    /**
     * 同步调度命令
     */
    fun schedule(cio: CommandInput):Boolean

}