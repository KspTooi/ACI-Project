package com.ksptooi.acu.service.cli

interface CliService {

    fun runCli();

    fun cliInput():String

    fun cliHideInput():String

    fun cliConfirm():Boolean

    fun cliConfirm(msg:String):Boolean

    fun cliMsg(msg:String)

    fun cliInfo(msg:String)

    fun cliWarn(msg:String)

    fun cliError(msg:String)

}