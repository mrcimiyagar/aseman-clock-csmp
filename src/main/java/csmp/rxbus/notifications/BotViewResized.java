package csmp.rxbus.notifications;

public class BotViewResized {

    private long userId;
    private long complexId;
    private long roomId;
    private int newWidth;
    private int newHeight;

    public BotViewResized(long userId, long complexId, long roomId, int newWidth, int newHeight) {
        this.userId = userId;
        this.complexId = complexId;
        this.roomId = roomId;
        this.newWidth = newWidth;
        this.newHeight = newHeight;
    }

    public long getUserId() {
        return userId;
    }

    public long getComplexId() {
        return complexId;
    }

    public long getRoomId() {
        return roomId;
    }

    public int getNewWidth() {
        return newWidth;
    }

    public int getNewHeight() {
        return newHeight;
    }
}
