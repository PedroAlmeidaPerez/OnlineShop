package com.task2.student2.model;


public enum SortingType {
    BY_NAME_ASC("Sorting by Name Asc", "sortNameAsc"),
    BY_NAME_DESC("Sorting by Name Desc", "sortNameDesc"),
    BY_PRICE_ASC("Sorting by price asc", "sortPriceAsc"),
    BY_PRICE_DESC("Sorting by price desc", "sortPriceDesc");

    private String description;
    private String urlRef;

    SortingType(final String description, final String urlRef) {
        this.description = description;
        this.urlRef = urlRef;
    }

    public String getDescription() {
        return this.description;
    }
    public String getUrlRef(){
        return this.urlRef;
    }

}
