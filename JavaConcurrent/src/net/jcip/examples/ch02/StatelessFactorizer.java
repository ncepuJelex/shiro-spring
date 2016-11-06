package net.jcip.examples.ch02;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class StatelessFactorizer extends GenericServlet implements Servlet {

	private static final long serialVersionUID = -5115496610206468584L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		BigInteger i = extractFromRequest(req);
		BigInteger [] factors = factor(i);
		encodeIntoResponse(resp,factors);
	}

	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
	}

	private BigInteger[] factor(BigInteger i) {
		return new BigInteger[]{i};
	}

	private BigInteger extractFromRequest(ServletRequest req) {
		return new BigInteger("7");
	}

}
