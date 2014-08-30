package ws.kyberorg.generatorzla;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Class description
 *
 * @author Alexander Muravya <asm@virtalab.net>
 * @since 1.0
 */
public class Generator {

    File file;
    BaseFont bf;
    Font f_title;
    Font f_text;

    public void setFont() throws Exception {
        bf = BaseFont.createFont("/fonts/tahoma.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        f_title = new Font(bf, 14);
        f_text = new Font(bf);
    }

    public void make_invoice() throws Exception {
        setFont();
        Document doc = new Document(PageSize.A4);
        Desktop d = Desktop.getDesktop();
        try {
            file = new File("invoice.pdf");
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();
            Paragraph title = new Paragraph();
            title.setAlignment(Element.ALIGN_CENTER);
            title.setFont(f_title);
            title.add("Счет фактура");//this work!

            doc.add(create_table());

            doc.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PdfPTable create_table() throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(5f);

        PdfPCell cell;

        Phrase ph = new Phrase("Номер");//it's doesn't work ((
        ph.setFont(f_text);

        cell = new PdfPCell(ph);
        table.addCell(cell);
        table.addCell("Nuber");

        return table;
    }
}