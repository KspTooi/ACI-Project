package com.ksptooi.mapper

import com.ksptooi.aci.entity.Command

interface AbstractMapper<T> {

    fun list():List<T>

    fun insert(cmd: T): T

    fun update(cmd: T):Boolean

    fun remove(cmd: T):Boolean

}