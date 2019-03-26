# springboot_multi_ds
有问题联系qq：792197389
springboot配置多数据源示例


动态数据源能进行自动切换的核心就是spring底层提供了AbstractRoutingDataSource类进行数据源的路由的，

实现动态数据源的路由步骤：
    1.创建一个管理数据源的线程池类，用来管理所有数据源，用的时候返回一个数据源。
    2.继承AbstractRoutingDataSource，重写 determineCurrentLookupKey()，从（1）数据源线程池类中获取一个数据源。

readMe:
    1.启动类中，@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})排除了自动数据源装配
             @MapperScan(basePackages = {"com.lhf.modules.mapper","com.lhf.modules.mapper.*"}) 配置扫描mapper（interface）的位置
    2.TargetDataSource 注解  配合 DynamicDataSourceAspect 实现注解切换数据源，将当前线程的注解数据源信息存储到DBHelper中

    3.DataSourceConfig 里面配置了数据源的初始化


如何添加一个数据源：
    1.application.yml中配置一个
    2.DataSourceType中增加一个
    3.DataSourceConfig中：
        3.1：   属性注入
        3.2：   实例化数据源
        3.3：   将数据源放入dynamicDataSource中


如何引入到自己项目？？
    1.添加pom依赖
        核心依赖
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
    2.copy dynamicDB到自己的目录
    3.改动：
        3.1:DataSourceConfig中txAdviceAdvisor()方法，execution(* com.lhf..service.*.*(..))改为自己的execution路径
        3.2：DynamicDataSourceAspect 中的targetDataSource()方法 com.lhf.dynamicDB.TargetDataSource修改为修改为现在的TargetDataSource路径
        3.3：启动类中@MapperScan(basePackages = {"com.lhf.modules.mapper","com.lhf.modules.mapper.*"})的package修改为自己的mapper路径
    4.配置文件：
        spring:
          datasource:
            initialSize:  2
            minIdle:  30
            maxActive:  80
            maxWait:  60000
            timeBetweenEvictionRunsMillis:  60000
            minEvictableIdleTimeMillis: 300000
            validationQuery:  SELECT 'x'
            testWhileIdle:  true
            testOnBorrow: false
            testOnReturn: false
            poolPreparedStatements: true
            maxPoolPreparedStatementPerConnectionSize:  20
            filters:  wall,stat

            ds1:
              driverClassName:  com.mysql.jdbc.Driver
              url:  jdbc:mysql://localhost:3306/test1
              username: root
              password: 123456

            ds2:
              driverClassName:  com.mysql.jdbc.Driver
              url:  jdbc:mysql://localhost:3306/test2
              username: root
              password: 123456

            ds3:
              driverClassName:  com.mysql.jdbc.Driver
              url:  jdbc:mysql://localhost:3306/test3
              username: root
              password: 123456

    5.启动类中排除自动装配
        @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
    搞定！！！