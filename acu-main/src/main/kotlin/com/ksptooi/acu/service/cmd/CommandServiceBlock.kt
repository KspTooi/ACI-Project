package com.ksptooi.acu.service.cmd

import com.google.inject.Inject
import com.google.inject.persist.Transactional
import com.ksptooi.acu.cmd.engines.AcuEngine
import com.ksptooi.acu.entity.command.Command
import com.ksptooi.acu.entity.command.CommandIO
import com.ksptooi.acu.entity.command.Target
import com.ksptooi.acu.jpa.mapper.AdvEntityManager
import com.ksptooi.mapper.CommandMapper
import org.slf4j.Logger
import java.lang.RuntimeException
import java.util.*
import javax.persistence.EntityManager
import kotlin.Exception

open class CommandServiceBlock @Inject constructor(var aem:AdvEntityManager): CommandService {

    @Inject
    lateinit var mapper:CommandMapper

    @Inject
    lateinit var em:EntityManager

    @Inject
    lateinit var log: Logger


    init {
        aem.setTarget(Command::class.java)
    }

    override fun create(name: String, engine: String, desc: String): Command {

        val cmd = Command()

        cmd.name = name
        cmd.engine = engine
        cmd.description = desc
        cmd.createTime = Date()
        cmd.updateTime = Date()
        cmd.createByAccount= - 1
        cmd.permissions = "all"
        cmd.remove = 0

        return cmd
    }

    override fun create(name: String, engine: AcuEngine, desc: String): Command {
        return this.create(name, engine.getName(), desc)
    }


    override fun createTarget(target: String):Target {
        val t = Target()
        t.remove = 0
        t.path = "empty"
        t.file = "empty"
        t.targetPoint = target
        t.createTime = Date()
        return t
    }


    override fun createFromTarget(target: String, engine: AcuEngine, desc: String): Command {

        val cmd = this.create(target,engine,desc)

        cmd.targets = arrayListOf(createTarget(target))

        return cmd
    }


    override fun insertCmd(cmd: Command): Command {

        if(mapper.exists(cmd.name)){
            throw RuntimeException("创建失败,名称已存在!")
        }

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


    override fun getList(): List<Command> {
        return mapper.list()
    }


    override fun getByLikeName(likeName: String): List<Command> {
        return mapper.getLikeName(likeName)
    }


    @Transactional
    override fun remove(name: String) {

        if(!mapper.exists(name)){
            throw Exception("移除失败 命令不存在!")
        }

        val query = em.createQuery("update Command set remove=1 where name=:name");
        query.setParameter("name",name)
        query.executeUpdate()
    }


}