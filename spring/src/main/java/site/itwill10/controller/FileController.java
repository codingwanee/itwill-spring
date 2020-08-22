package site.itwill10.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import site.itwill10.dto.FileBoard;
import site.itwill10.service.FileBoardService;

//ApplicationContextAware : setApplicationContext() 추상메소드가 선언된 인터페이스
//setApplicationContext() 메소드를 오버라이드 선언하면 메소드의 매개변수에 
//ApplicationContext 인스턴스를 자동으로 제공받아 필드값 변경 가능
@Controller
public class FileController implements ApplicationContextAware {
	@Autowired
	private FileBoardService fileBoardService;
	
	//WebApplicationContext : SpringMVC에서 Bean Configuration File을 읽어
	//Spring Bean으로 등록하는 인스턴스(Spring Container)
	private WebApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//WebApplicationContext 인터페이스는 ApplicationContext 인터페이스의 
		//자식 인터페이스이므로 객체 형변환을 이용하여 필드값 변경
		context=(WebApplicationContext)applicationContext;		
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
	
	/*
	//MultipartHttpServletRequest : "multipart/form-data" 형식으로 전달된
	//입력값과 입력파일을 제공받기 위한 인스턴스
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String uploader=request.getParameter("uploader");
		//MultipartFile : 입력파일 정보를 저장하기 위한 인터페이스
		//MultipartHttpServletRequest.getFile(String parameterName)
		// => 입력파일을 전달받아 MultipartFile 인스턴스에 저장하여 반환하는 메소드
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		//MultipartFile.isEmpty() : 입력파일이 존재하지 않을 경우 true를 반환하는 메소드
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//파일 업로드 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirPath=request.getServletContext().getRealPath("/resources/file");
		
		//업로드 파일을 서버에 저장하기 File 인스턴스 생성 - 파일 경로 및 파일명 설정 
		//MultipartFile.getOriginalFilename() : 업로드 파일명을 반환하는 메소드
		File file=new File(uploadDirPath, uploadFile.getOriginalFilename());
		
		//업로드 파일을 File 인스턴스를 이용하여 서버에 저장 - 파일 업로드 처리
		//MultipartFile.transferTo(File file) : 업로드 파일을 서버에 저장하는 메소드
		// => 서버에 동일한 이름의 파일이 존재할 경우 덮어씌우기
		uploadFile.transferTo(file);
		
		request.setAttribute("uploader", uploader);
		request.setAttribute("originalFileName", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	*/
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam String uploader
			,@RequestParam MultipartFile uploadFile, Model model) throws IllegalStateException, IOException {
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//WebApplicationContext 인스턴스(Spring Container)의 메소드를 호출하여 
		//ServletContext 인스턴스를 반환받아 업로드 디렉토리의 시스템 경로 반환
		String uploadDirPath=context.getServletContext().getRealPath("/resources/file");
		
		//업로드 파일과 동일한 이름의 파일이 서버에 존재할 경우 업로드 파일명을 
		//변경하여 서버에 저장되도록 작성
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirPath, originalFilename);

		//실제 서버에 저장될 파일명을 저장하기 위한 변수
		String uploadFilename=originalFilename;
		
		//업로드 파일과 동일한 이름의 파일이 서버에 존재할 경우 업로드될 파일명 변경
		int i=1;
		while(file.exists()) {
			int index=originalFilename.lastIndexOf(".");
			uploadFilename=originalFilename.substring(0, index)
					+"_"+i+originalFilename.substring(index);	
			file=new File(uploadDirPath, uploadFilename);
			i++;
		}
		
		uploadFile.transferTo(file);
		
		model.addAttribute("uploader", uploader);
		model.addAttribute("originalFileName", originalFilename);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_ok";
	}

	@RequestMapping(value = "/thumbnail", method = RequestMethod.GET)
	public String thumbnail() {
		return "file/thumbnail";
	}
	
	@RequestMapping(value = "/thumbnail", method = RequestMethod.POST)
	public String thumbnail(@RequestParam MultipartFile imageFile, Model model) throws IllegalStateException, IOException {
		if(imageFile.isEmpty()) {
			return "file/thumbnail_fail";
		}
		
		//입력파일을 전달받아 서버의 업로드 디렉토리에 저장
		String uploadDirPath=context.getServletContext().getRealPath("/resources/file");
		String imageFilename=imageFile.getOriginalFilename();
		File file=new File(uploadDirPath, imageFilename);
		imageFile.transferTo(file);
		
		//업로드된 이미지 파일을 이용하여 썸네일 파일 생성
		//1.이미지 파일을 읽어 이미지를 메모리에 저장
		//BufferedImage : 이미지 파일의 정보를 저장하기 위한 클래스
		//ImageIO.read(File file) : 이미지 파일을 읽어 BufferedImage 인스턴스로 반환하는 메소드
		BufferedImage sourceImage=ImageIO.read(file);
		
		//2.메모리에 저장된 이미지의 크기를 변경하여 썸네일 이미지 생성
		//Scalr.resize(BufferedImage source, Method scalingMethod, Mode resizeMode, int targetSize)
		// => 이미지의 크기를 변경하여 반환하는 메소드
		// => Scalr.Method.AUTOMATIC : 이미지의 폭 또는 높이를 자동 변경
		// => Scalr.Mode.FIT_TO_WIDTH : 이미지의 폭 변경 - 높이 자동 변경
		BufferedImage thumbnailImage=Scalr.resize(sourceImage, Scalr.Method.AUTOMATIC
				, Scalr.Mode.FIT_TO_WIDTH, 400);
		
		//3.메모리에 저장된 썸네일 이미지로 이미지 파일 생성
		// => 생성될 썸네일 이미지 파일의 이름을 설정
		int index=imageFilename.lastIndexOf(".");
		String thumbnailFilename=imageFilename.substring(0, index)
				+"_s"+imageFilename.substring(index);

		index=thumbnailFilename.lastIndexOf(".");
		//ImageIO.write(RenderedImage im, String formatName,File file)
		// => 메모리에 저장된 이미지를 이미지 파일로 생성하는 메소드
		ImageIO.write(thumbnailImage, thumbnailFilename.substring(index+1)
				, new File(uploadDirPath, thumbnailFilename));
				
		model.addAttribute("imageFilename", imageFilename);
		model.addAttribute("thumbnailFilename", thumbnailFilename);
		
		return "file/thumbnail_ok";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String fileUpload() {
		return "file/file_upload";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String fileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getFile().isEmpty()) {
			return "file/file_upload";
		}
		
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");

		//입력파일의 이름을  반환받아 저장
		String origin=fileBoard.getFile().getOriginalFilename();
		//서버에 업로드 되어 저장될 파일명을 생성하여 저장
		// => 업로드 파일명이 중복되지 않도록 날짜와 시간정보(TimeStamp)를 이용하여 파일명 생성
		String upload=System.currentTimeMillis()+"";
		
		//파일 업로드 => 원본 파일명이 아닌 업로드 파일명 이용
		fileBoard.getFile().transferTo(new File(uploadDirPath, upload));
		
		//FileBoard 인스턴스의 필드값 변경
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
		//FILE_BOARD 테이블에 파일 게시글 관련 정보 저장
		fileBoardService.addFileBoard(fileBoard);
		
		//리다이렉트 이동
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
		//서버에 저장된 업로드 파일 삭제
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");
		//File 인스턴스 생성 후 delete() 메소드를 호출하여 파일 삭제
		new File(uploadDirPath, fileBoard.getUpload()).delete();
		
		//FILE_BOARD 테이블에 저장된 게시글 삭제
		fileBoardService.eraseFileBoard(num);
		return "redirect:/file_list";
	}
	
	//서버 업로드 디렉토리에 저장된 파일의 다운로드 기능을 제공하는 메소드
	// => 요청처리 메소드의 반환형을 반드시 ModelAndView 클래스로 작성
	@RequestMapping("/file_download/{num}")
	public ModelAndView fileDownload(@PathVariable int num) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		//다운로드 파일의 정보를 Map 인스턴스를 생성하여 저장
		Map<String, String> fileInfo=new HashMap<String, String>();
		fileInfo.put("uploadDirPath", context.getServletContext().getRealPath("/WEB-INF/upload"));
		fileInfo.put("uploadFileName",fileBoard.getUpload());
		fileInfo.put("originFileName",fileBoard.getOrigin());
		
		//ModelAndView(String beanName, String attributeName, Object attributeValue)
		// => 특정 기능을 제공하는 Spring Bean의 메소드 실행에 필요한 정보를 전달하여 처리
		//파일 다운로드 기능을 제공하는 클래스의 Spring beanName를 Front Controller에게 전달
		// => Front Controller에게 전달된 Spring Bean의 메소드 자동 호출되어 파일 다운로드 기능 제공
		// => BeanNameVeiwResolver 클래스를 이용하여 응답 처리되도록 설정
		return new ModelAndView("fileDownload", "downloadFile", fileInfo);
	}
}











