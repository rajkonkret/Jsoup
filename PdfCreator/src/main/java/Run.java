import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static com.itextpdf.text.pdf.BaseFont.CP1250;

public class Run {
    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld2.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, CP1250, BaseFont.EMBEDDED, 16,0,BaseColor.RED);
        Chunk chunk = new Chunk("Helloą nn nć  World ąćęłńśżźó", font);

        document.add(chunk);
        document.close();
    }
}

