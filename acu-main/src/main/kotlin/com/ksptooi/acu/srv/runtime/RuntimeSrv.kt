package com.ksptooi.acu.srv.runtime

import kotlin.jvm.Throws

//运行环境接口
interface RuntimeSrv {


    //异步运行Target
    fun runTargetAsync(target:Target)

    //运行一个可用的target
    fun runTarget(target:Target)


}