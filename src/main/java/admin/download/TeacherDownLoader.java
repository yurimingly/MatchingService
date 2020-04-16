package admin.download;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.controller.adminController;
import admin.Dao.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class TeacherDownLoader extends AbstractXlsView
{
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		response.setHeader("Content-Disposition", "attachment; " + "filename=\"Teacher.xls\";");
		
		Sheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);
		
		List<TeacherDto> pageRanks = (List<TeacherDto>)model.get("pageRanks");
		int rowNum = 1;
		for(TeacherDto teacher : pageRanks)
		{
			createPageRankRow(sheet, teacher, rowNum++);
		}
	}
	
	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();//시트로만듬(페이지)
		workbook.setSheetName(0, "학생 회원 정보"); //cell은 0번 인덱스 즉 1번페이지에 페이지순위라는 이름을 추가하겠다는의미
        sheet.setColumnWidth(1, 256*20);//한페이지의 기본길이
        return sheet;
	
	}
	
	private void createColumnLabel(Sheet sheet) {
	Row firstRow = sheet.createRow(0);//줄을만듬 시트에서 0번인덱스의 줄을만들고 
	Cell cell= firstRow.createCell(0);// 0번인덱스에 셀을 저장
	cell.setCellValue("회원 번호");//지금가지고온 셀에대해서 값을 넣어줌 첫번째줄 첫번째  칸엔 순위라는문자열 저장
	
	cell=firstRow.createCell(1);//첫번째줄에서 1번인덱스니까 첫번재칸에 우측으로 한칸에 저장 즉  |deptno|dname|loc|이런식으로되있음
	cell.setCellValue("이름");
	
	cell=firstRow.createCell(2);
	cell.setCellValue("이메일");
	
	cell=firstRow.createCell(3);
	cell.setCellValue("전화번호");
		
	}
	
private void createPageRankRow(Sheet sheet,TeacherDto teacher,int rowNum) 
{
    	Row row=sheet.createRow(rowNum);
    	Cell cell= row.createCell(0);
    	cell.setCellValue(teacher.getT_num());
    	
    	cell = row.createCell(1);
		cell.setCellValue(teacher.getName());
		
		cell=row.createCell(2);
		cell.setCellValue(teacher.getT_email());
		
		cell=row.createCell(3);
		cell.setCellValue(teacher.getT_phone());

    }
	
}
