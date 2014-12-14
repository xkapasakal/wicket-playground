package com.mycompany;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;


/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;
    static final Logger logger = LogManager.getLogger(HomePage.class.getName());

    // TODO Add any page properties or variables here

    /**
     * Constructor that is invoked when page is invoked without a session.
     *
     * @param parameters Page parameters
     */
    public HomePage(final PageParameters parameters) {

        doSomething();
        // Add the simplest type of label
        add(new Label("message",
            "If you see this message wicket is properly configured and running"));
        try {
            throw new RuntimeException("my run time");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void doSomething(){
        logger.info("I am doing something");
    }

}
