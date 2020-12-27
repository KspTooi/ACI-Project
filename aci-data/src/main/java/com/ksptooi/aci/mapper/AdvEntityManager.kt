package com.ksptooi.aci.mapper

interface AdvEntityManager<T> {

    fun <NT>setTarget(target:Class<NT>):AdvEntityManager<NT>

    fun save(obj:T):T

}