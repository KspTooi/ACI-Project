package com.ksptooi.acu.service

interface TargetService {

    fun forEngine(name:String):Target

    fun forFile(path:String):Target


}