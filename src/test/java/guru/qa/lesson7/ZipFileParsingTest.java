package guru.qa.lesson7;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.apache.commons.io.FilenameUtils;
import static org.assertj.core.api.Assertions.assertThat;

public class ZipFileParsingTest {
    @Test
    void testZipFiles() throws IOException, CsvException {
        try (ZipFile zipFile = new ZipFile("src\\test\\resources\\files\\resources.zip")) {
            Enumeration<? extends ZipEntry> e = zipFile.entries();
            while (e.hasMoreElements()) {
                ZipEntry entry = e.nextElement();
                String extension =FilenameUtils.getExtension(entry.getName());
                InputStream is= zipFile.getInputStream(entry);
                switch (extension){
                    case ("xls"):
                        XLS xls=new XLS(is);
                        assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(2)
                                .getStringCellValue()).isEqualTo("Значение1");
                        break;
                    case ("pdf"):
                        PDF pdf=new PDF(is);
                        System.out.println();
                        assertThat(pdf.text.startsWith("A Simple PDF File"));
                        break;
                    case ("scv"):
                        CSVReader csvReader= new CSVReader(new InputStreamReader(is));
                        List<String[]> list = csvReader.readAll();
                        assertThat(list)
                                .hasSize(2)
                                .contains(
                                        new String[] {"Author", "Book"},
                                        new String[] {"Pushkin", "Medniy Vsadnik"}
                                );
                        break;
                    }

                }
            }

        }
    }

