package com.ksptooi.acu.service.target

interface TargetService {

    fun forName(name:String):Target

    fun forEngine(engine:String):Target

    fun forFile(path:String):Target

    fun forPath(path: String):Target


}