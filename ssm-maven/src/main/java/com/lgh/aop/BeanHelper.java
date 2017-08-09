package com.lgh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lgh.pojo.Users;

/**
 * @author Admin
 *	切面
 */
@Component
@Aspect
public class BeanHelper {

    private final Logger log = LoggerFactory.getLogger(BeanHelper.class);
    
    //大概的思路就是登陆的控制器跳转不需要切面进行处理，而其他的进入控制器方法切面需要进行处理
    //@Pointcut("execution(within(com.lgh.controller.UserController) && !within(com.lgh.controller.login.FirstController))")
   // @Pointcut("within(com.lgh.controller..*)&&!within(com.lgh.controller.login.*)")
    //@Pointcut("execution(* com.lgh.controller.UserController.* (..))")
    @Pointcut("execution(* com.lgh.controller.UserController.getIt (..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        Users user = (Users) SysContent.getSession().getAttribute("userSession");
        System.out.println(user);
        System.out.println("我进入了AOP中");
        if(user == null) {
            log.info("-------------没有登录-------------");
            System.out.println("我没有登陆");
            return "redirect:/";
        }
        return pjp.proceed();
    }


}
