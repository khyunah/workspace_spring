package proxy;

/*
 * Proxy는 대리인 이라는 뜻으로써, 무언가를 대신해서 처리하는 것이다. 
 * Proxy 클래스를 통해서 대신 무언가를 전달하는 형태로 설계되며, 실제 클라이언트는 Proxy 클래스로부터 결과를 받는다.
 * Cache의 기능으로도 활용이 가능하다.
 * 한번 메모리에 로드된 것을 남겨둿다가 다시 내려준다.
 */
public class MainTest {

	public static void main(String[] args) {
//		Browser browser = new Browser("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
		
		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
	}
}
