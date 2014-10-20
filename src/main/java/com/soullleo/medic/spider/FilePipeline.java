/**
 * Lagou.com Llc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.soullleo.medic.spider;

import java.io.BufferedWriter;
import java.io.IOException;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @Description: TODO(这里描述这个类的作用) 
 * @Author soul
 * @Date Oct 20, 2014 2:50:14 PM 
 */
public class FilePipeline implements Pipeline {

    private BufferedWriter writer;

    public FilePipeline(BufferedWriter writer) {
        this.writer = writer;
    }

    /** 
     * @see us.codecraft.webmagic.pipeline.Pipeline#process(us.codecraft.webmagic.ResultItems, us.codecraft.webmagic.Task)
     */
    @Override
    public void process(ResultItems resultItems, Task task) {

        try {
            writer.write(resultItems.getRequest().getUrl() + ","
                         + resultItems.getAll().entrySet().toString());
            writer.newLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //        System.out.println(resultItems.getRequest().getUrl());
        //        
        //        System.out.println(task.getSite());

        //        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
        //            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        //        }

    }

}
