package org.spring.sample;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")	// board 폴더의 모든 jsp파일에 접근이 가능해짐
public class BoardController {
	
	@Inject
	BoardService service;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List list = null;
		list = service.list();
		model.addAttribute("list", list);
		
	}
	
	//게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(BoardVO vo)throws Exception{
		service.write(vo);
		
		return "redirect:/board/list";
	}
	//게시물 조회
	@RequestMapping(value = "/view", method=RequestMethod.GET)
	public void getView(@RequestParam("bno")int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		model.addAttribute("view", vo);
	}
	//게시물 수정
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public void getmodify(@RequestParam("bno")int bno, Model model) throws Exception{
			BoardVO vo = service.view(bno);
			
			model.addAttribute("view", vo);
	}
	//게시물 수정
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String postmodify(BoardVO vo) throws Exception{
		service.modify(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	//게시물 삭제
		@RequestMapping(value = "/delete", method=RequestMethod.GET)
		public String getdelte(@RequestParam("bno")int bno) throws Exception{
			service.delete(bno);
			return "redirect:/board/list";
		}
}
