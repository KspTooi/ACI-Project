package com.ksptooi.acu.cmd.engines

import com.ksptooi.acu.entity.command.CommandIO

interface CommandEngine {

    fun getName():String

    fun invoke(cmdio:CommandIO):String

}