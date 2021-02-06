package com.ksptooi.acu.srv.target

import com.ksptooi.acu.TargetModel
import com.ksptooi.acu.entity.command.Target
import java.util.*


class TargetSrvBlock: TargetSrv {

    override fun forName(name: String): Target {
        TODO("Not yet implemented")
    }

    override fun forEngine(engine: String): Target {
        TODO("Not yet implemented")
    }

    override fun forFile(path: String): Target {
        TODO("Not yet implemented")
    }

    override fun forPath(path: String): Target {

        val target = Target()

        target.createTime = Date()
        target.remove = 0
        target.model = TargetModel.Link.va
        target.targetPoint = path

        return target
    }


}