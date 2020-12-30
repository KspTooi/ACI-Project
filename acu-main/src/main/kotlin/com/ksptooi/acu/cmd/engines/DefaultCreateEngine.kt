package com.ksptooi.acu.cmd.engines

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import com.ksptooi.acu.service.CmdEngineService
import com.ksptooi.acu.service.CommandService
import com.ksptooi.acu.service.cli.CliService

class DefaultCreateEngine:AcuEngine {

    @Inject
    lateinit var service: CommandService


    @Inject
    lateinit var cliService: CliService

    override fun getName(): String {
        return "d_create_engine"
    }

    override fun engineFeatures(): List<Command> {
        return listOf(
            service.createFromTarget("create",this,"创建一个引擎命令")
            ,service.createFromTarget("remove",this,"移除一个引擎命令")
        )
    }


    override fun invoke(cio: CommandIO, cmd: Command): Boolean {


        cmd.forTarget("create")?.let {

            if(cio.param.size<3){
                throw Exception("请输入参数. ex: create>name,engine,target")
            }

            val cmd = service.create(cio.param[0],cio.param[1],"用户创建的命令")
            cmd.targets = arrayListOf(service.createTarget(cio.param[2]))

            service.insertCmd(cmd)
            cliService.cliBMsg("命令创建成功! -> ${cmd.name}")
        }


        cmd.forTarget("remove")?.let {

            if(cio.param.size<1){
                throw Exception("请输入参数. ex: remove>name")
            }

            service.remove(cio.param[0])

            cliService.cliBMsg("命令移除成功! -> ${cio.param[0]}")
        }


        return true
    }


}