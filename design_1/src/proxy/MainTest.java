package proxy;

import java.util.concurrent.atomic.AtomicLong;

import aop.AopBrowser;

/*
 * Proxy는 대리인 이라는 뜻으로써, 무언가를 대신해서 처리하는 것이다. 
 * Proxy 클래스를 통해서 대신 무언가를 전달하는 형태로 설계되며, 실제 클라이언트는 Proxy 클래스로부터 결과를 받는다.
 * Cache의 기능으로도 활용이 가능하다.
 * 한번 메모리에 로드된 것을 남겨둿다가 다시 내려준다.
 * 
 * Spring에서는 많은 어노테이션을 활용하는데 프록시 패턴을 이용해서 aop를 구현할 수 있다. 
 */
public class MainTest {

	public static void main(String[] args) {
//		Browser browser = new Browser("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
		
//		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
		
		
		// aop
//		IBrowser browser = new AopBrowser("wwww.google.com", new Runnable() {
//			
//			@Override
//			public void run() {
//				
//			}
//		}, new Runnable() {
//			
//			@Override
//			public void run() {
//				
//			}
//		});
		
		// 동시성 문제 때문에 
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();
		
		IBrowser browser = new AopBrowser("www.naver.com", 
				() -> {
					System.out.println("before");
					start.set(System.currentTimeMillis());
				}, 
				() -> {
					long now = System.currentTimeMillis();
					end.set(now - start.get());	// 총 소요시간 
				}
		);
		
		// 첫번째 호출 소요시간 1505
		browser.show();
		System.out.println("loading time : " + end.get());

		// 두번째 호출
		browser.show();
		System.out.println("loading time : " + end.get());
		
		// 세번째 호출
		browser.show();
		System.out.println("loading time : " + end.get());
		
		// AOP란 
		// 관점 지향 개념이다. 
		// 실질적으로 특정한 메서드가 있으면 그 메서드에 실행시간을 확인할때나, 
		// 일괄적인 리퀘스트, 리스판스 정보를 확인해서 남길때 코드에 개별적으로 작성하는 것이 아니라 
		// 일괄적으로 특정 클래스, 특정 패키지에 있는 모든 메서드의 전후에 기능을 넣을수 있는 방법을 제공한다.
	}
}
