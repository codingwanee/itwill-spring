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

//���� �ٿ�ε� ����� �����ϱ� ���� Ŭ����
// => Bean Configuration File���� bean ������Ʈ�� �̿��Ͽ� Spring Bean ��� 
// => @Component ������̼��� �̿��Ͽ� Spring Bean ��� - ������̼��� �νĵǵ��� ��Ű�� ����
//BeanNameViewResolver�� ���� ����� Spring Bean Ŭ������ �ݵ�� AbstractView Ŭ������ ��ӹ޾� �ۼ�
// => AbstractView Ŭ������ �߻�޼ҵ带 �������̵� ���� - Ŭ���̾�Ʈ���� ����� �����ϴ� �޼ҵ�
public class FileDownload extends AbstractView {
	//Ŭ���̾�Ʈ�� ����� ���� ����(MimeType)�� ���� - ���� �ٿ�ε� ���
	public FileDownload() {
		//AbstractView.setContentType(String mimeType) : ���� ������ �����ϴ� �޼ҵ�
		setContentType("application/download;utf-8");
	}
	
	//BeanNameViewResolver�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => ��ûó�� �޼ҵ忡�� ��ȯ�Ǵ� ModelAndView �ν��Ͻ��� ���� �ν��Ͻ��� �Ű������� �ڵ� ����
	//���� �ٿ�ε� ����� �����ϱ� ���� �޼ҵ�
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//��ûó�� �޼ҵ忡�� ������ �ٿ�ε� ���������� ��ȯ�޾� ����
		@SuppressWarnings("unchecked")
		Map<String, String> fileInfo=(Map<String, String>)model.get("downloadFile");
		
		//�ٿ�ε� ���������� ��ȯ�޾� ����
		String uploadDirPath=fileInfo.get("uploadDirPath");
		String uploadFileName=fileInfo.get("uploadFileName");
		String originFileName=fileInfo.get("originFileName");
		
		//�ٿ�ε� ���Ͽ� ���� File �ν��Ͻ� ����
		File downloadFile=new File(uploadDirPath, uploadFileName);
		
		//Ŭ���̾�Ʈ���� ������ �����ϱ� ���� �������� ����
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		//Ŭ���̾�Ʈ�� ����� ���ϸ� ���� - �ѱ� ���ϸ� ���޵ǵ��� ��ȣȭ ó��
		String downloadFileName=URLEncoder.encode(originFileName,"UTF-8");
		
		//��������� �ٿ�ε� ���ϸ�� ���۹���� �����Ͽ� Ŭ���̾𿡰� ����
		response.setHeader("Content-Disposition", "attachment;filename=\""+downloadFileName+"\";");
		
		//Ŭ���̾�Ʈ���� ���õ���Ÿ�� �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		try {
			//�ٿ�ε� ������ ���õ���Ÿ�� �б� ���� �Է½�Ʈ�� ����
			in=new FileInputStream(downloadFile);
			
			//�Է½�Ʈ������ ���õ���Ÿ�� �о� ��½�Ʈ�� ���� - �ٿ�ε�
			/*
			while(true) {
				int readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			*/
			//Spring Framework���� �����ϴ� FileCopyUtils Ŭ������ copy() �޼ҵ带 ȣ���Ͽ� ���� ����
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
