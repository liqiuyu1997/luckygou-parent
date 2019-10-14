package cn.itsource.luckygou;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;

public class FastJSONTest {
    @Test
    public void test()throws Exception{

        //java对象转json字符串
//        User user = new User(1L,"zhangsan");
//        String jsonString = JSON.toJSONString(user);
//        System.out.println(jsonString);//{"id":1,"username":"zhangsan"}



        //java集合转json字符串
//        List<User> users = Arrays.asList(
//                new User(1L,"zhangsan"),
//                new User(2L,"lisi")
//        );
//        String toJSONString = JSON.toJSONString(users);
//        System.out.println(toJSONString);//[{"id":1,"username":"zhangsan"},{"id":2,"username":"lisi"}]

        //json字符串转java对象
//        String jsonStr = "{\"id\":1,\"username\":\"zhangsan\"}";
//        User user = JSONObject.parseObject(jsonStr, User.class);
//        System.out.println(user);

        //json字符串转java集合
        String jsonStr = "[{\"id\":1,\"username\":\"zhangsan\"},{\"id\":2,\"username\":\"lisi\"}]";
        List<User> users = JSONArray.parseArray(jsonStr, User.class);
        System.out.println(users);

    }
}
