package com.rekog.faceRekognition.data;

public class OutputData {
    private String menu;
    private int count;
    private int age;
    private String gender;
    private String sentence;

    public OutputData(String menu, String sentence) {
        this.menu = menu;
        this.sentence=sentence;

    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAge(){return age;}

    public void setAge(int age){this.age=age;}

    public String getGender(){return gender;}

    public void setGender(String gender){this.gender=gender;}

    public void setSentence(String sentence) { this.sentence = sentence; }
    public String getSentence() { return sentence; }
}
