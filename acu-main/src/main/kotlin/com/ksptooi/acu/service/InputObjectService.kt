package com.ksptooi.acu.service

import com.ksptooi.acu.entity.command.CommandIO
import kotlin.jvm.Throws

interface InputObjectService {

    @Throws(Exception::class)
    fun forCommandIO(cmd:String):CommandIO;


    @Throws(Exception::class)
    fun forParam(cmd: String):List<String>


    fun hasParam(cmd: String):Boolean

}