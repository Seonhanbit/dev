package edu.ssafy.chap11.sax;

public class Check {
	//속성 값까지 6개
//	<Check code="1001" date="2010.10.01">
//	<Clean>H</Clean>
//	<Ready>H</Ready>
//	<Response>M</Response>
//	<Request/>
//	</Check>
		private String code;
		private String date;
		private String clean;
		private String ready;
		private String response;
		private String request="";
		
		
		public Check() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Check(String code, String date, String clean, String ready,
				String response) {
			super();
			this.code = code;
			this.date = date;
			this.clean = clean;
			this.ready = ready;
			this.response = response;
		}
		public Check(String code, String date, String clean, String ready,
				String response, String request) {
			super();
			this.code = code;
			this.date = date;
			this.clean = clean;
			this.ready = ready;
			this.response = response;
			this.request = request;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getClean() {
			return clean;
		}
		public void setClean(String clean) {
			this.clean = clean;
		}
		public String getReady() {
			return ready;
		}
		public void setReady(String ready) {
			this.ready = ready;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getRequest() {
			return request;
		}
		public void setRequest(String request) {
			this.request = request;
		}
		public String toString(){
			return code+"\t: "+date+"\t: "
			+clean+"\t: "+ready+"\t: "+response+"\t: "+request;
		}

}
