package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * 1、配置类里面使用的@bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是一个组件
 * 3、proxyBeanMethods:代理bean的方法
 * Full(proxyBeanMethods = true)、
 * Lite(proxyBeanMethods = false)
 * 组件依赖
 * 4、 @Import(User.class)导入组件
 *5、@ConditionalOnBean(name="tom")容器中有tom组件才装配，条件装配
 */
//@ConditionalOnBean(name="tom")
@Import(User.class)
@Configuration (proxyBeanMethods = true)//告诉springboot这是一个配置类，等同与配置文件
public class MyConfig {

    @Bean//给容器中添加组件，以方法名为组件ID。返回类型就是组件类型。返回的值就是组件在容器中的实例
    public User user01(){
        User zhangsan= new User("张三",18);
        zhangsan.setPet(pet01());
        return zhangsan;
    }

    @Bean
    public Pet pet01(){
        return new Pet("tom");
    }
}
