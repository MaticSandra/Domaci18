package Zadatak1;

import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Zadatak {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream("Spisak.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i < 5; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cellIme = row.getCell(0);
                XSSFCell cellPrezime = row.getCell(1);
                String ime = cellIme.getStringCellValue();
                String prezime = cellPrezime.getStringCellValue();
                System.out.println(ime + " " + prezime);
            }
            System.out.println();

            Faker faker = new Faker();
            for (int i = 5; i < 10; i++) {
                XSSFRow row = sheet.createRow(i);
                XSSFCell cellIme = row.createCell(0);
                XSSFCell cellPrezime = row.createCell(1);
                cellIme.setCellValue(faker.name().firstName());
                cellPrezime.setCellValue(faker.name().lastName());
            }

            for (int i = 0; i < 10; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cellIme = row.getCell(0);
                XSSFCell cellPrezime = row.getCell(1);
                String ime = cellIme.getStringCellValue();
                String prezime = cellPrezime.getStringCellValue();
                System.out.println(ime + " " + prezime);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
