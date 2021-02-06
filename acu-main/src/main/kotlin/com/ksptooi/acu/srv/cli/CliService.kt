package com.ksptooi.acu.srv.cli

interface CliService {

    fun runCli();

    fun cliInput():String

    fun cliHideInput():String

    fun cliConfirm():Boolean

    fun cliConfirm(msg:String):Boolean

    fun cliPMsg()

    fun cliMsg(msg:String)

    fun cliBMsg(msg: String)


}