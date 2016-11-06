<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>谷歌search</title>
<style type="text/css">
	#searchDiv {
		position: absolute;
		left: 50%;
		top: 40%;
		margin-left: -200px;
		margin-top: -100px;
	}
	#searchBtn {
		background-color: green;
		color: skyblue;
	}
	.mouseOver {
		background-color: orange;
		cursor: pointer;
	}
	.mouseOut {
		background-color: #FFFAFA;
	}
</style>

<script type="text/javascript">

	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch(e) {
			try {
				return new ActvieXObject("Msxml2.XMLHTTP");
			} catch(e) {
				try {
					return new ActvieXObject("Microsoft.XMLHTTP");
				} catch(e) {
					alert("哥们，你丫的用的什么浏览器啊！");
					throw e;
				}
			}
		}
	};
	
	function setContents(contents) {
		clearContent();
		//美化用的
		setLocation();
		
		var tbody = document.getElementById('contentBody');
		var keywords= document.getElementById('keywords');

		for(var i=0,size=contents.length; i<size; i++) {
			
			var tr = document.createElement("tr");
			
			var td = document.createElement("td");
			td.setAttribute("border","0");
			td.setAttribute('bgColor','#FFFAFA');
			td.onmouseover = function() {
				this.className = 'mouseOver';
			};
			td.onmouseout = function() {
				this.className = 'mouseOut';
			};
			console.log(td);
			//把选中的选项显示到搜索框中
			td.onclick = function() {
				
			};
			
			var textNode = document.createTextNode(contents[i]);
			td.appendChild(textNode);
			tr.appendChild(td);
			tbody.appendChild(tr);
			
			
		}	
	};
	
	function setLocation() {
		var content = document.getElementById('keywords');
		var width = content.offsetWidth; //输入框的宽度
		
		var left = content['offsetLeft']; //距离左边框的距离
		var top = content['offsetTop'] + content.offsetHeight;//输入框高度+输入框到顶部距离
		
		var popDiv = document.getElementById('popDiv');
		popDiv.style.border = "solid green 1px;";
		popDiv.style.left = left + 'px';
		popDiv.style.top = top + 'px';
		popDiv.style.width = width + 'px';
		
		var contentTable = document.getElementById('contentTable');
		contentTable.style.width = width + 'px';
		
	};
	
	function clearContent() {
		var tbody = document.getElementById('contentBody');
		while(tbody.children.length>0) {
			tbody.deleteRow(0);
		}
		/*
			这种方式 也行
		var size = tbody.childNodes.length;
		for(var i=size-1; i>=0; i--) {
			tbody.removeChild(tbody.childNodes[i]);
		} */
		document.getElementById('popDiv').style.border = 'none';
	};

	function getContent(obj) {
		var content = obj.value.replace(/(^\s*)|(\s*$)/g,'');
		//如果输入为空或者空白字符，直接返回
		if(content=='') {
			clearContent();
			return;
		}
		var xmlHttp = createXMLHttpRequest();
		var url = 'search?keywords='+content;
		//true:相当于ajax请求中async:false
		xmlHttp.open('GET',url,true);
		
		xmlHttp.send(null);
		
		xmlHttp.onreadystatechange = function() {
			//4:表示状态完成
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var result = xmlHttp.responseText;
				var jsonResult = eval('(' + result + ')');
				console.log(jsonResult);
				setContents(jsonResult);
			}
		};
	};
	
	window.onload = function() {
		var keywords =  document.getElementById("keywords");
		keywords.focus();
		var tbody = document.getElementById('contentBody');
		//键盘点击事件
		keywords.onkeyup = function() {
			getContent(this);
		}
		
		keywords.onblur = function() {
			clearContent();
		};
		
		keywords.onfocus = function() {
			getContent(this);
		}
		
	};
</script>

</head>
<body>

	<div id="searchDiv">
		<input type="text" id="keywords" size=50 >
		<input type="button" value="谷歌一下" width="50px" id="searchBtn">
		<div id="popDiv">
			<table id="contentTable" bgcolor="#FFFAFA" border="0" cellspacing="0"
					cellpadding="0">
				<tbody id="contentBody">
 				</tbody>
			</table>
		</div>
	</div>

</body>
</html>