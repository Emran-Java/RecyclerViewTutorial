package com.emran.recyclerviewtutorial;

/**
 * Created by emran on 11/21/18.
 */

public class DemoData {
    private String title, subTitle;

    public DemoData(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}
