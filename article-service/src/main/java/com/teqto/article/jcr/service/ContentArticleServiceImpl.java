package com.teqto.article.jcr.service;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teqto.article.jcr.config.authentication.AuthenticationUtil;
import com.teqto.article.jcr.constant.JCRConstants;
import com.teqto.article.jcr.model.Article;
import com.teqto.article.jcr.transformer.IArticleContentTransfromer;

/**
 * @author jayant
 *
 */
@Repository
public class ContentArticleServiceImpl implements IContentArticleService{

	
	
	@Autowired
	IArticleContentTransfromer articleContentTransformer;
	@Override
	public List<Article> listAllContentArticleByPath(String courseId, String syllabusId) {
		Session session = new AuthenticationUtil().getSession();
		List<Article> listContentArticle = new ArrayList<Article>();
		String nodePath = "/"+courseId+"/"+syllabusId;
		try {
			Node node = session.getNode(nodePath);
			NodeIterator nodeIterator = node.getNodes();
			while(nodeIterator.hasNext()) {
				Node _node = nodeIterator.nextNode();
				Article article = articleContentTransformer.transformContentNode(_node);
				listContentArticle.add(article);
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listContentArticle;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Article addContentArticleByPath(String courseId, String syllabusId, Article article) {
		Session session = new AuthenticationUtil().getSession();
		Node _tempNode = null;
		try {
		if(!session.getRootNode().hasNode(courseId))
			_tempNode = session.getRootNode().addNode(courseId);
		else
			_tempNode = session.getRootNode().getNode(courseId);
		session.save();
		if(!_tempNode.hasNode(syllabusId))
			_tempNode = _tempNode.addNode(syllabusId);
		else
			_tempNode = _tempNode.getNode(syllabusId);
		session.save();
		if(!_tempNode.hasNode(article.getTitle())) 
			_tempNode = _tempNode.addNode(article.getTitle(),"teqto:article");
		else
			_tempNode	= _tempNode.getNode(article.getTitle());		
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_TITLE, article.getTitle());
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_TEASER, article.getTeaser());
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_ARTICLE_TYPE, Integer.toString(article.getArticleType()));
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_MO_ID, _tempNode.getIdentifier());
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_ORDER, Integer.toString(article.getOrder()));
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_AUTHOR_ID, Integer.toString(article.getAuthorId()));
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_SYLLABUS_ID, Integer.toString(article.getSyllabusId()));
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_BODY, article.getBody());
		_tempNode.setProperty(JCRConstants.TEQTO+JCRConstants.JCR_CONTENT_TYPE, article.getContentType());
//		articleNode.setProperty("teqto:"+JCRConstants.JCR_IS_PUBLISHED, ""+Boolean.FALSE);
		session.save();
		return articleContentTransformer.transformContentNode(_tempNode);
		
		} catch(Exception rexp) {rexp.printStackTrace();}
		return null;
	}

}
