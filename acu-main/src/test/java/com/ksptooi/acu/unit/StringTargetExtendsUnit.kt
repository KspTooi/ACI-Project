package com.ksptooi.acu.unit

import com.ksptooi.acu.StringTargetExtends.getTarget
import com.ksptooi.acu.StringTargetExtends.getTargetModel
import com.ksptooi.acu.cmd.engines.DefaultCreateEngine
import org.junit.Test

class StringTargetExtendsUnit {


    @Test
    fun t1(){

        val modelString = "direc1tory:C://aa.txt"

        println(modelString.getTargetModel().model)

    }

    @Test
    fun t2(){

        val target = "list"

        println(target.getTarget(DefaultCreateEngine()).toString())

    }




}