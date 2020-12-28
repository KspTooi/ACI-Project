package com.ksptooi.aci.service

import com.ksptooi.aci.entity.Command

interface CommandService {

    fun createCmd(name:String,type:String,desc:String):Command

    fun getCmdByName(name: String):Command?


}