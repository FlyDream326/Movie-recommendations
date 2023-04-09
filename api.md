# 电影推荐

### 运行环境

- **JDK 1.8**

- **MAVEN 3.6.3**

- **Spring Boot 2.5.0**

- **MySQL 8.0.29**

  

### 1.1 电影分页查询

可根据filmName、year进行模糊查询**（有数值且不为NULL时进行模糊查询）**

根据电影id 倒序

pageNum页码

pageSize页内数据条数

| 请求方式 |    路径    | token |
| :------: | :--------: | :---: |
|   Get    | /film/List |   /   |

**Query请求参数**

| 请求参数 |  类型   | 是否必须 |
| :------: | :-----: | :------: |
| filmName | String  |    否    |
|   year   | String  |    否    |
| pageNum  | Integer |    是    |
| pageSize | Integer |    是    |

返回实例：

```java
{
    "code": 200,
    "data": {
        "rows": [
            {
                "actors": [
                    {
                        "avataraddress": "https://static.maizuo.com/pc/v5/usr/movie/4f6aa3e40948c476b5dd27923d966e66.jpg",
                        "name": "谷口悟朗",
                        "role": "蒙奇·D·路飞"
                    },
                    {
                        "avataraddress": "https://pic.maizuo.com/usr/movie/d727837a1a65cf02d1734674f86a1051.jpg",
                        "name": "中井和哉",
                        "role": "罗罗诺亚·索"
                    },
                    {
                        "avataraddress": "https://pic.maizuo.com/usr/movie/1d2c7e8ee9d9b526e3a613ed8353da32.jpg",
                        "name": "冈村明美",
                        "role": "奈美"
                    },
                    {
                        "avataraddress": "https://pic.maizuo.com/usr/movie/71dc2711ab2417422de03bb14423760a.jpg",
                        "name": "山口胜平",
                        "role": "撒谎布"
                    }
                ],
                "director": "谷口悟朗",
                "filmName": "航海王：红发歌姬",
                "filmShowtime": "",
                "grades": "7.9",
                "id": "6166",
                "isShow": "true",
                "language": "日语",
                "nation": "日本",
                "poster": "https://pic.maizuo.com/usr/movie/1f25dd6943762288dfd84b961c98f478.jpg",
                "runtime": "114",
                "synopsis": "令全世界为之疯狂的歌姬·乌塔，她的身世成谜，歌声却被誉为“来自别的次元”。而这次，她将举办演唱会并第一次露出庐山真面目。为了欣赏她的歌声，路飞率领的草帽一伙，以及世界各地的歌迷都汇聚在会场之中。全世界备受瞩目的歌声即将在此回荡。而故事就在乌塔是“杰克斯的女儿”这一令人震惊的发现中拉开帷幕！",
                "categories": [
                    "喜剧",
                    "动画"
                ],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "詹姆斯·卡梅隆",
                "filmName": "阿凡达：水之道",
                "filmShowtime": "",
                "grades": "7",
                "id": "6165",
                "isShow": "false",
                "language": "英语",
                "nation": "美国",
                "poster": "https://pic.maizuo.com/usr/movie/fceeb41a1660d097d02fbcbda3191d8f.jpg",
                "runtime": "124",
                "synopsis": "《阿凡达：水之道》的剧情承接自第一部的5年之后。曾经的地球残疾军人杰克·萨利，如今已经是潘多拉星球纳美族一方部族的族长，并且与爱妻娜塔莉共同育有一对可爱的儿女，日子过得平淡而充实。然而某天，有个部族的兄弟在海岸附近巡逻时遭到利器割喉身亡。通过现场勘查，以及作为前海军陆战队员的敏锐直觉，杰克判断已经有人类的阿凡达混入了部落……",
                "": [],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "曹茜茜",
                "filmName": "您好，北京",
                "filmShowtime": "",
                "grades": "7",
                "id": "6154",
                "isShow": "true",
                "language": "中文",
                "nation": "中国大陆",
                "poster": "https://pic.maizuo.com/usr/movie/a65399cd933324fa9635f6f8127c0cb0.jpg",
                "runtime": "124",
                "synopsis": "影片主要围绕三个不同年龄，不同身份，不同生活经历的北漂人在北京努力奋斗，追寻梦想的故事。",
                "categories": [],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "安迪·苏里亚诺",
                "filmName": "忍者神龟：崛起",
                "filmShowtime": "",
                "grades": "7.6",
                "id": "6149",
                "isShow": "true",
                "language": "英语",
                "nation": "美国",
                "poster": "https://pic.maizuo.com/usr/movie/2a43a75a67c03ba1603e8bed4dbf4aec.jpg",
                "runtime": "124",
                "synopsis": "年末超燃热血动画！忍者神龟重回银幕，逆转未来拯救世界！2044年的纽约，大反派朗格勾结外星恶势力试图毁灭地球，大量外星人通过神秘传送门入侵，将城市化为灰烬。忍者神龟们虽负隅顽抗仍不敌敌人攻势，死伤惨重。怀抱着忍者最强武器——希望，忍者神龟们决定回到过去时空，找到开启传送门的钥匙，阻止朗格，恢复世界和平。李奥纳多的弟子凯西肩负起这一使命，他在过去时空与女记者艾普利尔•奥尼尔成功接头，并和忍者神龟李奥纳多、米开朗基罗、拉斐尔、多纳太罗汇合，开启了拯救世界的行动。“我们的未来，我们自己做主”忍者神龟们向朗格发起了终极挑战。",
                "categories": [],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "郭帆",
                "filmName": "流浪地球2",
                "filmShowtime": "",
                "grades": "8.5",
                "id": "6118",
                "isShow": "false",
                "language": "中文",
                "nation": "中国大陆",
                "poster": "https://static.maizuo.com/pc/v5/usr/movie/7a8096bcfb12bcfb899b57e6688cff91.jpg",
                "runtime": "145",
                "synopsis": "太阳即将毁灭，人类在地球表面建造出巨大的推进器，寻找新的家园，然而宇宙之路危机四伏，为了拯救地球，流浪地球时代的年轻人再次挺身而出，展开争分夺秒的生死之战...",
                "categories": [],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "饶晓志",
                "filmName": "万里归途",
                "filmShowtime": "",
                "grades": "7.3",
                "id": "6112",
                "isShow": "true",
                "language": "中文",
                "nation": "中国大陆",
                "poster": "https://pic.maizuo.com/usr/movie/f31367bb1a275f032ea3793a0571d9e0.jpg",
                "runtime": "131",
                "synopsis": "电影根据真实事件改编。 努米亚共和国爆发战乱，前驻地外交官宗大伟（张译 饰）与外交部新人成朗（王俊凯 饰）受命前往协助撤侨。任务顺利结束，却得知还有一批被困同胞，正在白婳（殷桃 饰）的带领下，前往边境撤离点。情急之下，两人放弃了回家机会，逆行进入战区。赤手空拳的外交官，穿越战火和荒漠，面对反叛军的枪口，如何带领同胞走出一条回家之路……",
                "categories": [],
                "year": "2021"
            }
        ],
        "totals": "6"
    },
    "msg": "操作成功"
}
```

