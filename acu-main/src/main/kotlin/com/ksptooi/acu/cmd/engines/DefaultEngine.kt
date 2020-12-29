package com.ksptooi.acu.cmd.engines

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import org.slf4j.Logger

class DefaultEngine:CommandEngine {

    @Inject
    lateinit var log: Logger


    override fun getName(): String {
        return "default_engine"
    }


    override fun invoke(cmdio: CommandIO,cmd:Command):Boolean {

        println("基本命令引擎调用-------->Invoke")


        println("基本命令引擎调用完成------>Invoke Success")

        return true
    }

}