package joachim.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {
	private OutputStream file;

	public void generatePdf(String fileName, String url, String gsonParserMessage, Logger logger) {
		try {
			file = new FileOutputStream(new File(fileName));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph(gsonParserMessage));
			document.close();
			file.close();
			logger.debug("From GeneratePdf: Generated PDF to FILE -> " + fileName + ", from URL -> " + url);
		} catch (Exception e) {
			logger.debug(e);
		}
	}
}