### 

### 1.2 正在热映电影分页查询

可根据filmName、year进行模糊查询**（有数值且不为NULL时进行模糊查询）**

根据电影id 倒序

pageNum页码

pageSize页内数据条数

| 请求方式 |       路径        | token |
| :------: | :---------------: | :---: |
|   Get    | /film/showingList |   /   |

**Query请求参数**

| 请求参数 |  类型   | 是否必须 |
| :------: | :-----: | :------: |
| filmName | String  |    否    |
|   year   | String  |    否    |
| pageNum  | Integer |    是    |
| pageSize | Integer |    是    |

返回实例：

```java
{
    "code": 200,
    "data": {
        "rows": [
            {
                "actors": [
                    {
                        "avataraddress": "https://static.maizuo.com/pc/v5/usr/movie/4f6aa3e40948c476b5dd27923d966e66.jpg",
                        "name": "谷口悟朗",
                        "role": "蒙奇·D·路飞"
                    },
                    {
                        "avataraddress": "https://pic.maizuo.com/usr/movie/d727837a1a65cf02d1734674f86a1051.jpg",
                        "name": "中井和哉",
                        "role": "罗罗诺亚·索"
                    },
                    {
                        "avataraddress": "https://pic.maizuo.com/usr/movie/1d2c7e8ee9d9b526e3a613ed8353da32.jpg",
                        "name": "冈村明美",
                        "role": "奈美"
                    },
                    {
                        "avataraddress": "https://pic.maizuo.com/usr/movie/71dc2711ab2417422de03bb14423760a.jpg",
                        "name": "山口胜平",
                        "role": "撒谎布"
                    }
                ],
                "director": "谷口悟朗",
                "filmName": "航海王：红发歌姬",
                "filmShowtime": "",
                "grades": "7.9",
                "id": "6166",
                "isShow": "true",
                "language": "日语",
                "nation": "日本",
                "poster": "https://pic.maizuo.com/usr/movie/1f25dd6943762288dfd84b961c98f478.jpg",
                "runtime": "114",
                "synopsis": "令全世界为之疯狂的歌姬·乌塔，她的身世成谜，歌声却被誉为“来自别的次元”。而这次，她将举办演唱会并第一次露出庐山真面目。为了欣赏她的歌声，路飞率领的草帽一伙，以及世界各地的歌迷都汇聚在会场之中。全世界备受瞩目的歌声即将在此回荡。而故事就在乌塔是“杰克斯的女儿”这一令人震惊的发现中拉开帷幕！",
                "categories": [
                    "喜剧",
                    "动画"
                ],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "曹茜茜",
                "filmName": "您好，北京",
                "filmShowtime": "",
                "grades": "7",
                "id": "6154",
                "isShow": "true",
                "language": "中文",
                "nation": "中国大陆",
                "poster": "https://pic.maizuo.com/usr/movie/a65399cd933324fa9635f6f8127c0cb0.jpg",
                "runtime": "124",
                "synopsis": "影片主要围绕三个不同年龄，不同身份，不同生活经历的北漂人在北京努力奋斗，追寻梦想的故事。",
                "categories": [],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "安迪·苏里亚诺",
                "filmName": "忍者神龟：崛起",
                "filmShowtime": "",
                "grades": "7.6",
                "id": "6149",
                "isShow": "true",
                "language": "英语",
                "nation": "美国",
                "poster": "https://pic.maizuo.com/usr/movie/2a43a75a67c03ba1603e8bed4dbf4aec.jpg",
                "runtime": "124",
                "synopsis": "年末超燃热血动画！忍者神龟重回银幕，逆转未来拯救世界！2044年的纽约，大反派朗格勾结外星恶势力试图毁灭地球，大量外星人通过神秘传送门入侵，将城市化为灰烬。忍者神龟们虽负隅顽抗仍不敌敌人攻势，死伤惨重。怀抱着忍者最强武器——希望，忍者神龟们决定回到过去时空，找到开启传送门的钥匙，阻止朗格，恢复世界和平。李奥纳多的弟子凯西肩负起这一使命，他在过去时空与女记者艾普利尔•奥尼尔成功接头，并和忍者神龟李奥纳多、米开朗基罗、拉斐尔、多纳太罗汇合，开启了拯救世界的行动。“我们的未来，我们自己做主”忍者神龟们向朗格发起了终极挑战。",
                "categories": [],
                "year": "2021"
            },
            {
                "actors": [],
                "director": "饶晓志",
                "filmName": "万里归途",
                "filmShowtime": "",
                "grades": "7.3",
                "id": "6112",
                "isShow": "true",
                "language": "中文",
                "nation": "中国大陆",
                "poster": "https://pic.maizuo.com/usr/movie/f31367bb1a275f032ea3793a0571d9e0.jpg",
                "runtime": "131",
                "synopsis": "电影根据真实事件改编。 努米亚共和国爆发战乱，前驻地外交官宗大伟（张译 饰）与外交部新人成朗（王俊凯 饰）受命前往协助撤侨。任务顺利结束，却得知还有一批被困同胞，正在白婳（殷桃 饰）的带领下，前往边境撤离点。情急之下，两人放弃了回家机会，逆行进入战区。赤手空拳的外交官，穿越战火和荒漠，面对反叛军的枪口，如何带领同胞走出一条回家之路……",
                "categories": [],
                "year": "2021"
            }
        ],
        "totals": "4"
    },
    "msg": "操作成功"
}
```

