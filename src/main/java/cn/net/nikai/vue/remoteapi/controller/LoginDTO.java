package cn.net.nikai.vue.remoteapi.controller;

/**
 * @author <a href="mailto:nikai1006@gmail.com">nikai</a>
 * @version 1.0.0
 * @date 2019/1/31 0031
 */
public class LoginDTO {

    String username;

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
