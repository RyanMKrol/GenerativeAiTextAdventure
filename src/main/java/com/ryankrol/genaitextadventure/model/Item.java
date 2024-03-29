package com.ryankrol.genaitextadventure.model;

import java.util.List;

public class Item {
    private String id;
    private String name;
    private String description;
    private List<String> prerequisites;
    private List<ItemAction> supportedActions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<ItemAction> getSupportedActions() {
        return supportedActions;
    }

    public void setSupportedActions(List<ItemAction> supportedActions) {
        this.supportedActions = supportedActions;
    }
}
