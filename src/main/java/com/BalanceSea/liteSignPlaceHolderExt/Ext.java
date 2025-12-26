package com.BalanceSea.liteSignPlaceHolderExt;

public class Ext {
    public int year;
    public int month;

    public Ext(int year,int month){
        this.year = year;
        this.month = month;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }


    @Override
    public String toString(){
        return String.format("玩家当前签到页面时间为%d年%d月",year,month);
    }
}
