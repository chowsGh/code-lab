# 项目创建途径
使用 [aliyun java initailizr](https://start.aliyun.com/) 创建的。可以1. 项目结构(分层架构)，2. 项目依赖，然后点击下载即可。

# spring boot starter
> starters 包含了能快速启动项目所需要的依赖包，官方 starter 命名格式是 "spring-boot-starter-*" 格式的。这种格式能帮助我们找到我们需要的依赖。
> IDE中集成 maven 了，在指定需要的依赖的时候，可以通过输入 spring-boot-starter 然后通过智能提示补全。第三方 starter 命名格式是 "thirdpartyproject-spring-boot-starter"。

# spring boot 核心特性
## auto config
### starter 自动配置结构
``` 
META-INF/spring.factories
```

### 外置配置（external configration）
- 加载顺序
  - A `/config` subdirectory of the current directory
  - The current directory
  - A classpath `/config` package
  - The classpath root
- 配置提示
``` 
META-INF/spring-configuration-metadata.json
```

- #### Profile-specific Properties（指定 profile 配置）

- 

## spring mvc  

The auto-configuration adds the following features on top of Spring’s defaults:

- Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.
- Support for serving static resources, including support for WebJars (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-static-content))).
- Automatic registration of `Converter`, `GenericConverter`, and `Formatter` beans.
- Support for `HttpMessageConverters` (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-message-converters)).
- Automatic registration of `MessageCodesResolver` (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-spring-message-codes)).
- Static `index.html` support.
- Custom `Favicon` support (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-favicon)).
- Automatic use of a `ConfigurableWebBindingInitializer` bean (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-web-binding-initializer)).

如果你想自己控制 spring mvc 

> you can add your own `@Configuration` annotated with `@EnableWebMvc`, or alternatively add your own `@Configuration`-annotated `DelegatingWebMvcConfiguration` as described in the Javadoc of `@EnableWebMvc`.



## spring actuator 执行器

> Spring Boot includes a number of additional features to help you monitor and manage your application when you push it to production. You can choose to manage and monitor your application by using HTTP endpoints or with JMX. Auditing, health, and metrics gathering can also be automatically applied to your application.

### 端点

1. 激活端点
2. 暴露端点
   1. 暴露形式 http,jmx

### 参考配置

```
management:
  endpoint:
    health:
      show-details: always
  endpoints:
    enabled-by-default: true
    jmx:
      exposure:
        include: '*'
    web:
      exposure:
        include: '*'
  server:
    port: 8081 # port=-1 则关闭 http
```



