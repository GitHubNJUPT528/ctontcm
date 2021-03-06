<%@ page import="java.util.ArrayList" %>
<%@ page import="transferCenterRoutePlanning.Util.LatLng" %>
<%@ page import="java.util.List" %>
<%@ page import="javafx.scene.control.Alert" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0,user-scalable=no">
    <title>路径规划</title>
    <style>
        html,body{
            height: 100%;
            width: 100%;
            overflow:hidden;
            margin:0;
            font-family: "微软雅黑";
        }
    </style>
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script src="http://api.map.baidu.com/api?type=webgl&v=1.0&ak=9iAk4XnzsGNHk2VZP75CiaoR0R7oCt05"></script>
</head>
<body>

<div id="stationList" class="stationList" style="height:100%;overflow:auto; float:left">
    <ul id="leftStationUl" class="leftStationUl">
        <li id="stationLi_250124" onclick="showLocation250124()" onmouseover="limouseover(this, 250124)" onmouseout="limouseout(this, 250124)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市栖霞区迈皋桥分公司</b>
                    </dt>
                    <dd>地址：南京市栖霞区合班村130号</dd>
<!--                    <dd>客服电话：17361807295</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250133" onclick="showLocation250133()" onmouseover="limouseover(this, 250133)" onmouseout="limouseout(this, 250133)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市建邺区江心洲分公司</b>
                    </dt>
                    <dd>地址：南京市建邺区江心洲星影街32-7</dd>
<!--                    <dd>客服电话：19941503204</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250114" onclick="showLocation250114()" onmouseover="limouseover(this, 250114)" onmouseout="limouseout(this, 250114)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市鼓楼区广东路分公司</b>
                    </dt>
                    <dd>地址：江苏省南京市鼓楼区东瓜圃桥8号</dd>
<!--                    <dd>客服电话：17512519200</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250049" onclick="showLocation250049()" onmouseover="limouseover(this, 250049)" onmouseout="limouseout(this, 250049)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市浦口二部分公司</b>
                    </dt>
                    <dd>地址：江苏省南京市浦口区顶山街道顶山创业园...</dd>
<!--                    <dd>客服电话：025-58739908</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250120" onclick="showLocation250120()" onmouseover="limouseover(this, 250120)" onmouseout="limouseout(this, 250120)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市鼓楼区紫竹林分公司</b>
                    </dt>
                    <dd>地址：江苏省南京市鼓楼区许府巷紫竹林3号</dd>
<!--                    <dd>客服电话：13770577680</dd>-->
                </dl></a>
        </li>
        <li id="stationLi_250115" onclick="showLocation250115()" onmouseover="limouseover(this, 250115)" onmouseout="limouseout(this, 250115)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市鼓楼区石头城分公司</b>
                    </dt>
                    <dd>地址：南京市鼓楼区定淮门17号分公司快递</dd>
<!--                    <dd>客服电话：13002570396</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250112" onclick="showLocation250112()" onmouseover="limouseover(this, 250112)" onmouseout="limouseout(this, 250112)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市鼓楼区虹桥中心分公司</b>
                    </dt>
                    <dd>地址：江苏省南京市鼓楼区虎踞北路100号8...</dd>
<!--                    <dd>客服电话：025-86809283</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250061" onclick="showLocation250061()" onmouseover="limouseover(this, 250061)" onmouseout="limouseout(this, 250061)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市新河西分公司</b>
                    </dt>
                    <dd>地址：江苏省南京市鼓楼区燕山路118号</dd>
<!--                    <dd>客服电话：18013525870</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250111" onclick="showLocation250111()" onmouseover="limouseover(this, 250111)" onmouseout="limouseout(this, 250111)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市鼓楼区中山万豪分公司</b>
                    </dt>
                    <dd>地址：江苏省南京市鼓楼区宁海路街道祁家桥1...</dd>
<!--                    <dd>客服电话：13813906598</dd>-->
                </dl>
            </a>
        </li>
        <li id="stationLi_250135" onclick="showLocation250135()" onmouseover="limouseover(this, 250135)" onmouseout="limouseout(this, 250135)" style="height: 94px; border-bottom: 1px solid rgb(178, 178, 176); background-color: rgb(255, 255, 255); cursor: pointer;">
            <a>
                <dl>
                    <dt>
                        <b>江苏省南京市雨花区共青团路分公司</b>
                    </dt>
                    <dd>地址：南京市雨花台区花神庙十号花神科技园三...</dd>
