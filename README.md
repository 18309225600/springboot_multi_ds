# springboot_multi_ds
springboot配置多数据源示例


动态数据源能进行自动切换的核心就是spring底层提供了AbstractRoutingDataSource类进行数据源的路由的，

实现动态数据源的路由步骤：
    1.创建一个管理数据源的线程池类，用来管理所有数据源，用的时候返回一个数据源。
    2.继承AbstractRoutingDataSource，重写 determineCurrentLookupKey()，从（1）数据源线程池类中获取一个数据源。

