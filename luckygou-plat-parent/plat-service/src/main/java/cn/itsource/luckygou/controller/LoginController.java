package cn.itsource.luckygou.controller;

import cn.itsource.luckygou.domain.User;
import cn.itsource.luckygou.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "这是登录的controller")
public class LoginController {

    /**
     * 登录接口
     * @return
     */
    @ApiOperation(value = "登录的接口")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user){
        System.out.println("=======1");
        if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
            return AjaxResult.me().setSuccess(true).setMessage("登录成功！").setRestObj(user);

        }
        return AjaxResult.me().setSuccess(false).setMessage("登录失败！");
    }
}
