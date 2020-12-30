package com.ksptooi.acu.service

interface TargetService {

    fun forName(name: String):Target

    fun forEngine(name:String):Target

    fun forFile(path:String):Target

    fun forDirectory(path: String):Target
    
}