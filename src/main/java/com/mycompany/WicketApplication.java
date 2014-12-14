package com.mycompany;

import org.apache.wicket.Application;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication
{
    /**
     * Constructor
     */
	public WicketApplication()
	{
	}

	@Override
	public void init() {
		System.setProperty("isThreadContextMapInheritable", "true");
		getRequestLoggerSettings().setRequestLoggerEnabled(true);
		getRequestLoggerSettings().setRecordSessionSize(false);
	}

	@Override
	public String getConfigurationType() {
		return Application.DEPLOYMENT;
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

}
