package com.ksptooi.aci.kotlin

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import com.ksptooi.aci.module.ExportAciMain
import com.ksptooi.aci.service.CommandService
import com.ksptooi.mapper.CommandMapper
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class UnitTest {

    lateinit var inject: Injector

    lateinit var service: CommandService

    lateinit var mapper : CommandMapper

    @Before
    fun init(){
        this.inject = Guice.createInjector(ExportAciMain())
        this.service = inject.getInstance(CommandService::class.java)
        this.mapper = inject.getInstance(CommandMapper::class.java)
    }

    @Test
    fun t1(){

        if(service.getCmdByName("123")!=null){
            println("获取成功")
            return
        }

        println("获取失败")

    }

}