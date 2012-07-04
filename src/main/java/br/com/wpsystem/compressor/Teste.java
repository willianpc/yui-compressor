package br.com.wpsystem.compressor;

import java.io.IOException;

import org.mozilla.javascript.EvaluatorException;

public class Teste {

	public static void main(String[] args) throws EvaluatorException,
					IOException {

		CompressUtils.compressJS("/home/chamb/ragaboom.js",
						"/home/chamb/ragaboom-min.js");

		// CompressUtils.compressCSS(new File("/home/willian/config.css"), new
		// File("/home/willian/config-min.css"));

	}
}