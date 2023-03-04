# StoreHouseManage

【代码预览可进入文件夹查看】

【完整的项目可下载压缩包】


这是一个非常简单的仓储管理Java小项目

Java小白新手均可上手

（因为是Java小白，所以代码逻辑有些混乱和杂糅，可根据自身需要进行修改）

功能包括

+ 新增数据
+ 展示数据
+ 进出管理
+ 删除数据
+ 仓储数据（数据统计）
+ 导出数据

使用步骤：

1. 在`Connect`类中的uname和psw中填入数据库用户名和密码

```Java
String uname = "";
String psw = "";
// 连接前，建议使用IDEA或其他ide测试数据库能否正常连接
```

2. 数据库中建立三张表，分别是`detail`，`unit`和`users`，其设计如下：

   2.1. detail

   |  名  |  类型   | 长度 | 小数点 | 空值 |
   | :--: | :-----: | :--: | :----: | :--: |
   |  id  |   int   |  0   |   0    |      |
   | name | varchar |  15  |   0    |      |
   | date | varchar |  11  |   0    |      |
   | type | varchar |  10  |   0    |      |
   | quan |   int   |  6   |   0    |      |
   | note | varchar | 100  |   0    |  ✔   |

   2.2. unit

   |  名  |  类型   | 长度 | 小数点 | 空值 |
   | :--: | :-----: | :--: | :----: | :--: |
   |  id  |   int   |  5   |   0    |      |
   | name | varchar |  15  |   0    |      |
   | date | varchar |  11  |   0    |      |
   | quan |   int   |  10  |   0    |      |
   | note | varchar | 100  |   0    |      |

   2.3. users

   |    名     |  类型   | 长度 | 小数点 | 空值 |
   | :-------: | :-----: | :--: | :----: | :--: |
   |    id     |   int   |  5   |   0    |      |
   |  findid   | varchar |  10  |   0    |      |
   | username  | varchar |  10  |   0    |      |
   | password  | varchar |  10  |   0    |      |
   | telephone | varchar |  15  |   0    |      |

   这三张表均放在`billbook`数据库中

3. 等待Maven导入，等待无报错时，运行`Entrance`文件


注：菜单中的图标包来自 小假哥_常用_icon116 
https://www.iconfont.cn/collections/detail?spm=a313x.7781069.1998910419.d9df05512&cid=42850
