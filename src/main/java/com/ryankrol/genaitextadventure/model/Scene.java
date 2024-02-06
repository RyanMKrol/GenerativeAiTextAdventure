package com.ryankrol.genaitextadventure.model;

import java.util.List;

public class Scene {
    private String id;
    private String description;
    private List<Item> items;
    private List<SceneAction> actions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<SceneAction> getActions() {
        return actions;
    }

    public void setActions(List<SceneAction> actions) {
        this.actions = actions;
    }
}
