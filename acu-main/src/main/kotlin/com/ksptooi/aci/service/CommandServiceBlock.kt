package com.ksptooi.aci.service

import com.google.inject.Inject
import com.ksptooi.aci.entity.Command
import com.ksptooi.aci.jpa.mapper.AdvEntityManager
import com.ksptooi.mapper.CommandMapper
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*

class CommandServiceBlock @Inject constructor(aem:AdvEntityManager):CommandService {

    @Inject
    lateinit var mapper:CommandMapper

    val aem = aem;

    init {
        aem.setTarget(Command::class.java)
    }

    override fun createCmd(name: String, type: String, desc: String): Command {

        if(mapper.exists(name)){
            throw RuntimeException("创建失败,名称已存在!")
        }

        val cmd = Command()

        cmd.name = name
        cmd.type = type
        cmd.description = desc
        cmd.createTime = Date()
        cmd.updateTime = Date()
        cmd.createByAccount= - 1
        cmd.permissions = "all"
        cmd.remove = 0

        return aem.save(cmd)
    }

    override fun getCmdByName(name: String): Command? {

        try{

            return mapper.getCommandByName(name);

        }catch (e:Exception){
            e.printStackTrace()
            return null
        }
    }



}