package com.ksptooi.acu

import com.ksptooi.acu.entity.command.CommandIO
import kotlin.jvm.Throws

object StringExtends {



    /**
     * 从字符串中获取CommandIO (InputObject)
     */
    fun String.getCommandIO():CommandIO{

        val cio = CommandIO()
        cio.name = this.getCommandName()
        cio.param = this.getParamList()

        return cio
    }

    /**
     * 从当前字符串中获取到命令名
     */
    fun String.getCommandName():String{

        var cmdName = this

        try{
            cmdName = this.replace(">"+this.getParam('>'),"")
        }catch (e:Exception) {
            cmdName = this
        }

        return cmdName
    }


    /**
     * 使用默认的分隔符获取所有参数集合
     */
    fun String.getParamList():List<String>{

        var paramList:List<String>

        try {
            paramList = this.getParamList('>',',')
        }catch (e:Exception){
            paramList = ArrayList<String>()
        }

        return paramList
    }


    /**
     * 获取一个字符串中的所有参数集合
     */
    @Throws(Exception::class)
    fun String.getParamList(separator: Char,paramSeparator:Char):List<String>{

        val param = this.getParam(separator)

        val list = param.split(paramSeparator)

        if(list.size < 1){
            throw Exception("无参数")
        }

        return list
    }


    /**
     * 获取一个字符串中的所有参数字符串
     */
    @Throws(Exception::class)
    fun String.getParam(separator:Char):String{

        val indexOf = this.indexOf(separator)

        if(indexOf == -1)
            throw Exception("参数分割失败,无法找到标识符:$separator")

        val paramString = this.substring(indexOf+1,this.length)

        return paramString
    }



    /**
     * 获取某个字符在一个字符串中出现的次数
     */
    fun String.getCount(char:Char):Int{

        val chars = this.toCharArray()

        var count = 0

        for(item in chars){

            if(item.equals(char)){
                count++
            }

        }

        return count
    }




}