package proxy;

public class Browser implements IBrowser {

	private String url;
	
	public Browser(String url) {
		this.url = url;
	}
	
	@Override
	public Html show() {
		System.out.println("browser loading html from : " + url);
		return new Html(url);
		// 브라우저에서는 어떤 페이지를 본다 라고 할때 매번 새로운 html 파일을 만들어서 
		// 클라이언트에 내려주는 형태 
	}
}
