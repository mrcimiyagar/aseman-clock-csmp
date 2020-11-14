package csmp.rxbus.notifications;

public class BotLoaded {
    private long userId;
    private long complexId;
    private long roomId;
    private boolean windowMode;

    public BotLoaded(long complexId, long roomId, long userId, boolean windowMode) {
        this.userId = userId;
        this.complexId = complexId;
        this.roomId = roomId;
        this.windowMode = windowMode;
    }

    public long getComplexId() {
        return complexId;
    }

    public long getRoomId() {
        return roomId;
    }

    public long getUserId() {
        return userId;
    }

    public boolean isWindowMode() {
        return windowMode;
    }
}
