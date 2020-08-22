package site.itwill09.springMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import site.itwill09.mvc.Member;

public class ViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=new Member("aaa", "1111", "ȫ�浿", "aaa@itwill.site");
		ModelAndView mv=new ModelAndView();
		mv.addObject("member", member);
		mv.setViewName("member_view");
		return mv;
	}

}
