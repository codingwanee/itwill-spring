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

//ApplicationContextAware : setApplicationContext() �߻�޼ҵ尡 ����� �������̽�
//setApplicationContext() �޼ҵ带 �������̵� �����ϸ� �޼ҵ��� �Ű������� 
//ApplicationContext �ν��Ͻ��� �ڵ����� �����޾� �ʵ尪 ���� ����
@Controller
public class FileController implements ApplicationContextAware {
	@Autowired
	private FileBoardService fileBoardService;
	
	//WebApplicationContext : SpringMVC���� Bean Configuration File�� �о�
	//Spring Bean���� ����ϴ� �ν��Ͻ�(Spring Container)
	private WebApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//WebApplicationContext �������̽��� ApplicationContext �������̽��� 
		//�ڽ� �������̽��̹Ƿ� ��ü ����ȯ�� �̿��Ͽ� �ʵ尪 ����
		context=(WebApplicationContext)applicationContext;		
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
	
	/*
	//MultipartHttpServletRequest : "multipart/form-data" �������� ���޵�
	//�Է°��� �Է������� �����ޱ� ���� �ν��Ͻ�
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String uploader=request.getParameter("uploader");
		//MultipartFile : �Է����� ������ �����ϱ� ���� �������̽�
		//MultipartHttpServletRequest.getFile(String parameterName)
		// => �Է������� ���޹޾� MultipartFile �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		//MultipartFile.isEmpty() : �Է������� �������� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirPath=request.getServletContext().getRealPath("/resources/file");
		
		//���ε� ������ ������ �����ϱ� File �ν��Ͻ� ���� - ���� ��� �� ���ϸ� ���� 
		//MultipartFile.getOriginalFilename() : ���ε� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		File file=new File(uploadDirPath, uploadFile.getOriginalFilename());
		
		//���ε� ������ File �ν��Ͻ��� �̿��Ͽ� ������ ���� - ���� ���ε� ó��
		//MultipartFile.transferTo(File file) : ���ε� ������ ������ �����ϴ� �޼ҵ�
		// => ������ ������ �̸��� ������ ������ ��� ������
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
		
		//WebApplicationContext �ν��Ͻ�(Spring Container)�� �޼ҵ带 ȣ���Ͽ� 
		//ServletContext �ν��Ͻ��� ��ȯ�޾� ���ε� ���丮�� �ý��� ��� ��ȯ
		String uploadDirPath=context.getServletContext().getRealPath("/resources/file");
		
		//���ε� ���ϰ� ������ �̸��� ������ ������ ������ ��� ���ε� ���ϸ��� 
		//�����Ͽ� ������ ����ǵ��� �ۼ�
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirPath, originalFilename);

		//���� ������ ����� ���ϸ��� �����ϱ� ���� ����
		String uploadFilename=originalFilename;
		
		//���ε� ���ϰ� ������ �̸��� ������ ������ ������ ��� ���ε�� ���ϸ� ����
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
		
		//�Է������� ���޹޾� ������ ���ε� ���丮�� ����
		String uploadDirPath=context.getServletContext().getRealPath("/resources/file");
		String imageFilename=imageFile.getOriginalFilename();
		File file=new File(uploadDirPath, imageFilename);
		imageFile.transferTo(file);
		
		//���ε�� �̹��� ������ �̿��Ͽ� ����� ���� ����
		//1.�̹��� ������ �о� �̹����� �޸𸮿� ����
		//BufferedImage : �̹��� ������ ������ �����ϱ� ���� Ŭ����
		//ImageIO.read(File file) : �̹��� ������ �о� BufferedImage �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		BufferedImage sourceImage=ImageIO.read(file);
		
		//2.�޸𸮿� ����� �̹����� ũ�⸦ �����Ͽ� ����� �̹��� ����
		//Scalr.resize(BufferedImage source, Method scalingMethod, Mode resizeMode, int targetSize)
		// => �̹����� ũ�⸦ �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Scalr.Method.AUTOMATIC : �̹����� �� �Ǵ� ���̸� �ڵ� ����
		// => Scalr.Mode.FIT_TO_WIDTH : �̹����� �� ���� - ���� �ڵ� ����
		BufferedImage thumbnailImage=Scalr.resize(sourceImage, Scalr.Method.AUTOMATIC
				, Scalr.Mode.FIT_TO_WIDTH, 400);
		
		//3.�޸𸮿� ����� ����� �̹����� �̹��� ���� ����
		// => ������ ����� �̹��� ������ �̸��� ����
		int index=imageFilename.lastIndexOf(".");
		String thumbnailFilename=imageFilename.substring(0, index)
				+"_s"+imageFilename.substring(index);

		index=thumbnailFilename.lastIndexOf(".");
		//ImageIO.write(RenderedImage im, String formatName,File file)
		// => �޸𸮿� ����� �̹����� �̹��� ���Ϸ� �����ϴ� �޼ҵ�
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

		//�Է������� �̸���  ��ȯ�޾� ����
		String origin=fileBoard.getFile().getOriginalFilename();
		//������ ���ε� �Ǿ� ����� ���ϸ��� �����Ͽ� ����
		// => ���ε� ���ϸ��� �ߺ����� �ʵ��� ��¥�� �ð�����(TimeStamp)�� �̿��Ͽ� ���ϸ� ����
		String upload=System.currentTimeMillis()+"";
		
		//���� ���ε� => ���� ���ϸ��� �ƴ� ���ε� ���ϸ� �̿�
		fileBoard.getFile().transferTo(new File(uploadDirPath, upload));
		
		//FileBoard �ν��Ͻ��� �ʵ尪 ����
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
		//FILE_BOARD ���̺� ���� �Խñ� ���� ���� ����
		fileBoardService.addFileBoard(fileBoard);
		
		//�����̷�Ʈ �̵�
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
		//������ ����� ���ε� ���� ����
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");
		//File �ν��Ͻ� ���� �� delete() �޼ҵ带 ȣ���Ͽ� ���� ����
		new File(uploadDirPath, fileBoard.getUpload()).delete();
		
		//FILE_BOARD ���̺� ����� �Խñ� ����
		fileBoardService.eraseFileBoard(num);
		return "redirect:/file_list";
	}
	
	//���� ���ε� ���丮�� ����� ������ �ٿ�ε� ����� �����ϴ� �޼ҵ�
	// => ��ûó�� �޼ҵ��� ��ȯ���� �ݵ�� ModelAndView Ŭ������ �ۼ�
	@RequestMapping("/file_download/{num}")
	public ModelAndView fileDownload(@PathVariable int num) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		//�ٿ�ε� ������ ������ Map �ν��Ͻ��� �����Ͽ� ����
		Map<String, String> fileInfo=new HashMap<String, String>();
		fileInfo.put("uploadDirPath", context.getServletContext().getRealPath("/WEB-INF/upload"));
		fileInfo.put("uploadFileName",fileBoard.getUpload());
		fileInfo.put("originFileName",fileBoard.getOrigin());
		
		//ModelAndView(String beanName, String attributeName, Object attributeValue)
		// => Ư�� ����� �����ϴ� Spring Bean�� �޼ҵ� ���࿡ �ʿ��� ������ �����Ͽ� ó��
		//���� �ٿ�ε� ����� �����ϴ� Ŭ������ Spring beanName�� Front Controller���� ����
		// => Front Controller���� ���޵� Spring Bean�� �޼ҵ� �ڵ� ȣ��Ǿ� ���� �ٿ�ε� ��� ����
		// => BeanNameVeiwResolver Ŭ������ �̿��Ͽ� ���� ó���ǵ��� ����
		return new ModelAndView("fileDownload", "downloadFile", fileInfo);
	}
}











