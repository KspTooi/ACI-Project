package com.ksptooi.aci.service.cli

interface CliService {

    fun runCli();

    fun cliInput():String

    fun cliHideInput():String

    fun cliMsg(msg:String)

    fun cliInfo(msg:String)

    fun cliWarn(msg:String)

    fun cliError(msg:String)

}