package com.ksptooi.acu.method.extends

import kotlin.jvm.Throws

object StringExtends {


    /**
     * 使用默认的分隔符获取所有参数集合
     */
    @Throws(Exception::class)
    fun String.getParamList():List<String>{
        return this.getParamList('>',',')
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