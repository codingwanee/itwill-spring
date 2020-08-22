package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.ProductCollection;

@Controller
public class ProductController {
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productInput() {
		return "product_input";
	}
	
	/*
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productOutput(@ModelAttribute Product product) {
		return "product_output";
	}
	*/
	
	//동일한 정보를 여러개 입력받아 저장해야 될 경우 List 인스턴스 필드가
	//선언된 클래스를 작성하여 Command 객체로 사용
	// => 입력태그의 name 속성값이 Command 객체에 저장될 수 있도록 설정
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productOutput(@ModelAttribute("collection") ProductCollection collection) {
		return "product_output";
	}
}




