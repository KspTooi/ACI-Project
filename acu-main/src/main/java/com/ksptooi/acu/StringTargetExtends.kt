package com.ksptooi.acu

import com.ksptooi.acu.cmd.engines.AcuEngine
import com.ksptooi.acu.entity.command.Target
import java.util.*
import kotlin.jvm.Throws

object StringTargetExtends {

    /**
     * 将字符串转换为Target
     */
    fun String.getTarget():Target{

        val model = this.getTargetModel().va

        val t = Target()
        t.model = model
        t.remove = 0
        t.targetPoint = this.replace("$model:","")
        t.createTime = Date()

        return t
    }

    /**
     * 将字符串转换为Target
     */
    fun String.getTarget(engine:AcuEngine):Target{

        val t = Target()
        t.model = TargetModel.Engine.va
        t.remove = 0
        t.targetPoint = this
        t.createTime = Date()

        return t
    }



    /**
     * 从字符串头信息获取到TargetModel
     */
    @Throws(Exception::class)
    fun String.getTargetModel():TargetModel{

        //找第一个分隔符
        val separateIndex = this.indexOf(':',0)

        if (separateIndex == -1){
            throw Exception("未找到这样的TargetModel")
        }

        //截取第一个分隔符之前所有内容
        val modelString = this.substring(0,separateIndex)

        for (item in TargetModel.values()){

            if (item.model == modelString)
                return item

        }

        throw Exception("未找到这样的TargetModel")
    }


}