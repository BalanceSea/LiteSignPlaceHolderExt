package com.BalanceSea.liteSignPlaceHolderExt;

public class Ext {
    public int LastYear;
    public int LastMonth;
    public int NextYear;
    public int NextMonth;

    public Ext(int LastYear,int LastMonth,int NextYear,int NextMonth){
        this.LastYear = LastYear;
        this.LastMonth = LastMonth;
        this.NextYear = NextYear;
        this.NextMonth = NextMonth;
    }

    public int getLastYear(){
        return LastYear;
    }

    public int getLastMonth(){
        return LastMonth;
    }

    public int getNextYear(){
        return NextYear;
    }

    public int getNextMonth(){
        return NextMonth;
    }


    @Override
    public String toString(){
        return String.format("玩家当前签到页面的上一个页面时间为%d年%d月-下一个页面的时间为%d年%d月",LastYear,LastMonth,NextYear,NextMonth);
    }
}
