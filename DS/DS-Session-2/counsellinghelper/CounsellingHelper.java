package datastructure_2.counsellinghelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CounsellingHelper {
    List<StudyProgram> listOfPrograms;
    List<Student> listOfStudent;

    public CounsellingHelper() {
        listOfPrograms = new ArrayList<StudyProgram>();
        listOfStudent = new ArrayList<Student>();
    }

    public void processStudentRequests() throws IOException {
        String programFilePath = "Program.xlsx";
        String studentFilePath = "Student.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(programFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = (Sheet) workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        StudyProgram program = new StudyProgram();

        while (iterator.hasNext()) {
            Cell cell = (Cell) iterator.next();
            String programName;
            int capacity;

            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                programName = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                capacity = (int) cell.getNumericCellValue();
                break;
            }
        }

        workbook.close();
        inputStream.close();
    }
}