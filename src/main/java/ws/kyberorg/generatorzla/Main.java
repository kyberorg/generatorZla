package ws.kyberorg.generatorzla;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Application start class
 *
 * @author Alexander Muravya <asm@virtalab.net>
 * @since 1.0
 */
public class Main {
    static BaseFont bf;
    static Font f_title;
    static Font f_text;

    /**
     * Main method
     * @param args no args accepted
     */
    public static void main(String[] args) throws Exception{
        String fileLocation = System.getProperty("java.io.tmpdir")+ File.separator+"zlo.pdf";
        Document pdf = new Document();
        PdfWriter.getInstance(pdf, new FileOutputStream(fileLocation));
        Main.setFont();

        pdf.open();
        pdf.add(new Paragraph("Terve pirunmaailma!"));
        pdf.add(new Paragraph("Hello evil world!"));

        //А вот с текстом на русском, нужно потрудиться
        Paragraph rusText = new Paragraph();
        //rusText.setAlignment(Element.ALIGN_CENTER);
        rusText.setFont(f_text);
        rusText.add("Привет мир зла!");
        pdf.add(rusText);

        pdf.close();
        System.out.println("Ready to go! PDF located at: " + fileLocation);
    }

    public static void setFont() throws Exception {
        String fontLocation = "/usr/local/share/fonts/tahoma.ttf"; //you should add font to this location before run
        bf = BaseFont.createFont(fontLocation, BaseFont.IDENTITY_H , BaseFont.EMBEDDED);
        f_title = new Font(bf, 14 );
        f_text = new Font(bf);
    }
}
