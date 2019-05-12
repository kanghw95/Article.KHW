package Article.KHW;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterControll {

	@Autowired
    ArticleDao ArticleDao;

	static final Logger logger = LogManager.getLogger();

	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/register/step1")
	public String handleStep1(@RequestParam(value = "articleId") String articleId,
			Model model)  {
	    Article article = ArticleDao.getArticle(articleId);
	    
	    model.addAttribute("article", article);
		
		return "register/step1";
	}

	@GetMapping("/members")
	public String members(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

	
		final int COUNT = 100;
		
		int offset = (page - 1) * COUNT;

		List<Article> AritcleList = ArticleDao.selectAll(offset, COUNT);

		int totalCount = ArticleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("members", AritcleList);
		return "members";
	}
	
	@RequestMapping("/register/step2")
	public String handleStep2()
	{
		return "register/step2";
	}
	
	
	@PostMapping("/register/step3")
	public String handleStep3(Article article)
	{
		try {
			ArticleDao.insert(article);
			logger.debug("회원 정보를 저장 {}", article);
			return "register/step3";
		} catch (DuplicateKeyException e) {
			return "register/step2";
		}
	}
}

	
