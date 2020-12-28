package com.ksptooi.acu.jpa.mapper

interface AdvEntityManager {

    fun <T>setTarget(target:Class<T>): AdvEntityManager

    fun <T> save(obj:T):T

    fun <T> getByPK(primaryKey:Int):T;

    fun <T> getList():List<T>

    fun <T> getList(jpql:String):List<T>

}