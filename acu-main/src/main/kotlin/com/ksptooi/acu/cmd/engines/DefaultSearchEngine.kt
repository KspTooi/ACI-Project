package com.ksptooi.acu.cmd.engines

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import com.ksptooi.acu.service.engine.CmdEngineService
import com.ksptooi.acu.service.cmd.CommandService
import com.ksptooi.acu.service.cli.CliTable
import com.ksptooi.acu.service.cli.CliTableExt.print
import com.ksptooi.acu.service.cli.CliTableExt.printEngines

class DefaultSearchEngine:AcuEngine {


    @Inject
    lateinit var service: CommandService

    @Inject
    lateinit var engineService: CmdEngineService


    override fun getName(): String {
        return "d_search_engine"
    }

    override fun engineFeatures(): List<Command> {

        val list = arrayListOf(
            service.createFromTarget("list",this,"列出所有的命令列表")
            ,service.createFromTarget("engines",this,"列出所有已加载的引擎列表")
            ,service.createFromTarget("search",this,"搜索命令")
        )

        return list;
    }


    override fun invoke(cio: CommandIO,cmd:Command):Boolean {

        cmd.forTarget("list")
            ?.let {
                CliTable().print(service.getList())
                return true
            }


        cmd.forTarget("engines")
            ?.let {
                CliTable().printEngines(engineService.getEngineList())
                return true
            }


        cmd.forTarget("search")
            ?.let {

                if(cio.param.size <1){
                    throw Exception("请输入参数. ex: search>name")
                }

                CliTable().print(service.getByLikeName(cio.param[0]))

                return true
            }


        throw Exception("ACU引擎故障,未知的Target -> ${cmd.targets}")
    }

}