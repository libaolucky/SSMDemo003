<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

<html>
<head>
    <title>springmvc 之 ajax和mvc收参数 练习2</title>
</head>
<body>
 <div>
     <input type="button" value="ajax的01中传参 --- k-v 结构或者对象" id="a1"><br>
     <input type="button" value="ajax的02中传参 --- 对象" id="a2">  <br>
     <input type="button" value="ajax的03中传参数--- 传数组 或者集合" id="a3"> <br>
     <input type="button" value="ajax的04中传参数--- 传json对象" id="a4"> <br>
     <input type="button" value="ajax的05中传参数--- 传多个对象" id="a5"> <br>
     <input type="button" value="ajax的06中传参数--- 传批量对象传参" id="a6"> <br>
     <input type="button" value="ajax的07中传参数--- 传 map 传参" id="a7"> <br>
     <input type="button" value="ajax的08中--- 对象——常用类型 混合，常见于 带参数的分页查询" id="a8">
 </div>
<script>
    $(function () {
        // 1、k-v 结构或者对象
        $("#a1").click(function () {
            $.ajax({
                url:"/zhuce/a1",
                type:"POST",
                data:{
                    'lname':"管子",
                    'pwd':"12356"
                },
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }
            })
        });
        //2、 收参 --- 对象
        $("#a2").click(function () {
            var login={};
            login.lname="垚垚";
            login.pwd="16272384";

            $.ajax({
                url:"/zhuce/a1",
                type:"POST",
                data:login,
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }
            })
        });

        // 3、ajax 传数组，集合  应用的范围是 批量删除 ，比如 ids[]={3,5,7,9}
        $("#a3").click(function () {
            var names=new Array();
            names.push("大娃");
            names.push("二娃");
            names.push("三哇");

            //把数组使用ajax传递
            $.ajax({
                url:"/zhuce/a3",
                type:"POST",
                data:{'names':names},
                dataType:'JSON',
                success:function (res) {
                    console.log(res)
                }
            })
        })

        // 4、ajax 传json对象
        $("#a4").click(function () {
            // json 对象 浏览器中看的请求带颜色的
            var login={   // var 的对象  给对象赋值
            lname:"欣欣子",
            pwd:"123435",
                goodfirends:[
                    {
                        name:"包子",
                        age:19
                    },
                    {
                        name:"包青天",
                        age:22
                    },
                    {
                        name:"孙悟空",
                        age:66
                    }
                ],
                aiHao:[3,34,19]
            };
            //var 出来的对象，他是个对象，如果直接传输，www.urlxxx 传递的，是黑色的
            //越是复杂的 请求， 越需要 转成json 来请求。
            // 因为是普通的 请求 是很多个 k-v 结构，后台收取 特别麻烦，所以就需要把复杂对象转换成json对象
            //然后  后台就方便多了 前后端 项目， 一般都用json传递！！！
            $.ajax({
                url:'/zhuce/a4',
                type:'POST',
               data:JSON.stringify(login),   //变成json对象后，就需要 Content-Type 更改为：
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON",
                success:function (rs) {
                    console.log(rs)
                }

            })



        });

        // 5、传多个对象
        $("#a5").click(function () {   // 不常见，因为  发货单，上面是收货人的对象 ，下面是产品对象
            $.ajax({
                url:"/zhuce/a5",
                type:"POST",
                dataType:"json",
                data:{
                    'goodfirend.name':'兹子',
                    'goodfirend.age':20,
                    'cat.catid':776,
                    'cat.catSex':'女'
                },
                success:function (res) {
                    console.log(res)
                }
            });
        })

        // 6、多个对象批量传参
        $("#a6").click(function () {
            var goodfirendList=[];
            for (var i = 0; i <5 ; i++) {
                var lover={
                    name:"鹏鹏"+i,
                    age:22
                }
                goodfirendList.push(lover)
            }
            //多个对象，就属于复杂的  ，复杂用 json
           $.ajax({
               url:"/zhuce/a6",
               type:"POST",
               data:JSON.stringify(goodfirendList),
               // dataType:"get",  get请求是无法 传输 json 协议 和 json数据的！！！
               // get 是没有方法体的
               dataType:"json",
               contentType:"application/json;charset=UTF-8",
               success:function (r) {
                   console.log(r)
               }
           });
        })

        // 7、map传参   翻版的第一种  不常用，要会 map+json 常用
        $("#a7").click(function () {
            var map={
                'lname':"张子",
                'pwd':"1235629"
            };
            $.ajax({
                url:"/zhuce/a7",
                type:"POST",
                dataType:"json",
                data:JSON.stringify(map),
                contentType:"application/json;charset=UTF-8",
                success:function (res) {
                    console.log(res)
                }

            });
        })

        //8、对象——常用类型 混合 常见于 分页  ajax08
        $("#a8").click(function () {
            $.ajax({
                url:"/zhuce/a8",
                type:"post",
                dataType:'json',
                data:{
                    'name':'米啦',   //4 个k-v 是3个参数，name和age 是对象  和其他两个参数
                    'age':20,
                    'pageSize':5,
                    'page':2
                },
                success:function (r) {
                    console.log(r)
                }
            });
        })
    })
</script>


</body>
</html>
