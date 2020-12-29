package com.ksptooi.acu.cmd.engines

import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO

interface CommandEngine {


    fun getName():String


    fun invoke(cmdio:CommandIO,cmd:Command):Boolean


}