目的：提高程序可维护性，可扩展性
工程师职业素养：注意模块化，注意命名规则
# 1. 三层架构（降低耦合度）
1. 表现层（和用户进行交互--JSP、Servlet）
2. 业务逻辑层（业务处理）--高级数据处理（登录、注册、修改密码）
3. 数据访问层（对数据库进行增删改查）--低级数据处理（查询、插入、更新）
## 扩展：设计模式（20+：单例设计模式、代理设计模式、DAO设计模式...）、设计原则（7：依赖倒转）

# 2. 三层结构开发
1. 公共接口

![](day08_files/1.jpg)
2. 子接口（每个表都需要子接口）
![](day08_files/2.jpg)
![](day08_files/3.jpg)
![](day08_files/4.jpg)
3. 子接口的实现（每个接口都需要实现）
![](day08_files/5.jpg)
![](day08_files/6.jpg)
![](day08_files/7.jpg)
4. 业务层接口（模块）
![](day08_files/8.jpg)
5. 业务层接口的实现
![](day08_files/9.jpg)

# 3. 三层架构的实现（登录）
1-1：表现层（JSP）
![](day08_files/10.jpg)
1-2：表现层（Servlet）
![](day08_files/11.jpg)
2-1：业务层接口（已完成）
2-2：业务层接口实现
![](day08_files/12.jpg)
3-1：持久层公共接口（已完成）
3-2：持久层子接口（已完成）
3-3：持久层子接口实现
![](day08_files/13.jpg)