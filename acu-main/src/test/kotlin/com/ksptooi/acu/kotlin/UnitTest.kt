package com.ksptooi.acu.kotlin

import com.google.inject.Guice
import com.google.inject.Injector
import com.ksptooi.acu.method.extends.StringExtends.getParamList
import com.ksptooi.acu.module.ExportAcuMain
import com.ksptooi.acu.service.CommandService
import com.ksptooi.mapper.CommandMapper
import org.junit.Before
import org.junit.Test
import org.slf4j.Logger

class UnitTest {

    lateinit var inject: Injector

    lateinit var service: CommandService

    lateinit var mapper : CommandMapper

    lateinit var log:Logger

    @Before
    fun init(){
        this.inject = Guice.createInjector(ExportAcuMain())
        this.service = inject.getInstance(CommandService::class.java)
        this.mapper = inject.getInstance(CommandMapper::class.java)
        this.log = inject.getInstance(Logger::class.java)
    }

    @Test
    fun t2(){

        if(service.getCmdByName("123")!=null){
            log.info("获取成功")
            return
        }

        log.error("获取失败")

    }

    @Test
    fun t3(){


        println("commandExample>aaa".getParamList())



    }



}