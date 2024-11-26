package com.example.re_2.functions.retrofit;

public class OutputData {
    private String menu;
    private int count;
    private int age;
    private String gender;
    private String sentence;

    public String getMenu() { return menu; }
    public int getCount() { return count; }

    public int getAge() { return age; }
    public String getGender() { return gender; }
    public void setMenu(String menu) { this.menu = menu; }
    public void setCount(int count) { this.count = count; }

    public void setSentence(String sentence) { this.sentence = sentence; }
    public String getSentence() { return sentence; }
}
