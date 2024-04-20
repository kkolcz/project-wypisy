package wypisy.example.wypisy.PDF;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import wypisy.example.wypisy.model.Wypis;
import wypisy.example.wypisy.model.WypisLine;

import java.awt.*;

public class Pdf {


    public void ProductList(Wypis wypis , Document document){


        Font fontTitle= FontFactory.getFont((FontFactory.HELVETICA));
        Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);
        fontTitle.setSize(18);


        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();

        float[] columnDefinitionSize = {6,50.33F, 30.33F, 13.33F};
        float[] columnDefinitionSizeDetails = {10F,43.33F};
        PdfPTable table ;
        PdfPTable tableDetails ;

        PdfPCell cell=new PdfPCell();
        float pos = height / 2;

        table = new PdfPTable(columnDefinitionSize);
        table.setHorizontalAlignment(0);
        table.setTotalWidth(width - 70);






        table.setLockedWidth(true);


        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(new Phrase("Nr.", font8));
        table.addCell(new Phrase("Product", font8));
        table.addCell(new Phrase("Opis", font8));
        table.addCell(new Phrase("Ilosc", font8));










        for (int j = 0; j <wypis.getWypisLines().size() ; j++) {

         WypisLine l=wypis.getWypisLines().get(j);

            tableDetails = new PdfPTable(columnDefinitionSizeDetails);
            tableDetails.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
            tableDetails.addCell(new Phrase("Nazwa:", font8));

            tableDetails.getDefaultCell().setBackgroundColor(Color.WHITE);
            tableDetails.addCell(new Phrase(l.getProduct().getName(), font8));

            tableDetails.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
            tableDetails.addCell(new Phrase("Nr.M3:", font8));

            tableDetails.getDefaultCell().setBackgroundColor(Color.WHITE);
            tableDetails.addCell(new Phrase(l.getProduct().getNrM3(), font8));

            tableDetails.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
            tableDetails.addCell(new Phrase("Nazwa M3:", font8));

            tableDetails.getDefaultCell().setBackgroundColor(Color.WHITE);
            tableDetails.addCell(new Phrase(l.getProduct().getNameM3(), font8));


            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(new Phrase(Integer.toString(j+1), font8));

            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);


            table.addCell(tableDetails);
            table.addCell(new Phrase(l.getProduct().getDescription(), font8));

            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(new Phrase(l.getUnit().toString(), font8));







        }






        document.add(table);
        document.newPage();




    }
















}
