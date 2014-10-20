/**
 * Lagou.com Llc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.soullleo.medic.spider;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @Description: TODO(这里描述这个类的作用) 
 * @Author soul
 * @Date Oct 20, 2014 1:27:36 PM 
 */
public class Main {

    /**
     * 
     * @param args
     * @throws IOException 
     * @throws MalformedURLException 
     * @throws FailingHttpStatusCodeException 
     */
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

        final WebClient webClient = new WebClient();
        webClient.addRequestHeader("Host", "www.39.net");
        
        final HtmlPage page = webClient.getPage("http://www.39.net/");
        
        System.out.println(page.asText());

    }

}
