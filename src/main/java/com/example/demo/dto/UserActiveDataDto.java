package com.example.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author demo
 * @Program: demo
 * @Description: 用户活跃数据图标出参
 * @date 2021-12-29 15:43
 */
@Data
public class UserActiveDataDto {

    private List<String> date;

    private Data data=new Data();

    @lombok.Data
    class Data {
        private List<Integer> msg;
        private List<Integer> reg;
        private List<Integer> day;
    }

    public UserActiveDataDto(List<String> date, List<Integer> msg, List<Integer> reg, List<Integer> day){
        this.date=date;
        this.data.setMsg(msg);
        this.data.setReg(reg);
        this.data.setDay(day);
    }


}
