package com.kely;

import java.io.Serializable;
import java.util.List;

class Item implements Serializable {
    private int specId;
    private String specName;
    private List<Option> options;

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Item() {

    }

    public Item(int specId, String specName, List<Option> options) {
        this.specId = specId;
        this.specName = specName;
        this.options = options;
    }
}