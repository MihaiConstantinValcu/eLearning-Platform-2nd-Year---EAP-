package com.company.Objects;

public class Chapter {
    private String name = "Undefined Chapter";
    private String description = "Undefined Description";
    private String content = "Yet to be added";

    public Chapter() {
    }

    public Chapter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void seeContent() {
        System.out.println(name);
        System.out.println(description);
        System.out.println(content);
        System.out.println("--------------------");
    }
}
