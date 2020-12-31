package com.ksptooi.acu.service.cli

import com.google.inject.Inject
import com.ksptooi.acu.StringCommandsExtends.getCommandIO
import com.ksptooi.acu.service.cmd.CmdSchedulerService
import com.ksptooi.acu.service.cmd.CommandService
import org.slf4j.Logger
import java.io.BufferedReader

class CliServiceBlock:CliService {


    @Inject
    lateinit var service: CommandService

    @Inject
    lateinit var log:Logger

    @Inject
    lateinit var cmdScheduler: CmdSchedulerService

    @Inject
    lateinit var br:BufferedReader

    var prefix = "ACU:"


    override fun runCli() {

        log.info("启动 - 辅助控制单元命令总线")

        var inputText = "";

        while (true){

            val cio = cliInput().getCommandIO()

            try{
                cmdScheduler.asyncSchedule(cio)
            }catch (e:Exception){
                log.error(e.message)
            }


        }

    }

    override fun cliInput(): String {
        cliPMsg()
        val i = br.readLine()
        return i;
    }

    override fun cliHideInput(): String {
        TODO("Not yet implemented")
    }


    override fun cliConfirm(): Boolean {
        return this.cliConfirm("此操作需要用户确认 y/n ?")
    }


    override fun cliConfirm(msg: String): Boolean {

        cliMsg(msg)

        val i = br.readLine();

        if(i == "y"){
            return true
        }

        return false;
    }


    override fun cliPMsg() {
        print(prefix)
    }


    override fun cliMsg(msg: String) {
        print(prefix+msg)
    }

    override fun cliBMsg(msg: String) {
        println(msg)
    }


}