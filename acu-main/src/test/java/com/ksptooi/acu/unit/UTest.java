package com.ksptooi.acu.unit;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UTest {

    @Test
    public void t1() {


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = new ArrayList<Integer>();



        for(int i=0;i<6;i++){
            System.out.printf("请输入第%s个数%n", i+1);
            numbers.add(Integer.valueOf(br.readLine()));
        }

        System.out.println("输入查找数:");
        int equals = Integer.parseInt(br.readLine());

        System.out.println(numbers);

        for(int i=0;i<numbers.size();i++){

            if(numbers.get(i) == equals){
                System.out.printf("位于下标:%s%n", i);
                return;
            }

        }



    }

}
