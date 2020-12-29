package com.ksptooi.acu.service

import com.ksptooi.acu.cmd.engines.CommandEngine
import org.slf4j.Logger
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.log

class CmdEngineServiceBlock @Inject constructor(var log:Logger):CmdEngineService {

    init {
        log.info("启动 - 辅助控制单元命令引擎服务")
    }

    val registList = ArrayList<CommandEngine>()



    //注册一个命令引擎
    override fun register(cmdEnginee: CommandEngine) {

        //val hasName = registList.filter { it.getName().equals(cmdEnginee.getName(),true)}

        if(getEngine(cmdEnginee.getName()) != null){
            log.warn("引擎注册失败,该引擎名称已经在注册表中存在.")
            throw Exception("引擎注册失败,该引擎名称已经在注册表中存在.")
        }

        log.info("已注册命令引擎:${cmdEnginee.getName()}")

        registList.add(cmdEnginee)

    }

    override fun getEngine(engineName: String): CommandEngine? {

        val hasName = registList.filter { it.getName().equals(engineName,true) }

        if(hasName.size<1){
            return null
        }

        return hasName.get(0)
    }

    override fun getEngineList(): List<CommandEngine> {
        TODO("Not yet implemented")
    }


}