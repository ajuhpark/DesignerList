package com.andrew.designerlist.models;

/**
 * Created by fangbrian on 9/21/17.
 */

public class Designer {
    public static final String DESIGNER_NAME_EXTRA = "designer_name";

    private String name;

    public Designer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
