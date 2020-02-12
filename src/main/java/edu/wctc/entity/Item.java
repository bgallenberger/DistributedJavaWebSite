package edu.wctc.entity;

public class Item {
    private int itemId;
    private String name;
    private int categoryId;
    private ItemDetail detail;

    public Item(){
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public ItemDetail getDetail() {
        return detail;
    }

    public void setDetail(ItemDetail detail) {
        this.detail = detail;
    }
}
