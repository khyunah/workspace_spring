package com.example.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

// Filter 기능을 활용하기 위해서 구현해야 한다. 
// Servlet ㅡ> http통신을 확장한 클래스 
// 서블릿은 자바언어로 웹 프로그래밍을 하기위해 만들어진 클래스이다.

// 로깅 처리를 많이 한다. 
// url 확인이나 특정 코드를 집어넣어야 할때 사용을 많이 한다. 
@Slf4j
@Component // new해서 메모리에 올려달라라는 어노테이션
@WebFilter(urlPatterns = "/api/*") // /api에 대한 요청만 (FilterExAplication에 어노테이션 달아줘야함)
public class GlobalFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		log.info("doFilter 호출 !");

		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
				(HttpServletResponse) response);

		chain.doFilter(requestWrapper, responseWrapper);
		
		// 주의점 doFilter 메소드 뒤에 코드를 작성해야 한다. 

		String url = requestWrapper.getRequestURI();
		log.info("request url:{}, request body:{}", url, requestWrapper.getContentAsByteArray());
		
		String resContent = new String(responseWrapper.getContentAsByteArray());
		int httpStatusCode = responseWrapper.getStatus();
		
		// 응답을 처리하기 위해서 반드시 코드에 추가해야 한다.
		// 없으면 응답이 오지 않음 . ( 무한정 대기 상태 )
		responseWrapper.copyBodyToResponse();
		log.info("response status:{}, response body:{}", httpStatusCode, resContent);
	}

//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		log.info("제일 먼저 request 에 대해서 처리해보기");
//		
//		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//		log.info("req:{}", httpServletRequest.getProtocol());
//		
//		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//		log.info("res:{}", httpServletResponse.getBufferSize());
//		
//		// 최초로 걸러주고 있기때문에 controller에 못가고 있다. 
//		// 기본적으로 한번읽은 request는 다시 읽을수 없다.
//		
//		// 해결 방안 
//		// ContentCachingRequestWrapper, ContentCachingResponseWrapper 클래스를 이용해야 한다. 
//	}

}
