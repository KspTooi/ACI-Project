package com.ksptooi.acu.jpa.mapper

import com.google.inject.Inject
import com.google.inject.persist.PersistService
import com.google.inject.persist.Transactional
import java.lang.Exception
import javax.persistence.EntityManager

open class AdvEntityManagerBlock @Inject constructor(persistService: PersistService?): AdvEntityManager {

    @Inject
    open lateinit var em: EntityManager

    lateinit var target: Class<*>

    init {
        persistService?.start()
    }



    override fun <T> setTarget(target: Class<T>): AdvEntityManager {
        this.target = target
        return this
    }

    @Transactional(rollbackOn = [Exception::class])
    override fun <T> save(obj: T): T {
        return em.merge(obj)
    }

    override fun <T> getByPK(primaryKey: Int): T {
        return em.find(this.target,primaryKey) as T
    }

    override fun <T> getList(): List<T> {
        val ret = em.createQuery("from "+this.target.simpleName)
        return ret.resultList as List<T>
    }

    override fun <T> getList(jpql: String): List<T> {
        val ret = em.createQuery(jpql)
        return ret.resultList as List<T>
    }


}