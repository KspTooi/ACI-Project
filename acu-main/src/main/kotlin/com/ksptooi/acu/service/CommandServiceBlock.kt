package com.ksptooi.acu.service

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import com.ksptooi.acu.jpa.mapper.AdvEntityManager
import com.ksptooi.mapper.CommandMapper
import org.slf4j.Logger
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*
import kotlin.math.log

class CommandServiceBlock @Inject constructor(aem:AdvEntityManager):CommandService {

    @Inject
    lateinit var mapper:CommandMapper

    @Inject
    lateinit var log: Logger

    val aem = aem;

    init {
        aem.setTarget(Command::class.java)
    }

    override fun createCmd(name: String, engine: String, desc: String): Command {

        if(mapper.exists(name)){
            throw RuntimeException("创建失败,名称已存在!")
        }

        val cmd = Command()

        cmd.name = name
        cmd.engine = engine
        cmd.description = desc
        cmd.createTime = Date()
        cmd.updateTime = Date()
        cmd.createByAccount= - 1
        cmd.permissions = "all"
        cmd.remove = 0

        return aem.save(cmd)
    }

    override fun getCommand(name: String): Command? {

        try{

            return mapper.getCommandByName(name);

        }catch (e:Exception){
            log.debug(e.message,e)
            return null
        }
    }

    override fun getCommand(cio: CommandIO): Command? {
        return this.getCommand(cio.name)
    }


}