package org.sebi;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ScoreEvent {

    private String player;

    private String ghost;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGhost() {
        return ghost;
    }

    public void setGhost(String ghost) {
        this.ghost = ghost;
    }

    public ScoreEvent(String player, String ghost) {
        this.player = player;
        this.ghost = ghost;
    }

    public ScoreEvent() {
    }

}
