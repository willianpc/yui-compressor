package br.com.wpsystem.compressor;

import java.io.File;
import java.io.IOException;

import org.mozilla.javascript.EvaluatorException;

public class Teste {

	public static void main(String[] args) throws EvaluatorException,
			IOException {

		// CompressUtils.compressJS(new File("/home/willian/master.js"), new
		// File("/home/willian/master.min.js"));
		CompressUtils.compressCSS(new File("/home/willian/config.css"),
				new File("/home/willian/config-min.css"));

	}
}