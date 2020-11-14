package csmp.rxbus.notifications;

import csmp.models.Entities;

public class UserRequestedBotView {

    private long complexId;
    private long roomId;
    private boolean preview;
    private int width;
    private int height;
    private Entities.User user;
    private boolean windowMode;

    public UserRequestedBotView(long complexId, long roomId, boolean preview, int width, int height, Entities.User user, boolean windowMode) {
        this.complexId = complexId;
        this.roomId = roomId;
        this.preview = preview;
        this.width = width;
        this.height = height;
        this.user = user;
        this.windowMode = windowMode;
    }

    public long getComplexId() {
        return complexId;
    }

    public long getRoomId() {
        return roomId;
    }

    public boolean isPreview() {
        return preview;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entities.User getUser() {
        return user;
    }

    public boolean isWindowMode() {
        return windowMode;
    }
}
