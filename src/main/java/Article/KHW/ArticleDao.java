package Article.KHW;

import java.util.List;





public interface ArticleDao {


	

	
	Article getArticle(String articleId);
	
	
	int countAll();

    List<Article> selectAll(int offset, int COUNT);
		

	void insert(Article article);

}