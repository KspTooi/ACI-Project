package com.ksptooi.aci.module

import com.google.inject.AbstractModule
import com.google.inject.persist.PersistModule
import com.google.inject.persist.jpa.JpaPersistModule
import com.ksptooi.aci.mapper.AdvEntityManager
import com.ksptooi.aci.mapper.AdvEntityManagerBlock

open class ExportAciData:AbstractModule() {


    override fun configure() {

        install( JpaPersistModule("asca_data"));

        bind(AdvEntityManager::class.java).to(AdvEntityManagerBlock::class.java)

    }


}