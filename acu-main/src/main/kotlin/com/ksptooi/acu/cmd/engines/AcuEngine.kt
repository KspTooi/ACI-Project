package com.ksptooi.acu.cmd.engines

import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO

interface AcuEngine {


    fun getName():String

    fun engineFeatures():List<Command>

    fun invoke(cio:CommandIO,cmd:Command):Boolean


}