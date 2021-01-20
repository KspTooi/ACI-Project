package com.ksptooi.acu.srv.cli

import com.ksptooi.acu.cmd.engines.AcuEngine
import com.ksptooi.acu.entity.command.Command
import java.text.SimpleDateFormat
import java.util.stream.Collectors

object CliTableExt {

    //以表格的方式打印输出命令
    fun CliTable.print(cmds:List<Command>){

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val table = this;

        table.setShowVerticalLines(true)
        table.setHeaders("命令名", "最后更改时间","权限节点","Targets","描述")

        for(item in cmds){
            table.addRow(
                 item.name
                ,sdf.format(item.updateTime)
                ,item.permissions
                ,item.targets.size.toString()
                ,item.description
            )
        }

        this.print()
    }


    //以表格方式打印输出引擎
    //以表格的方式打印输出命令
    fun CliTable.printEngines(eng:List<AcuEngine>){

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val table = this;

        table.setShowVerticalLines(true)
        table.setHeaders("引擎名", "基本指令","扩展指令")

        for(item in eng){

            val list:List<String> = item.engineFeatures().stream().map { it.name }.collect(Collectors.toList());

            table.addRow(
                item.getName(),
                list.toString(),
                "*"
            )
        }

        this.print()

    }

}