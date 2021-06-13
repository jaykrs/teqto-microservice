package com.teqto.article.jcr.service;

import java.util.List;

import javax.jcr.Node;

import com.teqto.article.jcr.model.Article;

/**
 * @author jayant
 *
 */
public interface IContentArticleService {

	List<Article> listAllContentArticleByPath(String courseId, String syllabusId);
	Article addContentArticleByPath(String courseId, String syllabusId, Article article);
}
