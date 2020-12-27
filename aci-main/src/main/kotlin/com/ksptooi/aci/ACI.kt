package com.ksptooi.aci

import com.google.inject.Guice
import com.ksptooi.aci.entity.Command
import com.ksptooi.aci.mapper.AdvEntityManager
import com.ksptooi.aci.module.ExportAciData

class ACI {

}

fun main() {

    println("Auxiliary Control Interface Starting...")

    val inject = Guice.createInjector(ExportAciData())

    val aem = inject.getInstance(AdvEntityManager::class.java)

    val em = aem.setTarget(Command::class.java);

    val cmd = Command()

    cmd.name = "cmd"

    em.save(cmd);

    println(aem)

}