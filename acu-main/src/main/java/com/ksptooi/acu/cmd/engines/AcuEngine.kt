package com.ksptooi.acu.cmd.engines

import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.cli.CommandInput

interface AcuEngine {


    //引擎注册名称
    fun getName():String

    //引擎默认功能
    fun engineFeatures():List<Command>

    //引擎命令切入点
    fun invoke(cio: CommandInput, cmd:Command):Boolean

}