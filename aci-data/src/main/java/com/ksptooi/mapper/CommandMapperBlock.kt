package com.ksptooi.mapper

import com.google.inject.Inject
import com.google.inject.persist.PersistService
import com.ksptooi.aci.entity.Command
import com.ksptooi.aci.jpa.mapper.AdvEntityManager
import javax.persistence.EntityManager

open class CommandMapperBlock:CommandMapper {

    @Inject
    lateinit var em: EntityManager


    override fun getCommandByName(name: String): Command {
        val q = em.createQuery("from Command where name=:name")
        q.setParameter("name",name)
        return q.singleResult as Command;
    }


}