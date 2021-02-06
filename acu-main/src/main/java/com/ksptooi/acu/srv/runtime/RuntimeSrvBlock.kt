package com.ksptooi.acu.srv.runtime

import com.ksptooi.acu.TargetModel
import com.ksptooi.acu.entity.command.Target
import java.lang.RuntimeException

//运行环境服务类 Block 1
class RuntimeSrvBlock:RuntimeSrv{


    val runString = "explorer /e,"

    override fun runTargetAsync(target: Target) {
        TODO("Not yet implemented")
    }


    override fun runTarget(target: Target) {

        //判断当前target指向model是否为link
        if(target.model != TargetModel.Link.va){
            throw RuntimeException("TargetModel错误,${target.model}类型与期待的不符!")
        }
        

        //执行命令
        Runtime.getRuntime().exec("${runString}${target.targetPoint}")

    }


}