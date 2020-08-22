package site.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 기능을 제공하기 위한 클래스
// => Bean Configuration File에서 bean 엘리먼트를 이용하여 Spring Bean 등록 
// => @Component 어노테이션을 이용하여 Spring Bean 등록 - 어노테이션이 인식되도록 패키지 설정
//BeanNameViewResolver에 의해 실행될 Spring Bean 클래스는 반드시 AbstractView 클래스를 상속받아 작성
// => AbstractView 클래스의 추상메소드를 오버라이드 선언 - 클라이언트에게 기능을 제공하는 메소드
public class FileDownload extends AbstractView {
	//클라이언트에 응답될 파일 형식(MimeType)을 변경 - 파일 다운로드 기능
	public FileDownload() {
		//AbstractView.setContentType(String mimeType) : 파일 형식을 변경하는 메소드
		setContentType("application/download;utf-8");
	}
	
	//BeanNameViewResolver에 의해 자동 호출되는 메소드
	// => 요청처리 메소드에서 반환되는 ModelAndView 인스턴스의 공유 인스턴스가 매개변수에 자동 저장
	//파일 다운로드 기능을 제공하기 위한 메소드
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//요청처리 메소드에서 공유된 다운로드 파일정보를 반환받아 저장
		@SuppressWarnings("unchecked")
		Map<String, String> fileInfo=(Map<String, String>)model.get("downloadFile");
		
		//다운로드 파일정보를 반환받아 저장
		String uploadDirPath=fileInfo.get("uploadDirPath");
		String uploadFileName=fileInfo.get("uploadFileName");
		String originFileName=fileInfo.get("originFileName");
		
		//다운로드 파일에 대한 File 인스턴스 생성
		File downloadFile=new File(uploadDirPath, uploadFileName);
		
		//클라이언트에게 파일을 전달하기 위한 응답정보 변경
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		//클라이언트에 저장될 파일명 설정 - 한글 파일명도 전달되도록 부호화 처리
		String downloadFileName=URLEncoder.encode(originFileName,"UTF-8");
		
		//헤더정보에 다운로드 파일명과 전송방식을 변경하여 클라이언에게 전달
		response.setHeader("Content-Disposition", "attachment;filename=\""+downloadFileName+"\";");
		
		//클라이언트에게 원시데이타를 전달하기 위한 출력스트림을 반환받아 저장
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		try {
			//다운로드 파일의 원시데이타를 읽기 위한 입력스트림 생성
			in=new FileInputStream(downloadFile);
			
			//입력스트림에서 원시데이타를 읽어 출력스트림 전달 - 다운로드
			/*
			while(true) {
				int readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			*/
			//Spring Framework에서 제공하는 FileCopyUtils 클래스의 copy() 메소드를 호출하여 파일 복사
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {	}
		}
	}
}
