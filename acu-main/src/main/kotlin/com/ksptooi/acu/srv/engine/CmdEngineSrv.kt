package com.ksptooi.acu.srv.engine

import com.ksptooi.acu.cmd.engines.AcuEngine
import kotlin.jvm.Throws

/**
 * 提供命令引擎的注册,发现与调用
 */
interface CmdEngineSrv {


    /**
     * 注册一个命令引擎
     *
     * 在命令引擎名称重复时将会抛出Exception
     */
    @Throws(Exception::class)
    fun register(cmdEnginee:AcuEngine)


    /**
     * 根据名称查找到一个命令引擎实体
     */
    fun getEngine(engineName:String?):AcuEngine?


    /**
     * 返回所有已注册命令引擎的实例
     */
    fun getEngineList():List<AcuEngine>


}