package com.rekog.faceRekognition.controller;


import com.rekog.faceRekognition.data.OutputData;
import com.rekog.faceRekognition.function.DataMaker;
import com.rekog.faceRekognition.service.FaceService;
import com.rekog.faceRekognition.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    FaceService faceService;
    @Autowired
    ImageService imageService=new ImageService();

    @PostMapping("/upload")
    public ResponseEntity<List<OutputData>> uploadImage(@RequestParam("image") MultipartFile file) throws Exception {
        // 파일 처리 로직 (생략)

        //AWS 처리코드
        Map<String, Object> response = Map.of();
        String imagepath = imageService.save(file);
        response = faceService.faceProcess(imagepath);

        //분석한 얼굴정보로 부터 나이의 평균과 성별을 받아옴
        int age= ((int)(((int) response.get("ageHigh")+(int) response.get("ageLow"))/2)/10)*10;
        String gender=(String)response.get("gender");
        System.out.println("나이는 "+age+"대이고\n"+"성별은 "+gender+"입니다");
        //

        imageService.delete(imagepath);
        //


        System.out.println("파일 이름: " + file.getOriginalFilename());

        DataMaker dataMaker=new DataMaker();

        // 결과 반환
       //List<OutputData> results = new ArrayList<>();
        List<OutputData> results=dataMaker.DataMaker(age,gender);
        //results.add(new OutputData("Pizza"));
        //results.add(new OutputData("Burger"));
        //results.add(new OutputData("Pasta"));

        System.out.println(results);

        return ResponseEntity.ok(results);
    }



}



    //




    //






    //





