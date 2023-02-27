# Spring

## 核心概念  
- 代码书写现状  
    - 耦合度偏高  
- 解决方案  
    - 使用对象时，在程序中不要主动使用new产生对象，转换为由外部提供对象  
- IoC控制反转  
    - 对象的创建控制权由程序转移到外部，这种思想称为控制反转  
- Spring技术对IoC思想进行了实现  
    - Spring提供了一个容器，称为IoC容器，用来充当IoC思想中的外部  
    - IoC容器负责对象的创建、初始化等一系列工作，被创建或被管理的对象在IoC容器中统称为Bean  
- DI依赖注入  
    - 在容器中建立bean与bean之间的依赖关系的整个过程，称为依赖注入  
- 目标:充分解耦  
    - 使用IoC容器管理bean(IoC)
    - 在IoC容器内将有依赖关系的bean进行关系绑定(DI)  
- 最终效果  
    - 使用对象时不仅可以直接从IoC容器中获取，并且获取到的bean已经绑定了所有的依赖关系

## IoC入门案例  
- 管理什么？(Service与Dao)  
- 如何将被管理的对象告知IoC容器？(配置)  
- 被管理的对象交给IoC容器，如何获取到IoC容器？(接口)  
- IoC容器得到后，如何从容器中获取bean(接口方法)  
- 使用Spring导入哪些坐标？(pom.xml)  

## DI入门案例  
- 基于IoC管理bean  
- Service中使用new形式创建的Dao对象是否保留？(否)  
- Service中需要的Dao对象如何进入到Service中？(提供方法)  
- Service与Dao间的关系如何描述？(配置)  

## bean基础配置  
- 别名: 定义bean的别名，可定义多个，使用逗号(,)、分号(;)、空格( )分隔  
- scope:  
  - singleton: 单例(默认)
  - prototype: 非单例  
- 为什么bean默认为单例？  
- 适合交给容器进行管理的bean(单例)  
  - 表现层对象  
  - 业务层对象  
  - 数据层对象  
  - 工具对象  
- 不适合交给容器进行管理的bean  
  - 封装实体的域对象  

## bean实例化  
- bean本质上就是对象，创建bean使用构造方法完成  
- 实例化bean的三种方式  
  - 构造方法
    - 提供可访问的构造方法  
    - 配置xml文件  
    - 无参构造方法如果不存在，将抛出异常BeanCreationException  
  - 静态工厂  
  - 实例工厂与FactoryBean  

## bean生命周期  
- 生命周期: 从创建到消亡的完整过程  
- bean生命周期: bean从创建到销毁的整体过程  
- bean生命周期控制: 在bean创建后到销毁前做一些事情  
- 过程:  
  - 初始化容器  
    - 创建对象(内存分配)  
    - 执行构造方法  
    - 执行属性注入(set操作)  
    - 执行bean初始化方法  
  - 使用bean  
    - 执行业务操作  
  - 关闭/销毁容器  
    - 执行bean销毁方法  
- bean销毁时机  
  - 容器关闭前触发bean的销毁  
  - 关闭容器的方式:  
    - 手动关闭容器  
      ConfigurableApplicationContext接口close()操作  
    - 注册关闭钩子，在虚拟机退出前先关闭容器再退出虚拟机  
      ConfigurableApplicationContext接口registerShutdownHook()操作  
- 依赖注入方式  
  - 思考：向一个类中传递数据的方式有几种  
    - 普通方法(set方法)
    - 构造方法  
  - 思考：依赖注入描述了在容器中建立bean与bean之间依赖关系的过程，如果bean运行需要的是数字或字符串呢？  
    - 引用类型  
    - 简单类型(基本数据类型与String)  
  - 依赖注入方式  
    - setter注入  
      - 简单类型  
      - 引用类型  
    - 构造器注入  
      - 简单类型  
      - 引用类型  
- 依赖自动装配特征  
  - 自动装配用于引用类型依赖注入，不能对简单类型进行操作  
  - 使用按类型装配时(byType)必须保障容器中相同类型的bean唯一，推荐使用  
  - 使用按名称装配时(byName)必须保障容器中具有指定名称的bean，因变量名与配置耦合，不推荐使用  
  - 自动装配优先级低于setter注入与构造器注入，同时出现时自动装配配置失效  

## 核心容器总结  
- 容器相关  
  - BeanFactory是IoC容器的顶层接口，初始化BeanFactory对象时，加载的Bean延迟加载  
  - ApplicationContext接口是Spring容器的核心接口，初始化时bean立刻被加载  
  - ApplicationContext接口提供基础的bean操作相关方法，通过其他接口扩展其功能
  - ApplicationContext接口常用初始化类
    - ClassPathXmlApplicationContext  
    - FileSystemXmlApplicationContext
- bean相关  
  - id: bean的id  
  - name: bean的别名  
  - class: bean的类型，静态工厂类，FactoryBean类  
  - scope: 控制bean的实例数量  
  - init-method: 生命周期初始化方法  
  - destroy-method: 生命周期销毁方法  
  - autowire: 自动装配类型  
  - factory-method: bean工厂方法，应用于静态工厂或实例工厂  
  - factory-bean: 实例工厂bean  
  - lazy-init: 控制bean延迟加载  
- 依赖注入相关  