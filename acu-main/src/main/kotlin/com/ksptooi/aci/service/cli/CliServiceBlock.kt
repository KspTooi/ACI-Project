package com.ksptooi.aci.service.cli

import com.google.inject.Inject
import com.ksptooi.aci.service.CommandService
import org.slf4j.Logger

class CliServiceBlock:CliService {


    @Inject
    lateinit var service:CommandService

    @Inject
    lateinit var log:Logger



    override fun runCli() {

        log.info("启动 - 辅助控制单元命令总线")

        while (true){



        }

    }

    override fun cliInput(): String {
        TODO("Not yet implemented")
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