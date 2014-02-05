<html>
<head>
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>

</head>
<body>
	<h1>Message : ${message}</h1>

	<h1>Click this :</h1>
	<a href="${url}">test</a>

	<div id="myfirstchart" style="height: 250px;"></div>
	<script type="text/javascript">
		$.getJSON('http://localhost:8080/springmvc/find', function(data) {
			
			var obj;
			$.each(data, function() {
				obj = this;
			});

			alert('${test1}');
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

</body>
</html>