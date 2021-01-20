package com.ksptooi.acu.srv.cmd

import com.ksptooi.acu.cmd.engines.AcuEngine
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import com.ksptooi.acu.entity.command.Target
import kotlin.jvm.Throws

interface CommandSrv {

    fun create(name:String,engine:String,desc:String): Command

    fun create(name:String, engine:AcuEngine, desc:String): Command

    fun createFromTarget(target:String, engine:AcuEngine, desc:String): Command

    fun insertCmd(cmd:Command):Command;

    fun getCommand(name: String): Command?

    fun getCommand(cio:CommandIO): Command?

    fun getList():List<Command>

    fun getByLikeName(likeName:String):List<Command>

    @Throws(Exception::class)
    fun remove(name: String)

}