package com.teqto.article.jcr.config.authentication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.nodetype.InvalidNodeTypeDefinitionException;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeExistsException;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.nodetype.PropertyDefinition;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.commons.cnd.CndImporter;
import org.apache.jackrabbit.commons.cnd.ParseException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author jayant
 *
 */
@Component
public class AuthenticationUtil {

	public Session session;
	
	@Resource
	public Environment env;
	
	 
	public void login(String uid, String pwd, String workspaceName) {
		if (null == this.session) {
			try {
				Repository repository = JcrUtils.getRepository();
				setSession(repository.login(new SimpleCredentials(uid, pwd.toCharArray()), workspaceName));
			} catch (RepositoryException rException) {
				rException.printStackTrace();
			}
		}
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		String userId = null != env && null != env.getProperty("jcr.userId")?env.getProperty("jcr.userId"):"admin";
		String pwd = null != env && null != env.getProperty("jcr.pwd")?env.getProperty("jcr.pwd"):"admin";
		String workspace = null != env && null != env.getProperty("jcr.workspace")?env.getProperty("jcr.workspace"):"teqtosys";
		if (null == this.session)
			login(userId, pwd, workspace);
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public  void setSession(Session session) {
		this.session = session;
		try {
			RegisterCustomNodeTypes(session);
		} catch (InvalidNodeTypeDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NodeTypeExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedRepositoryOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void RegisterCustomNodeTypes(Session session) throws InvalidNodeTypeDefinitionException, NodeTypeExistsException, UnsupportedRepositoryOperationException, FileNotFoundException, ParseException, RepositoryException, IOException {
		NodeTypeManager manager = session.getWorkspace().getNodeTypeManager();
		NodeTypeIterator nodeTypeIterator = manager.getAllNodeTypes();
		boolean flag = false;
		while(nodeTypeIterator.hasNext()) {
			NodeType nodeType = nodeTypeIterator.nextNodeType();
			
			if (nodeType.getName().equals("teqto:article")) {
				flag = true;
				PropertyDefinition p[] = nodeType.getPropertyDefinitions();
				for (int k = 0; k < p.length; k++)
					System.out.println(p[k].getName());
			}
			;
		}
		if(!flag) 
			CndImporter.registerNodeTypes(new FileReader("C:\\workspace-java\\teqto-microservice\\article-service\\src\\main\\resources\\article.cnd"), session,true);
	}
	
	public void removeSession(Session session) {
		session.logout();
		this.session = null;
	}
}
