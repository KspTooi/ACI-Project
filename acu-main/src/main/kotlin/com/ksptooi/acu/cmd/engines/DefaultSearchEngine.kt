package com.ksptooi.acu.cmd.engines

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.cli.CommandInput
import com.ksptooi.acu.srv.engine.CmdEngineSrv
import com.ksptooi.acu.srv.cmd.CommandSrv
import com.ksptooi.acu.srv.cli.CliTable
import com.ksptooi.acu.srv.cli.CliTableExt.print
import com.ksptooi.acu.srv.cli.CliTableExt.printEngines

class DefaultSearchEngine:AcuEngine {


    @Inject
    lateinit var service: CommandSrv

    @Inject
    lateinit var engineService: CmdEngineSrv


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


    override fun invoke(cio: CommandInput, cmd:Command):Boolean {

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