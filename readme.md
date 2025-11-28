# arkHelp 项目目录结构

## 项目概述
arkHelp 是一个基于 Spring Boot 3.3.4 的 Java 后端项目，使用 Java 21、MyBatis Plus、Spring Security 和 JWT 进行开发。

## 技术栈
- **框架**: Spring Boot 3.3.4
- **Java 版本**: 21
- **ORM**: MyBatis Plus 3.5.7
- **数据库**: MySQL
- **安全框架**: Spring Security + JWT (JJWT 0.12.3)
- **API 文档**: Knife4j 4.4.0
- **构建工具**: Maven

## 目录结构

```
arkHelp/
├── pom.xml                                 # Maven 项目配置文件
├── mvnw                                    # Maven Wrapper 脚本(Linux/Mac)
├── mvnw.cmd                               # Maven Wrapper 脚本(Windows)
├── HELP.md                                # 项目帮助文档
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── fun/
│   │   │       └── quanweng/
│   │   │           └── arkhelp/
│   │   │               ├── ArkHelpApplication.java        # Spring Boot 主启动类
│   │   │               │
│   │   │               ├── common/                        # 公共工具类
│   │   │               │   ├── JwtUtil.java              # JWT 工具类
│   │   │               │   ├── PasswordUtil.java         # 密码加密工具类
│   │   │               │   └── SecurityUtil.java         # 安全工具类
│   │   │               │
│   │   │               ├── config/                        # 配置类
│   │   │               │   ├── SecurityConfig.java       # Spring Security 配置
│   │   │               │   └── SwaggerConfig.java        # Swagger/Knife4j 配置
│   │   │               │
│   │   │               ├── controller/                    # 控制层
│   │   │               │   ├── HelpController.java       # 帮助请求控制器
│   │   │               │   ├── LoginController.java      # 登录控制器
│   │   │               │   ├── OperatorController.java   # 操作员控制器
│   │   │               │   └── UserInfoController.java   # 用户信息控制器
│   │   │               │
│   │   │               ├── enums/                         # 枚举类
│   │   │               │   └── ResultCode.java           # 结果状态码枚举
│   │   │               │
│   │   │               ├── exception/                     # 异常处理
│   │   │               │   ├── GlobalException.java      # 全局自定义异常
│   │   │               │   └── GlobalExceptionHandle.java # 全局异常处理器
│   │   │               │
│   │   │               ├── filter/                        # 过滤器
│   │   │               │   └── JwtAuthenticationFilter.java # JWT 认证过滤器
│   │   │               │
│   │   │               ├── mapper/                        # MyBatis 数据访问层
│   │   │               │   ├── HelpMapper.java           # 帮助请求 Mapper
│   │   │               │   ├── LoginMapper.java          # 登录 Mapper
│   │   │               │   └── OperatorMapper.java       # 操作员 Mapper
│   │   │               │
│   │   │               ├── pojo/                          # 数据对象
│   │   │               │   ├── dto/                      # 数据传输对象
│   │   │               │   │   ├── HelpTableDTO.java     # 帮助请求 DTO
│   │   │               │   │   ├── OperatorTableDTO.java # 操作员 DTO
│   │   │               │   │   ├── RefreshTokenDTO.java  # 刷新令牌 DTO
│   │   │               │   │   ├── UserDTO.java          # 用户 DTO
│   │   │               │   │   └── UserInfoDTO.java      # 用户信息 DTO
│   │   │               │   │
│   │   │               │   ├── entity/                   # 实体类(数据库映射)
│   │   │               │   │   ├── HelpTable.java        # 帮助请求实体
│   │   │               │   │   ├── OperatorTable.java    # 操作员实体
│   │   │               │   │   ├── UserInfoTable.java    # 用户信息实体
│   │   │               │   │   └── UserTable.java        # 用户实体
│   │   │               │   │
│   │   │               │   └── vo/                       # 视图对象
│   │   │               │       ├── HelpTableVO.java      # 帮助请求 VO
│   │   │               │       ├── LoginInfoVO.java      # 登录信息 VO
│   │   │               │       ├── OperatorTableVO.java  # 操作员 VO
│   │   │               │       └── UserInfoVO.java       # 用户信息 VO
│   │   │               │
│   │   │               ├── result/                        # 统一响应结果
│   │   │               │   └── Result.java               # 统一返回结果封装类
│   │   │               │
│   │   │               └── service/                       # 业务逻辑层
│   │   │                   ├── HelpService.java          # 帮助请求服务接口
│   │   │                   ├── LoginService.java         # 登录服务接口
│   │   │                   ├── OperatorService.java      # 操作员服务接口
│   │   │                   └── impl/                     # 服务实现类
│   │   │                       ├── HelpServiceImpl.java  # 帮助请求服务实现
│   │   │                       ├── LoginServiceImpl.java # 登录服务实现
│   │   │                       └── OperatorServiceImpl.java # 操作员服务实现
│   │   │
│   │   └── resources/                                     # 资源文件
│   │       ├── application.properties                    # 应用配置文件
│   │       ├── application.yml                           # 应用配置文件(YAML格式)
│   │       ├── static/                                   # 静态资源
│   │       └── templates/                                # 模板文件
│   │
│   └── test/                                             # 测试代码
│       └── java/
│           └── fun/
│               └── quanweng/
│                   └── arkhelp/
│                       └── ArkHelpApplicationTests.java  # 应用测试类
│
└── target/                                               # Maven 编译输出目录
    ├── classes/                                          # 编译后的 class 文件
    └── generated-sources/                                # 生成的源代码
        └── annotations/                                  # 注解处理器生成的代码
```

