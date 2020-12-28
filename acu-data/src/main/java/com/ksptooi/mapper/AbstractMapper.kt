package com.ksptooi.mapper

interface AbstractMapper<T> {

    fun list():List<T>

    fun insert(cmd: T): T

    fun update(cmd: T):Boolean

    fun remove(cmd: T):Boolean

}