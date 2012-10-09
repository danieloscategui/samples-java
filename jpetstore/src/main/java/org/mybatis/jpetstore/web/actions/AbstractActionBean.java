package org.mybatis.jpetstore.web.actions;

import java.io.Serializable;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.SimpleMessage;

public class AbstractActionBean implements ActionBean, Serializable{

	private static final long serialVersionUID = 4876595327104873817L;

	protected static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
	
	protected transient ActionBeanContext context;
	
	protected void setMessage(String value){
		context.getMessages().add(new SimpleMessage(value));
	}
	
	public ActionBeanContext getContext(){
		return context;
	}
	
	public void setContext(ActionBeanContext context){
		this.context = context;
	}
}