### 1.3 根据id查询电影详情

| 请求方式 |    路径    | token |
| :------: | :--------: | :---: |
|   Get    | /film/{id} |   /   |

**路径请求参数：id**

| 请求参数 | 类型 | 是否必须 |
| :------: | :--: | :------: |
|    id    | Long |    是    |

返回实例：

```java
{
    "code": 200,
    "data": {
        "actors": [
            {
                "avataraddress": "https://static.maizuo.com/pc/v5/usr/movie/4f6aa3e40948c476b5dd27923d966e66.jpg",
                "name": "谷口悟朗",
                "role": "蒙奇·D·路飞"
            },
            {
                "avataraddress": "https://pic.maizuo.com/usr/movie/d727837a1a65cf02d1734674f86a1051.jpg",
                "name": "中井和哉",
                "role": "罗罗诺亚·索"
            },
            {
                "avataraddress": "https://pic.maizuo.com/usr/movie/1d2c7e8ee9d9b526e3a613ed8353da32.jpg",
                "name": "冈村明美",
                "role": "奈美"
            },
            {
                "avataraddress": "https://pic.maizuo.com/usr/movie/71dc2711ab2417422de03bb14423760a.jpg",
                "name": "山口胜平",
                "role": "撒谎布"
            }
        ],
        "director": "谷口悟朗",
        "filmName": "航海王：红发歌姬",
        "grades": "7.9",
        "id": "6166",
        "isShow": 0,
        "language": "日语",
        "nation": "日本",
        "poster": "https://pic.maizuo.com/usr/movie/1f25dd6943762288dfd84b961c98f478.jpg",
        "runtime": "asf",
        "synopsis": "令全世界为之疯狂的歌姬·乌塔，她的身世成谜，歌声却被誉为“来自别的次元”。而这次，她将举办演唱会并第一次露出庐山真面目。为了欣赏她的歌声，路飞率领的草帽一伙，以及世界各地的歌迷都汇聚在会场之中。全世界备受瞩目的歌声即将在此回荡。而故事就在乌塔是“杰克斯的女儿”这一令人震惊的发现中拉开帷幕！",
        "categories": [
            "喜剧",
            "动画"
        ],
        "year": "2021"
    },
    "msg": "操作成功"
}
```

