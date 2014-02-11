<html>
<head>
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>



  <script src="http://flot.googlecode.com/svn/trunk/jquery.flot.js"></script>
  <script src="http://www.jolokia.org/dist/0.82/js/jolokia-min.js"></script>
  <script src="http://www.jolokia.org/dist/0.82/js/jolokia-simple-min.js"></script>
  <script src="https://github.com/douglascrockford/JSON-js/raw/master/json2.js"></script>

  </head>
<body>
	<h1>Message : ${message}</h1>

	<h1>Click this :</h1>
	<a href="${url}">test</a>

	<div id="myfirstchart" style="height: 250px;"></div>
	<h1>Jolokia Memory Plot Demo</h1>

	<div id="memory" style="width: 600px; height: 300px; margin-top: 20px;"></div>
	<input type="submit" id="gc" value="Garbage Collection" />

	<script id="source" language="javascript" type="text/javascript">
		var j4p = new Jolokia({
			url : "http://localhost:8080/springmvc/jolokia",
			jsonp : true
		});
		
		var routeList = j4p.search("org.apache.camel:type=routes,*");
		alert(routeList);

	</script>



<!-- 	<script type="text/javascript">
		alert('hhh');
		$.getJSON('http://localhost:8080/springmvc/find', function(data) {
			alert(data);
			var obj;
			$.each(data, function() {
				obj = this;
			});

			alert("${test1}");
			Morris.Bar({
				element : 'myfirstchart',
				data : [ {
					y : 'Home',
					a : 100
				}, {
					y : 'Ciggrate',
					a : 75,
					b : 65
				} ],
				xkey : 'y',
				ykeys : [ 'a' ],
				labels : [ 'Series A' ]
			});

		});
	</script>
 -->



</body>
</html>