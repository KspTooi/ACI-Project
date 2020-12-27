package com.ksptooi.aci.mapper

interface AdvEntityManager<T> {

    fun <NT>setTarget(target:Class<NT>):AdvEntityManager<NT>

    fun save(obj:T):T

    fun getByPK(primaryKey:Int):T;

    fun getList():List<T>

    fun getList(jpql:String):List<T>

}