## 模块说明

### 1. Controller 层 (控制层)
处理 HTTP 请求，负责接收前端请求并调用相应的 Service 层方法。

### 2. Service 层 (业务逻辑层)
包含业务逻辑的接口定义和实现，处理具体的业务规则。

### 3. Mapper 层 (数据访问层)
使用 MyBatis Plus 进行数据库操作，提供数据持久化功能。

### 4. POJO 包
- **Entity**: 与数据库表直接映射的实体类
- **DTO (Data Transfer Object)**: 用于接收前端传来的数据
- **VO (View Object)**: 用于返回给前端的数据对象

### 5. Common 包
包含项目中通用的工具类，如 JWT 处理、密码加密、安全工具等。

### 6. Config 包
存放 Spring 配置类，包括安全配置、API 文档配置等。

### 7. Exception 包
全局异常处理，统一处理项目中的异常。

### 8. Filter 包
存放过滤器，如 JWT 认证过滤器，用于请求预处理。

### 9. Enums 包
定义枚举类型，如结果状态码等。

### 10. Result 包
统一封装 API 响应结果。

## 核心依赖

```xml
<!-- Spring Boot Web -->
spring-boot-starter-web

<!-- MyBatis Plus -->
mybatis-plus-boot-starter: 3.5.7

<!-- MySQL 驱动 -->
mysql-connector-j

<!-- Spring Security -->
spring-boot-starter-security

<!-- JWT -->
jjwt-api: 0.12.3

<!-- API 文档 -->
knife4j-openapi3-jakarta-spring-boot-starter: 4.4.0

<!-- Lombok -->
lombok

<!-- 数据验证 -->
spring-boot-starter-validation
```

## API 文档访问

项目集成了 Knife4j，启动项目后可通过以下地址访问 API 文档：
```
http://localhost:8080/doc.html
```

## 项目特点

1. **前后端分离架构**: 使用 JWT 进行身份认证
2. **RESTful API 设计**: 遵循 REST 规范
3. **分层架构**: Controller -> Service -> Mapper，职责清晰
4. **统一异常处理**: 全局异常捕获和处理
5. **统一响应格式**: Result 类封装统一的 API 响应
6. **API 文档自动生成**: 集成 Knife4j/Swagger
7. **代码简洁**: 使用 Lombok 减少样板代码
