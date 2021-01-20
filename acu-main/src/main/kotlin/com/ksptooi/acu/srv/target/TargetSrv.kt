package com.ksptooi.acu.srv.target

import com.ksptooi.acu.entity.command.Target

interface TargetSrv {

    fun forName(name:String):Target

    fun forEngine(engine:String):Target

    fun forFile(path:String):Target

    fun forPath(path: String):Target

}