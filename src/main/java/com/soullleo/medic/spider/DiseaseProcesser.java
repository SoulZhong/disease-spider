/**
 * Lagou.com Llc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.soullleo.medic.spider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @Description: 
 * @Author soul
 * @Date Oct 19, 2014 8:20:34 PM 
 */
public class DiseaseProcesser implements PageProcessor {

    private Site site = Site.me().setDomain("jbk.39.net").addStartUrl("http://jbk.39.net/bw");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://jbk\\.39\\.net/bw/[^/]+").all();

        page.addTargetRequests(links);

        List<Selectable> nodes = page.getHtml().$(".res_list").nodes();
        List<Disease> diseases = new ArrayList<Disease>();
        for (Selectable node : nodes) {
            Disease disease = new Disease();

            disease.setName(node.xpath("h3/a/text()").get());

            disease.setDesc(node.xpath("dl/dd/text()").get());

            disease.setSymptoms(node.xpath("div/p/a/text()").all());
            diseases.add(disease);

            System.out
                .println("--------------------------------------------------------------------------");
        }

        page.putField("diseases", diseases);
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) throws IOException {

        File file = new File("disease.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(file)));
        Spider.create(new DiseaseProcesser()).pipeline(new FilePipeline(writer)).run();
        writer.close();
    }
}