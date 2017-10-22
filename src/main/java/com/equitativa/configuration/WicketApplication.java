package com.equitativa.configuration;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.equitativa.HomePage;
import com.equitativa.todo.ToDoPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.equitativa.Start#main(String[])
 */
@Component("wicketApplication")
public class WicketApplication extends WebApplication
{
	@Autowired
	private ApplicationContext applicationContext;
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return ToDoPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext, false));
		// add your configuration here
	}
}
