package com.task2.student2.model;


public enum SortingType {
    BY_NAME_ASC("Sorting by Name Asc", "Name", "Asc"),
    BY_NAME_DESC("Sorting by Name Desc", "Name", "Desc"),
    BY_PRICE_ASC("Sorting by price Asc", "Price", "Asc"),
    BY_PRICE_DESC("Sorting by price Desc", "Price", "Desc");

    private String description;
    private String sortingProperty;
    private String sortingDirection;

    SortingType(final String description, final String sortingProperty, final String sortingDirection) {
        this.description = description;
        this.sortingProperty = sortingProperty;
        this.sortingDirection = sortingDirection;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSortingProperty() {
        return sortingProperty;
    }

    public String getSortingDirection() {
        return sortingDirection;
    }
}
