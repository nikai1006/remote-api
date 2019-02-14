package cn.net.nikai.vue.remoteapi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:nikai1006@gmail.com">nikai</a>
 * @version 1.0.0
 * @date 2019/2/14 0014
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    public static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @GetMapping("/list")
    @ResponseBody
    public String getList(Integer importance, String type, Integer page, Integer limit, String sort) {

        log.info("importance={},type={},page={},limit={},sort={}", importance, type, page, limit, sort);
        JsonArray list = new JsonArray();
        for (int i = 0; i < limit; i++) {
            JsonObject item = new JsonObject();
            item.addProperty("id", i);
            item.addProperty("timestamp", System.currentTimeMillis());
            item.addProperty("author", "nikai" + i);
            item.addProperty("reviewer", "nikai" + i);
            item.addProperty("title", "hello");
            item.addProperty("content_short", "测试数据");
            item.addProperty("content",
                "<p>我是测试数据我是测试数据</p><p><img src=\"https://wpimg.wallstcn.com/4c69009c-0fd4-4153-b112-6cb53d1cf943\"></p>");
            item.addProperty("forecast", 12.3);
            item.addProperty("importance", 2);
            item.addProperty("type", "US");
            item.addProperty("status", "published");
//            item.addProperty("display_time", new Date());
            item.addProperty("comment_disabled", true);
            item.addProperty("pageviews", 2000);
            item.addProperty("image_uri", "https://wpimg.wallstcn.com/e4558086-631c-425c-9430-56ffb46e70b3");
//            item.addProperty("platforms", i);

            list.add(item);
        }
        JsonObject content = new JsonObject();
        content.addProperty("total", 40);
        content.add("items", list);
        return content.toString();
    }

    @GetMapping("/detail")
    @ResponseBody
    public String getArticle() {
        return null;
    }

    @GetMapping("/pv")
    @ResponseBody
    public String getPv(Integer pv) {
        log.info("pv={}", pv);
        JsonArray list = new JsonArray(4);
        JsonObject pc = new JsonObject();
        pc.addProperty("key", "PC");
        pc.addProperty("pv", 1024);
        list.add(pc);

        JsonObject pc1 = new JsonObject();
        pc1.addProperty("key", "mobile");
        pc1.addProperty("pv", 1024);
        list.add(pc1);

        JsonObject pc2 = new JsonObject();
        pc2.addProperty("key", "ios");
        pc2.addProperty("pv", 1024);
        list.add(pc2);

        JsonObject pc3 = new JsonObject();
        pc3.addProperty("key", "android");
        pc3.addProperty("pv", 1024);
        list.add(pc3);
        JsonObject content = new JsonObject();
        content.add("pvData", list);
        return content.toString();
    }

    @PostMapping("/create")
    @ResponseBody
    public String createArticle() {
        return null;
    }

    @PostMapping("/update")
    @ResponseBody
    public String update() {
        return null;
    }
}
