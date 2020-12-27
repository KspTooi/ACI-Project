package com.ksptooi.aci.mapper

import com.google.inject.Inject
import com.google.inject.persist.PersistService
import com.google.inject.persist.Transactional
import java.lang.Exception
import javax.persistence.EntityManager

open class AdvEntityManagerBlock<T> @Inject constructor(persistService: PersistService):AdvEntityManager<T> {

    init {
        persistService.start()
    }

    @Inject
    lateinit var em: EntityManager

    lateinit var target:Class<*>


    override fun <NT> setTarget(target: Class<NT>): AdvEntityManager<NT> {
        this.target = target
        return this as AdvEntityManager<NT>
    }

    @Transactional(rollbackOn = [Exception::class])
    override fun save(obj: T): T {
        return em.merge(obj)
    }


}