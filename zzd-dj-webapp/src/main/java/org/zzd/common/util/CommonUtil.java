package org.zzd.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonUtil {
	 /**
     * @function:从list中随机抽取若干不重复元素
     *
     * @param paramList:被抽取list
     * @param count:抽取元素的个数
     * @return:由抽取元素组成的新list
     */
    public static List getRandomList(List paramList,int count){
        if(paramList.size()<count){
            return paramList;
        }
        Random random=new Random();
        List<Integer> tempList=new ArrayList<Integer>();
        List<Object> newList=new ArrayList<Object>();
        int temp=0;
        for(int i=0;i<count;i++){
            temp=random.nextInt(paramList.size());//将产生的随机数作为被抽list的索引
            if(!tempList.contains(temp)){
                tempList.add(temp);
                newList.add(paramList.get(temp));
            }
            else{
                i--;
            }   
        }
        return newList;
    }
    
    /**
     * @function:从数组中随机抽取若干不重复元素
     * 
     * @param paramArray:被抽取数组
     * @param count:抽取元素的个数
     * @return:由抽取元素组成的新数组
     */
    public static String[] getRandomArray(String[] paramArray,int count){
        if(paramArray.length<count){
            return paramArray;
        }
        String[] newArray=new String[count];
        Random random= new Random();
        int temp=0;//接收产生的随机数
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=count;i++){
            temp=random.nextInt(paramArray.length);//将产生的随机数作为被抽数组的索引
            if(!(list.contains(temp))){
                newArray[i-1]=paramArray[temp];
                list.add(temp); 
            }
            else{
                i--;
            }
        }
        return newArray;
    }
}
