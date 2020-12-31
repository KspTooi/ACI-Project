package com.ksptooi.mapper

import com.google.inject.Inject
import com.ksptooi.acu.entity.command.Command
import javax.persistence.EntityManager
import javax.persistence.NoResultException

open class CommandMapperBlock:CommandMapper {

    @Inject
    lateinit var em: EntityManager


    override fun getCommandByName(name: String): Command {
        val q = em.createQuery("from Command where name=:name and remove=0")
        q.setParameter("name",name)
        return q.singleResult as Command;
    }

    override fun exists(name: String): Boolean {

        try{
            this.getCommandByName(name);
        }catch (e: NoResultException){
            return false
        }

        return true;
    }

    override fun list(): List<Command> {
        return em.createQuery("from Command where remove=0").resultList as List<Command>
    }

    override fun getLikeName(name: String): List<Command> {

        val query = em.createQuery("from Command where name like concat('%',:likename,'%')")
        query.setParameter("likename",name)

        return query.resultList as List<Command>
    }


}