<!--                    <dd>客服电话：025-85381131</dd>-->
                </dl>
            </a>
        </li>
    </ul>
</div>
<div id="container" style="height:100%; position: relative; overflow: hidden; z-index: 0; background-color: rgb(243, 241, 236); color: rgb(0, 0, 0); text-align: left;">
</div>






<script type="text/javascript">
    var map = new BMapGL.Map("container");
    map.centerAndZoom('南京市',12);
    map.enableScrollWheelZoom(true);

    //装有BMapGL.Maker对象的数组
    var makerList = [];
    // 江苏省区南京转运中心
    var p0 = new BMapGL.Point(118.81611,31.777821);
    // 栖霞区迈皋桥分公司
    var p250124= new BMapGL.Point(118.821565,32.114319);
    // 江心洲分公司
    var p250133= new BMapGL.Point(118.716898,32.048265);
    // 广东路分公司
    var p250114= new BMapGL.Point(118.771426,32.088295);
    // 浦口二部分公司
    var p250049= new BMapGL.Point(118.680943,32.11551);
    // 紫竹林分公司
    var p250120= new BMapGL.Point(118.780865,32.090088);
    // 石头城分公司
    var p250115= new BMapGL.Point(118.757481,32.074374);
    // 虹桥中心分公司
    var p250112= new BMapGL.Point(118.76091,32.085629);
    // 新河西分公司
    var p250061= new BMapGL.Point(118.739278,32.030876);
    // 中山万豪分公司
    var p250111= new BMapGL.Point(118.773292,32.078233);
    // 共青团路分公司
    var p250135= new BMapGL.Point(118.774808,31.992572);



