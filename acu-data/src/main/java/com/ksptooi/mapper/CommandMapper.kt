package com.ksptooi.mapper

import com.ksptooi.acu.entity.command.Command

interface CommandMapper{

    fun getCommandByName(name:String): Command

    fun exists(name:String):Boolean

}