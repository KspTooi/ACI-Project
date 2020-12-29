package com.ksptooi.acu.service

import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO

interface CommandService {

    fun createCmd(name:String,type:String,desc:String): Command

    fun getCommand(name: String): Command?

    fun getCommand(cio:CommandIO): Command?

}