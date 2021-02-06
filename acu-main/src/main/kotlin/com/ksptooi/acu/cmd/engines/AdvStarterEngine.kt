package com.ksptooi.acu.cmd.engines

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.cli.CommandInput
import com.ksptooi.acu.srv.cli.CliService
import com.ksptooi.acu.srv.cmd.CommandSrv

class AdvStarterEngine:AcuEngine {

    @Inject
    lateinit var service: CommandSrv

    @Inject
    lateinit var cliService: CliService


    override fun getName(): String {
        return "acu_engine_adv_starter"
    }


    //引擎默认功能
    override fun engineFeatures(): List<Command> {
        return listOf()
    }

    override fun invoke(cio: CommandInput, cmd: Command): Boolean {
        TODO("Not yet implemented")
    }




}