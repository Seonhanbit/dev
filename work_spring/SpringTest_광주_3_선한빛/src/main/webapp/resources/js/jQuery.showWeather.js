$.fn.showWeather = function(){
	load_kma();
	var target = this;
	
	function load_kma(){
		var url="./jsp/proxy_kma.jsp";
		$.get( url, handle_kma );
	}
	function handle_kma( data ){
		var ctg = $("category", data).text();
		//alert( ctg );
		target.append( "<h2>지역: "+ctg+"</h2>" );//제목 등록
		var selector = "data";// 전체 예보정보 추출
		//var selector = "data:has(day:contains(0))";// 오늘( <day>0</day>) 예보정보만 추출
		$( selector , data).each( handle_data );
	}
	function handle_data(){
		// this는 처리 대상 태그 객체. 여기서는 data 태그.
		var hour = $("hour", this).text();
		var temp = $("temp", this).text();
		var wfKor = $("wfKor", this).text();
		target.append( 
				"<div>시간: "+hour+", 온도: "+temp+", 날씨: "+wfKor+"</div>" );
	}
};