### 1.4 即将上映电影分页查询

可根据filmName、year进行模糊查询**（有数值且不为NULL时进行模糊查询）**

pageNum页码

pageSize页内数据条数

| 请求方式 |        路径         | token |
| :------: | :-----------------: | :---: |
|   Get    | /film/unShowingList |   /   |

**Query请求参数**

| 请求参数 |  类型   | 是否必须 |
| :------: | :-----: | :------: |
| filmName | String  |    否    |
|   year   | String  |    否    |
| pageNum  | Integer |    是    |
| pageSize | Integer |    是    |





返回实例：

```java
{
    "code": 200,
    "data": {
        "rows": [
            {
                "actors": [],
                "director": "詹姆斯·卡梅隆",
                "filmName": "阿凡达：水之道",
                "filmShowtime": "",
                "grades": "7",
                "id": "6165",
                "isShow": "false",
                "language": "英语",
                "nation": "美国",
                "poster": "https://pic.maizuo.com/usr/movie/fceeb41a1660d097d02fbcbda3191d8f.jpg",
                "runtime": "124",
                "synopsis": "《阿凡达：水之道》的剧情承接自第一部的5年之后。曾经的地球残疾军人杰克·萨利，如今已经是潘多拉星球纳美族一方部族的族长，并且与爱妻娜塔莉共同育有一对可爱的儿女，日子过得平淡而充实。然而某天，有个部族的兄弟在海岸附近巡逻时遭到利器割喉身亡。通过现场勘查，以及作为前海军陆战队员的敏锐直觉，杰克判断已经有人类的阿凡达混入了部落……",
                "types": [],
                "year": "2021"
            },
            {
                "categories": [],
                "director": "郭帆",
                "filmName": "流浪地球2",
                "filmShowtime": "",
                "grades": "8.5",
                "id": "6118",
                "isShow": "false",
                "language": "中文",
                "nation": "中国大陆",
                "poster": "https://static.maizuo.com/pc/v5/usr/movie/7a8096bcfb12bcfb899b57e6688cff91.jpg",
                "runtime": "145",
                "synopsis": "太阳即将毁灭，人类在地球表面建造出巨大的推进器，寻找新的家园，然而宇宙之路危机四伏，为了拯救地球，流浪地球时代的年轻人再次挺身而出，展开争分夺秒的生死之战...",
                "categories": [],
                "year": "2021"
            }
        ],
        "totals": "2"
    },
    "msg": "操作成功"
}
```

------

### 1.5 根据category进行分类分页查询

可根据categoryId进行分页查询

| 请求方式 |   路径    | token |
| :------: | :-------: | :---: |
|   Get    | /film/cid |   /   |

**Query请求参数**

| 请求参数 |  类型   | 是否必须 |
| :------: | :-----: | :------: |
|   cid    | String  |    是    |
| pageNum  | Integer |    是    |
| pageSize | Integer |    是    |

返回实例：

```java
{
    "code": 200,
    "data": {
        "rows": [
            {
                "filmName": "万里归途",
                "id": "6112",
                "poster": "https://pic.maizuo.com/usr/movie/f31367bb1a275f032ea3793a0571d9e0.jpg",
                "year": "2021"
            },
            {
                "filmName": "忍者神龟：崛起",
                "id": "6149",
                "poster": "https://pic.maizuo.com/usr/movie/2a43a75a67c03ba1603e8bed4dbf4aec.jpg",
                "year": "2021"
            }
        ],
        "totals": "2"
    },
    "msg": "操作成功"
}
```


