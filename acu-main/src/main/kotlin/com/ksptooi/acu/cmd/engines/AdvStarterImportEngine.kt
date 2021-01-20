package com.ksptooi.acu.cmd.engines

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import com.ksptooi.acu.srv.cmd.CommandSrv
import com.ksptooi.acu.srv.engine.CmdEngineSrv
import com.ksptooi.acu.srv.target.TargetSrv


class AdvStarterImportEngine:AcuEngine {

    @Inject
    lateinit var cmdSrv:CommandSrv

    @Inject
    lateinit var targetSrv:TargetSrv

    @Inject
    lateinit var engineSrv:CmdEngineSrv

    lateinit var advStartEngine:AcuEngine

    override fun getName(): String {
        return "acu_engine_adv_starter_import"
    }

    override fun engineFeatures(): List<Command> {
        return listOf(
            cmdSrv.createFromTarget("auto",this,"根据输入的参数自动导入命令")
        )
    }

    override fun invoke(cio: CommandIO, cmd: Command): Boolean {

        advStartEngine = engineSrv.getEngine("acu_engine_adv_starter")
            ?:let {
                println("引擎故障! 需要前置引擎注册: acu_engine_adv_starter ")
                return false
            }


        cmd.forTarget("auto")?.let {

            if(cio.param.size<2){
                throw Exception("请输入参数. ex: auto>commandName,uri")
            }



            //构建命令
            val cmd = cmdSrv.create(cio.param[0],advStartEngine.getName(),"自动导入的命令")


            //构建目标点
            val target = targetSrv.forPath(cio.param[1])
            cmd.targets = listOf(target)

            cmdSrv.insertCmd(cmd)


            println("执行添加:${cio.param[0]}")
            println("执行添加:${cio.param[1]}")

        }

        println(cio)
        println("-------------->()")
        println(cmd)


        return true
    }


}