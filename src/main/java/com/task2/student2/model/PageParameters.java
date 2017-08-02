package com.task2.student2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awdul on 31.07.2017.
 */

public class PageParameters {
    public static String pageNext = "1";
    public static String pagePrevious = "0";
    public static String sortingDirection = "Asc";
    public static String sortingProperty = "Name";
    public static String pageNumber = "0";
    public static String pageSize = "10";
    public static List<String> pageSizes = new ArrayList<String>(){{
        add("5"); add("10"); add("15"); add("20");  add("50"); add("100");
    }};

    public static void setParameters(String sortingDirection, String sortingProperty, String pageNumber, String pageSize){
        if(sortingDirection != null) PageParameters.sortingDirection = sortingDirection;
        if(sortingProperty != null) PageParameters.sortingProperty = sortingProperty;
        if(pageNumber != null) PageParameters.pageNumber = pageNumber;
        if(pageSize != null) PageParameters.pageSize = pageSize;
    }

    public static void setPageNumber(String pageNumber) {
        int tmpPage;
        PageParameters.pageNumber = pageNumber;
        if(Integer.parseInt(pageNumber)==0) pagePrevious ="0";
        else{
            tmpPage = Integer.parseInt(pageNumber);
            tmpPage--;
            pagePrevious=String.valueOf(tmpPage);
        }
        tmpPage = Integer.parseInt(pageNumber);
        tmpPage++;
        pageNext=String.valueOf(tmpPage);
    }

    public static List<String> getPageSizes() {
        return pageSizes;
    }

    public static void setPageSizes(List<String> pageSizes) {
        PageParameters.pageSizes = pageSizes;
    }
}
