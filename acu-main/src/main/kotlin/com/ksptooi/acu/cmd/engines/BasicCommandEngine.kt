package com.ksptooi.acu.cmd.engines

import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO

class BasicCommandEngine:CommandEngine {


    override fun getName(): String {
        return "basic-cmd-engine"
    }


    override fun invoke(cmdio: CommandIO,cmd:Command):Boolean {

        println("基本命令引擎调用-------->Invoke")

        println("命令IO实体:${cmdio}")
        println("命令实体:${cmd}")

        println("基本命令引擎调用完成------>Invoke Success")


        return true
    }

}