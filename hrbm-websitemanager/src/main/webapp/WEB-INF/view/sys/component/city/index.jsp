<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<script>
    $(function(){
        init();
        //initShowTab();
        initSelect();
    });

    function initSelect(){
    	
        
        if($.trim('${defaultCode}')!==""){
            $.post("${ctx}/city/my-city.xf",{code:'${defaultCode}'},function(result){
            	     $("#province_${targetId} li[id='"+result.pid+"']").trigger("click");
                    // myCity = result;
            },"JSON");
        }

    }

    function initShowTab(){
        $('#myTabs_${targetId} a').click(function (e) {
            e.preventDefault();
            $(this).tab('show');
        })
    }
    function init(){
        $("#province_${targetId} li").on("click",function(){

            addSelectedFlag(this);
            var p = $(this);
            p.siblings().removeClass("selected");
            $("#city_${targetId}").empty();
            $("#district_${targetId}").empty();
            $('#myTabs_${targetId} a[href="#city_${targetId}"]').attr("pid", p.attr("id"));
            $('#myTabs_${targetId} a[href="#city_${targetId}"]').tab('show');
            getCitys(p.attr("id"), function (results) {
                var cityHtml="";
                $.each(results,function(index,value){
                    cityHtml+= '<li' +
                            ' id="'+value.id+'" code="'+value.code+'" pid="'+value.pid+'"><a  href="javascript:void(0)">'+value.name+'</a></li>';
                });
                $("#city_${targetId}").html(cityHtml);
                //触发事件
                if($.trim('${defaultCode}')!==""){
                    $("#city_${targetId} li[code='${defaultCode}']").trigger("click");
                }
            });
        });
        $("#city_${targetId}").on("click","li",function(){
            
            addSelectedFlag(this);
            var p = $(this);
            p.siblings().removeClass("selected");
            $('#myTabs_${targetId} a[href="#district_${targetId}"]').attr("pid", p.attr("id"));
            $("#district_${targetId}").empty();
            $('#myTabs_${targetId} a[href="#district_${targetId}"]').tab('show')
            getCitys(p.attr("id"), function (results) {
                var distrctHtml="";
                $.each(results,function(index,value){
                    distrctHtml+= '<li ' +
                            ' id="'+value.id+'" code="'+value.code+'" pid="'+value.pid+'"><a  href="javascript:void(0)">'+value.name+'</a></li>';
                });
                $("#district_${targetId}").html(distrctHtml);
                //触发事件
//                 if($.trim('${defaultCode}')!==""){
//                     $("#district_${targetId} li[code='${defaultCode}']").trigger("click");
//                 }
            });

        });
        //添加标签
        $("#district_${targetId}").on("click","li",function(){
            var value ={};
            var provinceName = $("li.selected",$("#province_${targetId}")).find("a").text();
            var cityName = $("li.selected",$("#city_${targetId}")).find("a").text();
            var countyName = $(this).find("a").text();
            var allName = provinceName+" "+cityName+" " +countyName;
            value.name=$.trim($(this).text());
            value.id=$.trim($(this).attr("id"));
            value.code=$.trim($(this).attr("code"));
            value.pid=$.trim($(this).attr("pid"));
            value.allname=allName;
            selcity.callBack('${targetId}',value);
		});
    }
    function getCitys(pId,callback){
        $.post("${ctx}/city/city-json.xf",{pId:pId},callback,"JSON");
    }

    function addSelectedFlag(element){
        $(element).addClass("selected");
    }


</script>
	<ul class="nav nav-tabs" id="myTabs_${targetId}">
		<li class="active"><a data-toggle="tab" href="#province_${targetId}">省份</a></li>
		<li><a data-toggle="tab" href="#city_${targetId}">市区</a></li>
		<li><a data-toggle="tab" href="#district_${targetId}">区县</a></li>
	</ul>
	<div class="tab-content">
		<ul id="province_${targetId}" class="tab-pane in active province">
			 <c:forEach items="${provincesList}" var="province" varStatus="count">
	            <li title="" id="${province.id}" code="${province.code}" pid="${province.pid}" ><a href="javascript:void(0)">${province.name}</a></li>
        	</c:forEach>
		</ul>
		<ul id="city_${targetId}" class="tab-pane city">
		</ul>
		<ul id="district_${targetId}" class="tab-pane county">
		</ul>
	</div>
</html>
