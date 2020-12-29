package com.ksptooi.acu.service

import com.ksptooi.acu.InjectService
import com.ksptooi.acu.cmd.engines.AcuEngine
import org.slf4j.Logger
import java.lang.Exception
import javax.inject.Inject

class CmdEngineServiceBlock @Inject constructor(var log:Logger,var commandService: CommandService):CmdEngineService {



    init {
        log.info("启动 - 辅助控制单元引擎服务")
    }

    val registList = ArrayList<AcuEngine>()



    //注册一个命令引擎
    override fun register(cmdEnginee: AcuEngine) {

        //val hasName = registList.filter { it.getName().equals(cmdEnginee.getName(),true)}

        if(getEngine(cmdEnginee.getName()) != null){
            log.warn("引擎注册失败,该引擎名称已经在注册表中存在.")
            throw Exception("引擎注册失败,该引擎名称已经在注册表中存在.")
        }

        log.info("ACU引擎服务 -> 已注册引擎:${cmdEnginee.getName()}")


        //注入本地服务到引擎内部
        InjectService.get().injectMembers(cmdEnginee)


        //注册引擎的预定义Feature
        for(item in cmdEnginee.engineFeatures()){

            commandService.getCommand(item.name)
                ?:let {

                    log.info("ACU引擎服务 -> 添加引擎预定义功能:${item.name}")
                    commandService.insertCmd(item)

                }

        }

        registList.add(cmdEnginee)
    }

    override fun getEngine(engineName: String?): AcuEngine? {

        engineName?:throw Exception("引擎名称不能为空")

        val hasName = registList.filter { it.getName().equals(engineName,true) }

        if(hasName.size<1){
            return null
        }

        return hasName.get(0)
    }

    override fun getEngineList(): List<AcuEngine> {
        return this.registList
    }


}