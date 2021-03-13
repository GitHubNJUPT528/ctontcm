package com.cton.web.user;


import com.cton.enums.HttpCode;
import com.cton.handler.BusinessException;
import com.cton.model.User;
import com.cton.service.user.UserService;
import com.cton.utils.UUIDUtils;
import com.cton.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RequestMapping("/user")
@Controller
@CrossOrigin
@Api(value = "系统用户模块",tags = "系统用户接口")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return UUIDUtils.buildId("1");
    //return roleMapper.selectPermsIdsByRoleId(1001);
    }


    @ApiOperation(value = "登录",notes = "用户登录")
    @PostMapping("/login")
    public String login(@ApiParam(value = "用户名",required = true) String username, @ApiParam(value = "密码",required = true) String password,@ApiParam(value = "验证码",required = true)String code, HttpSession session){


        //比较验证码
        String codes = (String) session.getAttribute("code");
        //获取主体对象
        try {
            if (codes.equalsIgnoreCase(code)){
                Subject subject = SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(username,password));

                return "redirect:/user/successview";
            }else {
                throw new RuntimeException("验证码错误！");
            }
        }catch (UnknownAccountException e){
            logger.info("用户名错误",e);
            System.out.println("用户名错误");
            return "redirect:/user/failview";
            //return new ResultDTO(HttpCode.FAIL.getCode(),"用户名错误");
        }catch (IncorrectCredentialsException e){
            logger.info("密码错误",e);
            //return new ResultDTO(HttpCode.FAIL.getCode(),"用户名错误");

            return "redirect:/user/failcodeview";
        }catch (RuntimeException e){
            logger.info("验证码错误",e);
            System.out.println("验证码错误错误");
            return "redirect:/user/failcodeview";
        }
        //return new ResultDTO(HttpCode.SUCCESS.getCode(),"登录成功");
    }

    //用户注册
    @ApiOperation(value = "注册",notes = "用户注册")
    @PostMapping("/register")
    public String register(@RequestBody User user){
        Integer register = userService.register(user);
        if (register>0){
            return "redirect:/user/loginview";
        }
        else
            throw new BusinessException(HttpCode.DUPLICATEUSERNAME.getCode(),HttpCode.DUPLICATEUSERNAME.getMsg());

//        try {
//            ResultDTO resultDTO = userService.register(user);
//            if (resultDTO.getCode() == 1001) //注册成功
//                return "redirect:/user/loginview";
//            else
//                return "redirect:/user/registerview";
//        }catch (RuntimeException e){
//            e.printStackTrace();
//            return "redirect:/user/registerview";
//        }
    }





    //下面是功能性接口
    //跳转到register请求
    @ApiOperation(value = "注册导航",notes = "跳转到用户注册页面")
    @GetMapping("/registerview")
    public String register(){
        System.out.println("跳转到register.html");
        return "register";
    }

    //跳转到login请求
    @ApiOperation(value = "登录导航",notes = "跳转到用户登录页面")
    @GetMapping("/loginview")
    public String login(){
        System.out.println("跳转到login.html");
        return "login";
    }

    //跳转到success
    @ApiOperation(value = "登录成功导航",notes = "跳转到success页面")
    @GetMapping("/successview")
    public String success(){
        System.out.println("跳转到success.html");
        return "success";
    }

    //跳转到fail
    @ApiOperation(value = "登录失败导航",notes = "跳转到fail页面")
    @GetMapping("/failview")
    public String fail(){
        System.out.println("fail.html");
        return "fail";
    }


    //跳转到failcode
    @ApiOperation(value = "验证码错误导航",notes = "跳转到验证码错误页面")
    @GetMapping("/failcodeview")
    public String failCode(){
        System.out.println("failcode.html");
        return "failcode";
    }

    /**
     * 获取验证码函数
     * @param session
     * @param response
     * @throws IOException
     */
    @ApiOperation(value = "获取验证码",notes = "获取验证码")
    @GetMapping("/getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //验证码放入session
        session.setAttribute("code",code);
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("image/png");
        VerifyCodeUtils.outputImage(220,60,os,code);
    }

}
