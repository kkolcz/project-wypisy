package wypisy.example.wypisy.PDF;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Generator extends PdfPageEventHelper {

    public String nr="";





    @Override
    public void onStartPage(PdfWriter writer, Document document) {

        nr="555";
        if (nr.length()<9){
            StringBuilder stringBuilder=new StringBuilder();
            for (int i =nr.length(); i <9 ; i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(nr);
            nr=stringBuilder.toString();
        }




        PdfPTable table2 = new PdfPTable(2);
        table2.setTotalWidth(48);
        table2.setWidths(new int[]{20,28});
        table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);


        // step 2: create a header
        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(510);
        table.setWidths(new int[]{38, 36, 36});
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setPaddingBottom(10);
        table.getDefaultCell().setBorder(Rectangle.BOTTOM);

        PdfPCell emptyCell = new PdfPCell(new Paragraph(""));
        emptyCell.setBorder(Rectangle.NO_BORDER);


        Paragraph title =  new Paragraph("Wypis Materiałowy", new Font(Font.COURIER, 20, Font.BOLD));
        Paragraph title2 =  new Paragraph("FurnMaster", new Font(Font.COURIER, 20, Font.BOLD));
        PdfPCell titleCell = new PdfPCell(title);
        PdfPCell titleCell2 = new PdfPCell(title2);

        titleCell.setPaddingBottom(10);
        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleCell.setBorder(Rectangle.NO_BORDER);

        titleCell2.setPaddingBottom(10);
        titleCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleCell2.setBorder(Rectangle.NO_BORDER);





        table.addCell(titleCell2);
        table.addCell(emptyCell);

        table.addCell(titleCell).setHorizontalAlignment(Element.ALIGN_RIGHT);



        Font cellFont = new Font(Font.HELVETICA, 15);

        table.addCell(new Paragraph("", cellFont));
        table.addCell(new Paragraph("Nr. "+nr, cellFont));
        table.addCell(new Paragraph("", cellFont));


        table.writeSelectedRows(0, -1, 34, 828, writer.getDirectContent());
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        // step 3: create a footer
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(510);
        table.setWidths(new int[]{50, 50});
        table.getDefaultCell().setPaddingBottom(5);
        table.getDefaultCell().setBorder(Rectangle.TOP);

        Paragraph title =  new Paragraph("Footer", new Font(Font.HELVETICA, 10));
        PdfPCell titleCell = new PdfPCell(title);
        titleCell.setPaddingTop(4);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell.setBorder(Rectangle.TOP);
        table.addCell(titleCell);

        Paragraph pageNumberText =  new Paragraph("Page " + document.getPageNumber(), new Font(Font.HELVETICA, 10));
        PdfPCell pageNumberCell = new PdfPCell(pageNumberText);
        pageNumberCell.setPaddingTop(4);
        pageNumberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pageNumberCell.setBorder(Rectangle.TOP);
        table.addCell(pageNumberCell);

        table.writeSelectedRows(0, -1, 34, 36, writer.getDirectContent());
    }

}
