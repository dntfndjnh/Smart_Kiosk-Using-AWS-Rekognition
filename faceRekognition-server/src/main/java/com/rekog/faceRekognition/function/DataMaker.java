package com.rekog.faceRekognition.function;

import com.rekog.faceRekognition.data.OutputData;

import java.util.ArrayList;
import java.util.List;

public class DataMaker {
    public List<OutputData> DataMaker(int age, String gender)
    {
        List<OutputData> results = new ArrayList<>();


        if (age==0&&gender=="Male")
        {
            results.add(new OutputData("복숭아 아이스티","#남자 #어린이"));
            results.add(new OutputData("미니 피자","#남자 #어린이"));
            results.add(new OutputData("초코라떼","#남자 #어린이"));
            results.add(new OutputData("쿠키팝","#남자 #어린이"));
        }

        else if (age==0&&gender=="Female")
        {
            results.add(new OutputData("티니핑 아이스크림","#여자 #어린이"));
            results.add(new OutputData("딸기라떼","#여자 #어린이"));
            results.add(new OutputData("초코라떼","#여자 #어린이"));
        }

        else if (age==10&&gender=="Male")
        {
            results.add(new OutputData("복숭아 아이스티","#10대 #남성"));
            results.add(new OutputData("플랫치노","#10대 #남성"));
            results.add(new OutputData("초코라떼","#10대 #남성"));
        }

        else if (age==10&&gender=="Female")
        {
            results.add(new OutputData("복숭아 아이스티","#10대 #여성"));
            results.add(new OutputData("플랫치노","#10대 #여성"));
            results.add(new OutputData("초코라떼","#10대 #여성"));
        }
        else if (age==20&&gender=="Male")
        {
            results.add(new OutputData("아메리카노","#20대 #남자"));
            results.add(new OutputData("토피넛라떼","#20대 #남자"));
            results.add(new OutputData("","#20대 #남자"));
        }

        else if (age==20&&gender=="Female")
        {
            results.add(new OutputData("스파클링 레몬티","#20대 #여자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#20대 #여자"));
            results.add(new OutputData("바닐라 라떼","#20대 #여자"));
            results.add(new OutputData("헤이즐넛 라떼","#20대 #여자"));
        }

        if (age==30&&gender=="Male")
        {
            results.add(new OutputData("스파클링 레몬티","#30대 #남자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#30대 #남자"));
            results.add(new OutputData("바닐라 라떼","#30대 #남자"));
            results.add(new OutputData("헤이즐넛 라떼","#30대 #남자"));
        }

        if (age==30&&gender=="Female")
        {
            results.add(new OutputData("블랙 슈가 펄 라떼","#30대 #여자"));
            results.add(new OutputData("바닐라 라떼","#30대 #여자"));
            results.add(new OutputData("카페 라떼","#30대 #여자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#30대 #여자"));
        }

        if (age==40&&gender=="Male")
        {
            results.add(new OutputData("아메리카노","#40대 #남자"));
            results.add(new OutputData("버블 흑당 라뗴","#40대 #남자"));
            results.add(new OutputData("바닐라 라떼","#40대 #남자"));
            results.add(new OutputData("헤이즐넛 라떼","#40대 #남자"));
        }

        if (age==40&&gender=="Female")
        {
            results.add(new OutputData("레몬 유자 케모마일 티","#40대 #여자"));
            results.add(new OutputData("카페 라떼","#40대 #여자"));
            results.add(new OutputData("바닐라 라떼","#40대 #여자"));
            results.add(new OutputData("카푸치노","#40대 #여자"));
        }

        if (age==50&&gender=="Male")
        {
            results.add(new OutputData("스파클링 레몬티","#50대 #남자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#50대 #남자"));
            results.add(new OutputData("바닐라 라떼","#50대 #남자"));
            results.add(new OutputData("헤이즐넛 라떼","#50대 #남자"));
        }

        if (age==50&&gender=="Female")
        {
            results.add(new OutputData("블랙 슈가 펄 라떼","#50대 #여자"));
            results.add(new OutputData("바닐라 라떼","#50대 #여자"));
            results.add(new OutputData("카페 라떼","#50대 #여자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#50대 #여자"));
        }


        if (age==60&&gender=="Male")
        {
            results.add(new OutputData("스파클링 레몬티","#60대 #남자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#60대 #남자"));
            results.add(new OutputData("바닐라 라떼","#60대 #남자"));
            results.add(new OutputData("헤이즐넛 라떼","#60대 #남자"));
        }

        if (age==60&&gender=="Female")
        {
            results.add(new OutputData("블랙 슈가 펄 라떼","#60대 #여자"));
            results.add(new OutputData("바닐라 라떼","#60대 #여자"));
            results.add(new OutputData("카페 라떼","#60대 #여자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#60대 #여자"));
        }

        if (age==70&&gender=="Male")
        {
            results.add(new OutputData("스파클링 레몬티","#70대 #남자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#70대 #남자"));
            results.add(new OutputData("바닐라 라떼","#70대 #남자"));
            results.add(new OutputData("헤이즐넛 라떼","#70대 #남자"));
        }

        if (age==70&&gender=="Female")
        {
            results.add(new OutputData("블랙 슈가 펄 라떼","#70대 #여자"));
            results.add(new OutputData("바닐라 라떼","#70대 #여자"));
            results.add(new OutputData("카페 라떼","#70대 #여자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#70대 #여자"));
        }

        if (age==80&&gender=="Male")
        {
            results.add(new OutputData("스파클링 레몬티","#80대 #남자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#80대 #남자"));
            results.add(new OutputData("바닐라 라떼","#80대 #남자"));
            results.add(new OutputData("헤이즐넛 라떼","#80대 #남자"));
        }

        if (age==80&&gender=="Female")
        {
            results.add(new OutputData("블랙 슈가 펄 라떼","#80대 #여자"));
            results.add(new OutputData("바닐라 라떼","#80대 #여자"));
            results.add(new OutputData("카페 라떼","#80대 #여자"));
            results.add(new OutputData("헤이즐넛 아메리카노","#80대 #여자"));
        }

        return results;
    }
}
