package com.ksptooi.acu.service.cli

import com.google.inject.Inject
import com.ksptooi.acu.method.extends.StringExtends.getCommandIO
import com.ksptooi.acu.service.CommandService
import org.slf4j.Logger
import java.io.BufferedReader

class CliServiceBlock:CliService {


    @Inject
    lateinit var service:CommandService

    @Inject
    lateinit var log:Logger

    @Inject
    lateinit var br:BufferedReader


    override fun runCli() {

        log.info("启动 - 辅助控制单元命令总线")

        var inputText = "";

        while (true){
            inputText = cliInput()
            println(inputText.getCommandIO())
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