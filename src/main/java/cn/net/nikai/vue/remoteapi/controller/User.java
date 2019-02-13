package cn.net.nikai.vue.remoteapi.controller;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    List<String> roles;
    String token;
    String introduction;
    String avatar;

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String toString() {
        return "User{id=" + this.id + ", name='" + this.name + '\'' + ", age=" + this.age + ", roles=" + this.roles + ", token='" + this.token + '\'' + ", introduction='" + this.introduction + '\'' + ", avatar='" + this.avatar + '\'' + '}';
    }
}
