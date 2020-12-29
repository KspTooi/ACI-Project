package com.ksptooi.acu.service.cli

import com.google.inject.Inject
import com.ksptooi.acu.StringExtends.getCommandIO
import com.ksptooi.acu.service.CmdSchedulerService
import com.ksptooi.acu.service.CommandService
import org.slf4j.Logger
import java.io.BufferedReader

class CliServiceBlock:CliService {


    @Inject
    lateinit var service:CommandService

    @Inject
    lateinit var log:Logger

    @Inject
    lateinit var cmdScheduler: CmdSchedulerService

    @Inject
    lateinit var br:BufferedReader


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
        print("ACU:")
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

        print(msg)

        val i = br.readLine();

        if(i == "y"){
            return true
        }

        return false;
    }




    override fun cliMsg(msg: String) {
        TODO("Not yet implemented")
    }

    override fun cliInfo(msg: String) {
        TODO("Not yet implemented")
    }

    override fun cliWarn(msg: String) {
        TODO("Not yet implemented")
    }

    override fun cliError(msg: String) {
        TODO("Not yet implemented")
    }


}