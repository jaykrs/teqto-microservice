package com.teqto.article.jcr.transformer;

import javax.jcr.Node;

import com.teqto.article.jcr.model.Article;

/**
 * @author jayant
 *
 */
public interface IArticleContentTransfromer {

	public Article transformContentNode(Node node);
	public Node transformContentArticle(Article article, Node node);
	
}
