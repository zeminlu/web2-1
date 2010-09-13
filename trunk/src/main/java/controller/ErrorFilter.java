package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		try {
			chain.doFilter(request, response);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch ( NotFoundException e ) {
			// Url basura - Recurso no disponible
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (IllegalArgumentException e){
			// Argumentos basura - Error del cliente
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (InvalidHeaderException e) {
			// Se la mandaron en el header
			resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
		} catch (Exception e) {
			//Error interno - Nosotros nos la mandamos
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
