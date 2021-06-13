package com.teqto.article.jcr.workspace;

import java.io.FileReader;

import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.commons.cnd.CndImporter;
import org.springframework.beans.factory.annotation.Autowired;

import com.teqto.article.jcr.config.authentication.AuthenticationUtil;

public class CustomNodeTypeRegister {
   
	@Autowired
	AuthenticationUtil authUtil;
	
	public static void RegisterCustomNodeTypes(Session session, String cndFileName)
       throws Exception {
    	CndImporter.registerNodeTypes(new FileReader(cndFileName), session,true);
    }
	
	public static void register() throws Exception {
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "teqtosys");
		RegisterCustomNodeTypes(session,"C:\\workspace-java\\article-service\\src\\main\\resources\\article.cnd");
	}
}