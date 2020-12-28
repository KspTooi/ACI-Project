package com.ksptooi.acu.service

import com.ksptooi.acu.entity.command.Command

interface CommandService {

    fun createCmd(name:String,type:String,desc:String): Command

    fun getCmdByName(name: String): Command?



}