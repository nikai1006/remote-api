package cn.net.nikai.vue.remoteapi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jiatui.spi.ServiceResponse;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * remote-api cn.net.nikai.vue.remoteapi.controller
 *
 * @author: nikai
 * @Description:
 * @Date: Create in 0:58 2019/2/14
 * @Modified By:
 */
@RestController
//@CrossOrigin(allowCredentials = "true",maxAge = 3600)
public class VueController {

    public static final Logger log = LoggerFactory.getLogger(VueController.class);

    @GetMapping("/user/info")
    @ResponseBody
    public User queryUserInfo(String token) {
        User lucy = new User(1L, "lucy", 23);
        lucy.setRoles(Arrays.asList("admin"));
        lucy.setToken(token);
        lucy.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        lucy.setIntroduction("超级管理员");
        return lucy;
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestBody LoginDTO loginDTO) {
        log.info(loginDTO.toString());
//        return new ServiceResponse(200, "success",queryUserInfo("admin"));
        return queryUserInfo(loginDTO.getUsername());
    }

    @PostMapping("/login/logout")
    @ResponseBody
    public String logout() {
        return "success";
    }

    @GetMapping("/transaction/list")
    @ResponseBody
    public String transaction() {
        JsonArray list = new JsonArray();
        JsonObject jsoncontainer = new JsonObject();
        jsoncontainer.addProperty("total", 20);
        jsoncontainer.add("items", list);
        for (int i = 0; i < 20; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("order_no", "No." + i);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            jsonObject.addProperty("username", "nikai" + i);
            jsonObject.addProperty("price", 10 + i);
            if (i % 2 == 0) {
                jsonObject.addProperty("status", "success");
            } else {
                jsonObject.addProperty("status", "pending");

            }

            list.add(jsonObject);

        }
        return jsoncontainer.toString();
    }
}
