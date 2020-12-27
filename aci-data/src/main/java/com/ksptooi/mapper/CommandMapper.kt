package com.ksptooi.mapper

import com.ksptooi.aci.entity.Command

interface CommandMapper {

    fun getCommandByName(name:String):Command

}