package br.com.wpsystem.compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

import com.yahoo.platform.yui.compressor.CssCompressor;
import com.yahoo.platform.yui.compressor.JavaScriptCompressor;

public class CompressUtils {
	public static void compressJS(File fileToCompress, File compressedFile)
			throws EvaluatorException, IOException {

		FileReader fr = new FileReader(fileToCompress);
		FileWriter out = new FileWriter(compressedFile);

		JavaScriptCompressor compressor = new JavaScriptCompressor(fr,
				new ErrorReporter() {

					public void warning(String message, String sourceName,
							int line, String lineSource, int lineOffset) {
						if (line < 0) {
							System.err.println("\n[WARNING] " + message);
						} else {
							System.err.println("\n[WARNING] " + line + ':'
									+ lineOffset + ':' + message);
						}
					}

					public void error(String message, String sourceName,
							int line, String lineSource, int lineOffset) {
						if (line < 0) {
							System.err.println("\n[ERROR] " + message);
						} else {
							System.err.println("\n[ERROR] " + line + ':'
									+ lineOffset + ':' + message);
						}
					}

					public EvaluatorException runtimeError(String message,
							String sourceName, int line, String lineSource,
							int lineOffset) {
						error(message, sourceName, line, lineSource, lineOffset);
						return new EvaluatorException(message);
					}
				});

		compressor.compress(out, -1, true, false, false, false);

	}

	public static void compressCSS(File fileToCompress, File compressedFile)
			throws FileNotFoundException, IOException {
		CssCompressor compressor = new CssCompressor(new FileReader(
				fileToCompress));

		FileWriter out = new FileWriter(compressedFile);
		compressor.compress(out, -1);

	}
}