//  只看此两个方法内的ajax请求
    returnLocAndLoadOverlays();
    returnLocAndRtp();







    //导航栏点击事件
    function showLocation250124() {
        map.centerAndZoom(p250124,18);
    }

    function showLocation250133() {
        map.centerAndZoom(p250133,18);
    }
    function showLocation250114() {
        map.centerAndZoom(p250114,18);
    }
    function showLocation250049() {
        map.centerAndZoom(p250049,18);
    }
    function showLocation250120() {
        map.centerAndZoom(p250120,18);
    }
    function showLocation250115() {
        map.centerAndZoom(p250115,18);
    }
    function showLocation250112() {
        map.centerAndZoom(p250112,18);
    }
    function showLocation250061() {
        map.centerAndZoom(p250061,18);
    }

    function showLocation250111() {
        map.centerAndZoom(p250111,18);
    }
    function showLocation250135() {
        map.centerAndZoom(p250135,18);
    }


    function showPoly(pointList){

        //循环显示点对象
        for(let c=0;c<makerList.length;c++){
            console.log(makerList);
            //将途经点按顺序添加到地图上
            var label = new BMapGL.Label(c+1,{offset:new BMapGL.Size(20,-10)});
            makerList[c].setLabel(label);
        }


        //将点击两两分为一组 以便发起路径规划
        var pointTwoArray = [];
        for (let i=0;i<pointList.length;i++) {
            //是否是奇数点
            //是否数组越界
            if (i != (pointList.length - 1)) {
                pointTwoArray.push(pointList.slice(i, i + 2));
            }
        }

        var driving = new BMapGL.DrivingRoute( map, {onSearchComplete: function(results){
                if (driving.getStatus() == BMAP_STATUS_SUCCESS){
                    var pts=  driving.getResults().getPlan(0).getRoute(0).getPath();    //通过驾车实例，获得一系列点的数组
                    var polyline = new BMapGL.Polyline(pts, {
                        strokeColor: "blue",//设置颜色
                        strokeWeight:2, //宽度
                        strokeOpacity:1.0});//透明度);
                    map.addOverlay(polyline);

                }
            }});

        pointTwoArray.forEach(function(value,index){
            driving.search(value[0],value[1]);
        });
        map.setViewport(pointList);

    }


    //定义最优路径控件类
    function ZoomControl() {
        this.defaultAnchor = BMAP_ANCHOR_TOP_RIGHT;
        this.defaultOffset = new BMapGL.Size(20, 20)
    }
    //实现控件并请求规划后的数据
    function returnLocAndRtp() {

        //通过JavaScript的prototype属性继承于BMap.Control
        ZoomControl.prototype = new BMapGL.Control();

        //自定义控件必须实现自己的initialize方法，并且将控件的DOM元素返回
        //在本方法中创建个div元素作为控件的容器，并将其添加到地图容器中
        ZoomControl.prototype.initialize = function(map) {
            //创建一个dom元素
            var div = document.createElement('div');
            //添加文字说明
            div.appendChild(document.createTextNode('最优路线规划'));
            // 设置样式
            div.style.cursor = "pointer";
            div.style.padding = "7px 10px";
            div.style.boxShadow = "0 2px 6px 0 rgba(27, 142, 236, 0.5)";
            div.style.borderRadius = "5px";
            div.style.backgroundColor = "white";
            // 绑定事件
            div.onclick = function(e){

                $.ajax({
                    url:"servlet",
                    data:{
                        action:"routePlanToList"
                    },
                    type:"post",
                    error:function () {
                        alert("请求失败！");
                    },
                    success:function (data) {
                        var startPoint = new BMapGL.Point(data[0].longitude,data[0].latitude);
                        var posList =[] ;
                        for (let x in data) {
                            console.log(data[x]);
                            posList.push(new BMapGL.Point(data[x].longitude,data[x].latitude));

                        }
                        showPoly(posList);


                    },
                    dataType:"json"

                });
                map.centerAndZoom(startPoint,12);
            }
            // 添加DOM元素到地图中
            map.getContainer().appendChild(div);
            // 将DOM元素返回
            return div;
        }
        //创建控件元素
        var myZoomCtrl = new ZoomControl();
        //添加到地图中
        map.addControl(myZoomCtrl);
    }


    //定义加载覆盖物控件类
    function ZoomControlOverlays() {
        this.defaultAnchor = BMAP_ANCHOR_TOP_RIGHT;
        this.defaultOffset = new BMapGL.Size(20,80)
    }
    //实现控件并加载覆盖物的数据
    function returnLocAndLoadOverlays() {

        //通过JavaScript的prototype属性继承于BMap.Control
        ZoomControlOverlays.prototype = new BMapGL.Control();

        //自定义控件必须实现自己的initialize方法，并且将控件的DOM元素返回
        //在本方法中创建个div元素作为控件的容器，并将其添加到地图容器中
        ZoomControlOverlays.prototype.initialize = function(map) {
            //创建一个dom元素
            var div = document.createElement('div');
            //添加文字说明
            div.appendChild(document.createTextNode('加载数据'));
            // 设置样式
            div.style.cursor = "pointer";
            div.style.padding = "7px 10px";
            div.style.boxShadow = "0 2px 6px 0 rgba(27, 142, 236, 0.5)";
            div.style.borderRadius = "5px";
            div.style.backgroundColor = "white";
            // 绑定事件
            div.onclick = function(e){

                $.ajax({
                    url:"servlet",
                    data:{
                        action:"routePlanToMap"
                    },
                    type:"post",
                    error:function () {
                        alert("请求失败！");
                    },
                    success:function (data) {
                        map.clearOverlays();
                        console.log(data);
                        for (let x in data) {
                            console.log(x);

                            let opts = {
                                width : 250,     // 信息窗口宽度
                                height: 50,     // 信息窗口高度
                                title : x , // 信息窗口标题
                                message:""
                            }
                            let expressTotal = Math.floor(Math.random()*10000);
                            let infoWindow = new BMapGL.InfoWindow("待派送件数:"+expressTotal, opts);  // 创建信息窗口对象
                            let point= new BMapGL.Point(data[x].longitude,data[x].latitude);
                            let maker = new BMapGL.Marker(point);
                            makerList.push(maker);
                            map.addOverlay(maker);
                            maker.addEventListener("click",function () {
                                map.openInfoWindow(infoWindow, point); //开启信息窗口
                            });


                        }
                    },
                    dataType:"json"

                });
                map.centerAndZoom('南京市',12);
            }
            // 添加DOM元素到地图中
            map.getContainer().appendChild(div);
            // 将DOM元素返回
            return div;
        }
        //创建控件元素
        var myZoomCtrlOverlays = new ZoomControlOverlays();
        //添加到地图中
        map.addControl(myZoomCtrlOverlays);
    }

</script>


</body>
</html>
