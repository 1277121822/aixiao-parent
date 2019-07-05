package poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author djb
 * @create 2019-05-31 14:25
 */
public class TestPOI {

    @Test
    public void test() throws Exception{
        //只支持.xls
        String filePath = "C:\\Users\\D1277\\Desktop\\爱笑\\18软C.xls";
        //包装一个excel对象
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
        //读取文件中的第一个Sheet标签页
        HSSFSheet hssfSheet = workbook.getSheetAt(0);
        //遍历标签页的所有行
        for (Row row : hssfSheet) {
            System.out.println();
            /*for (Cell cell : row) {
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                System.out.println(value+" ");

            }*/
            int rowNum = row.getRowNum();
            if (rowNum == 0)continue;
            row.getCell(0).setCellType(CellType.STRING);
            row.getCell(1).setCellType(CellType.STRING);
            row.getCell(2).setCellType(CellType.STRING);
            String snoStr = row.getCell(0).getStringCellValue();

            if (StringUtils.isEmpty(snoStr))continue;
            Long sno = Long.parseLong(snoStr);
            String username = row.getCell(1).getStringCellValue();
            String sexStr = row.getCell(2).getStringCellValue();

            System.out.println(sno+","+username+","+sexStr);

        }

    }
}
