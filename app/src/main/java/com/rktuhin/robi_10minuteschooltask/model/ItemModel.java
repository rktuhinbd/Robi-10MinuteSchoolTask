package com.rktuhin.robi_10minuteschooltask.model;

public class ItemModel {

    private String title, subTitle;
    private boolean expanded;

    public ItemModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
        this.expanded = false;
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

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "Item{" + "title='" + title + '\'' + ", expanded=" + expanded + '}';
    }
}
