package org.sebi;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Player {
    
    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
