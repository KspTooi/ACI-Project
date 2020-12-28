package com.ksptooi.mapper

import com.ksptooi.aci.entity.Command
import com.ksptooi.aci.jpa.mapper.AdvEntityManager
import com.ksptooi.aci.jpa.mapper.AdvEntityManagerBlock

interface CommandMapper{

    fun getCommandByName(name:String):Command

    fun exists(name:String):Boolean

}