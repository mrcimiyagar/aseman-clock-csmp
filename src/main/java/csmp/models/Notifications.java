package csmp.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import csmp.models.Entities;
import csmp.models.YoloBoundingBox;

import java.util.List;

public class Notifications {

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = BotPropertiesChangedNotification.class, name = "BotPropertiesChangedNotification"),
            @JsonSubTypes.Type(value = MemberAccessUpdatedNotification.class, name = "MemberAccessUpdatedNotification"),
            @JsonSubTypes.Type(value = MessageSeenNotification.class, name = "MessageSeenNotification"),
            @JsonSubTypes.Type(value = InviteCreationNotification.class, name = "InviteCreationNotification"),
            @JsonSubTypes.Type(value = InviteAcceptanceNotification.class, name = "InviteAcceptanceNotification"),
            @JsonSubTypes.Type(value = InviteIgnoranceNotification.class, name = "InviteIgnoranceNotification"),
            @JsonSubTypes.Type(value = InviteCancellationNotification.class, name = "InviteCancellationNotification"),
            @JsonSubTypes.Type(value = ContactCreationNotification.class, name = "ContactCreationNotification"),
            @JsonSubTypes.Type(value = RoomDeletionNotification.class, name = "RoomDeletionNotification"),
            @JsonSubTypes.Type(value = TextMessageNotification.class, name = "TextMessageNotification"),
            @JsonSubTypes.Type(value = PhotoMessageNotification.class, name = "PhotoMessageNotification"),
            @JsonSubTypes.Type(value = AudioMessageNotification.class, name = "AudioMessageNotification"),
            @JsonSubTypes.Type(value = VideoMessageNotification.class, name = "VideoMessageNotification"),
            @JsonSubTypes.Type(value = ServiceMessageNotification.class, name = "ServiceMessageNotification"),
            @JsonSubTypes.Type(value = UserJointComplexNotification.class, name = "UserJointComplexNotification"),
            @JsonSubTypes.Type(value = ComplexDeletionNotification.class, name = "ComplexDeletionNotification"),
            @JsonSubTypes.Type(value = BotSentBotViewNotification.class, name = "BotSentBotViewNotification"),
            @JsonSubTypes.Type(value = BotUpdatedBotViewNotification.class, name = "BotUpdatedBotViewNotification"),
            @JsonSubTypes.Type(value = BotAnimatedBotViewNotification.class, name = "BotAnimatedBotViewNotification"),
            @JsonSubTypes.Type(value = BotRanCommandsOnBotViewNotification.class, name = "BotRanCommandsOnBotViewNotification"),
            @JsonSubTypes.Type(value = RoomCreationNotification.class, name = "RoomCreationNotification"),
            @JsonSubTypes.Type(value = ImageAnalyzedNotification.class, name = "ImageAnalyzedNotification"),
            @JsonSubTypes.Type(value = UserRequestedBotViewNotification.class, name = "UserRequestedBotViewNotification"),
            @JsonSubTypes.Type(value = UserClickedBotViewNotification.class, name = "UserClickedBotViewNotification"),
            @JsonSubTypes.Type(value = UserRequestedBotPreviewNotification.class, name = "UserRequestedBotPreviewNotification"),
            @JsonSubTypes.Type(value = BotViewResizedNotification.class, name = "BotViewResizedNotification")
    })
    public static class Notification {
        private String notificationId;
        private long sessionId;

        public String getNotificationId() {
            return notificationId;
        }

        public void setNotificationId(String notificationId) {
            this.notificationId = notificationId;
        }

        public long getSessionId() {
            return sessionId;
        }

        public void setSessionId(long sessionId) {
            this.sessionId = sessionId;
        }
    }

    public static class BotViewResizedNotification extends Notification {
        private long userId;
        private long complexId;
        private long roomId;
        private int newWidth;
        private int newHeight;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public int getNewWidth() {
            return newWidth;
        }

        public void setNewWidth(int newWidth) {
            this.newWidth = newWidth;
        }

        public int getNewHeight() {
            return newHeight;
        }

        public void setNewHeight(int newHeight) {
            this.newHeight = newHeight;
        }
    }

    public static class BotLoadedNotification extends Notification {
        private long userId;
        private long complexId;
        private long roomId;
        private boolean botWindowMode;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public boolean isBotWindowMode() {
            return botWindowMode;
        }

        public void setBotWindowMode(boolean botWindowMode) {
            this.botWindowMode = botWindowMode;
        }
    }

    public static class UserRequestedBotPreviewNotification extends Notification {
        private long botId;
        private csmp.models.Entities.User user;
        private int workerWidth;
        private int workerHeight;

        public long getBotId() {
            return botId;
        }

        public void setBotId(long botId) {
            this.botId = botId;
        }

        public csmp.models.Entities.User getUser() {
            return user;
        }

        public void setUser(csmp.models.Entities.User user) {
            this.user = user;
        }

        public int getWorkerWidth() {
            return workerWidth;
        }

        public void setWorkerWidth(int workerWidth) {
            this.workerWidth = workerWidth;
        }

        public int getWorkerHeight() {
            return workerHeight;
        }

        public void setWorkerHeight(int workerHeight) {
            this.workerHeight = workerHeight;
        }
    }

    public static class UserClickedBotViewNotification extends Notification {
        private csmp.models.Entities.Complex complex;
        private csmp.models.Entities.BaseRoom room;
        private csmp.models.Entities.User user;
        private String controlId;

        public csmp.models.Entities.Complex getComplex() {
            return complex;
        }

        public void setComplex(csmp.models.Entities.Complex complex) {
            this.complex = complex;
        }

        public csmp.models.Entities.BaseRoom getRoom() {
            return room;
        }

        public void setRoom(csmp.models.Entities.BaseRoom room) {
            this.room = room;
        }

        public csmp.models.Entities.User getUser() {
            return user;
        }

        public void setUser(csmp.models.Entities.User user) {
            this.user = user;
        }

        public String getControlId() {
            return controlId;
        }

        public void setControlId(String controlId) {
            this.controlId = controlId;
        }
    }

    public static class UserRequestedBotViewNotification extends Notification {
        private long complexId;
        private long roomId;
        private long botId;
        private csmp.models.Entities.User user;
        private int workerWidth;
        private int workerHeight;
        private boolean botWindowMode;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public long getBotId() {
            return botId;
        }

        public void setBotId(long botId) {
            this.botId = botId;
        }

        public csmp.models.Entities.User getUser() {
            return user;
        }

        public void setUser(csmp.models.Entities.User user) {
            this.user = user;
        }

        public int getWorkerWidth() {
            return workerWidth;
        }

        public void setWorkerWidth(int workerWidth) {
            this.workerWidth = workerWidth;
        }

        public int getWorkerHeight() {
            return workerHeight;
        }

        public void setWorkerHeight(int workerHeight) {
            this.workerHeight = workerHeight;
        }

        public boolean isBotWindowMode() {
            return botWindowMode;
        }

        public void setBotWindowMode(boolean botWindowMode) {
            this.botWindowMode = botWindowMode;
        }
    }

    public static class ImageAnalyzedNotification extends Notification {
        private long fileId;
        private List<YoloBoundingBox> boxes;

        public long getFileId() {
            return fileId;
        }

        public void setFileId(long fileId) {
            this.fileId = fileId;
        }

        public List<YoloBoundingBox> getBoxes() {
            return boxes;
        }

        public void setBoxes(List<YoloBoundingBox> boxes) {
            this.boxes = boxes;
        }
    }

    public static class RoomCreationNotification extends Notification {
        private csmp.models.Entities.Room room;
        private csmp.models.Entities.SingleRoom singleRoom;
        private csmp.models.Entities.ServiceMessage message;

        public csmp.models.Entities.Room getRoom() {
            return room;
        }

        public void setRoom(csmp.models.Entities.Room room) {
            this.room = room;
        }

        public csmp.models.Entities.SingleRoom getSingleRoom() {
            return singleRoom;
        }

        public void setSingleRoom(csmp.models.Entities.SingleRoom singleRoom) {
            this.singleRoom = singleRoom;
        }

        public csmp.models.Entities.ServiceMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.ServiceMessage message) {
            this.message = message;
        }
    }

    public static class BotPropertiesChangedNotification extends Notification {
        private csmp.models.Entities.Workership workership;

        public csmp.models.Entities.Workership getWorkership() {
            return workership;
        }

        public void setWorkership(csmp.models.Entities.Workership workership) {
            this.workership = workership;
        }
    }

    public static class MemberAccessUpdatedNotification extends Notification {
        private csmp.models.Entities.MemberAccess memberAccess;

        public csmp.models.Entities.MemberAccess getMemberAccess() {
            return memberAccess;
        }

        public void setMemberAccess(csmp.models.Entities.MemberAccess memberAccess) {
            this.memberAccess = memberAccess;
        }
    }

    public static class BotAddedToRoomNotification extends Notification {
        private csmp.models.Entities.Workership workership;
        private csmp.models.Entities.Bot bot;

        public csmp.models.Entities.Workership getWorkership() {
            return workership;
        }

        public void setWorkership(csmp.models.Entities.Workership workership) {
            this.workership = workership;
        }

        public csmp.models.Entities.Bot getBot() {
            return bot;
        }

        public void setBot(csmp.models.Entities.Bot bot) {
            this.bot = bot;
        }
    }

    public static class BotRemovedFromRoomNotification extends Notification {
        private csmp.models.Entities.Workership workership;

        public csmp.models.Entities.Workership getWorkership() {
            return workership;
        }

        public void setWorkership(csmp.models.Entities.Workership workership) {
            this.workership = workership;
        }
    }

    public static class MessageSeenNotification extends Notification {

        private long messageId;
        private long messageSeenCount;

        public long getMessageId() {
            return messageId;
        }

        public void setMessageId(long messageId) {
            this.messageId = messageId;
        }

        public long getMessageSeenCount() {
            return messageSeenCount;
        }

        public void setMessageSeenCount(long messageSeenCount) {
            this.messageSeenCount = messageSeenCount;
        }
    }

    public static class InviteCreationNotification extends Notification {

        private long inviteId;
        private csmp.models.Entities.Invite invite;

        public long getInviteId() {
            return inviteId;
        }

        public void setInviteId(long inviteId) {
            this.inviteId = inviteId;
        }

        public csmp.models.Entities.Invite getInvite() {
            return invite;
        }

        public void setInvite(csmp.models.Entities.Invite invite) {
            this.invite = invite;
        }
    }

    public static class InviteCancellationNotification extends Notification {

        private long inviteId;
        private csmp.models.Entities.Invite invite;

        public long getInviteId() {
            return inviteId;
        }

        public void setInviteId(long inviteId) {
            this.inviteId = inviteId;
        }

        public csmp.models.Entities.Invite getInvite() {
            return invite;
        }

        public void setInvite(csmp.models.Entities.Invite invite) {
            this.invite = invite;
        }
    }

    public static class InviteAcceptanceNotification extends Notification {

        private long inviteId;
        private csmp.models.Entities.Invite invite;

        public long getInviteId() {
            return inviteId;
        }

        public void setInviteId(long inviteId) {
            this.inviteId = inviteId;
        }

        public csmp.models.Entities.Invite getInvite() {
            return invite;
        }

        public void setInvite(csmp.models.Entities.Invite invite) {
            this.invite = invite;
        }
    }

    public static class InviteIgnoranceNotification extends Notification {

        private long inviteId;
        private csmp.models.Entities.Invite invite;

        public long getInviteId() {
            return inviteId;
        }

        public void setInviteId(long inviteId) {
            this.inviteId = inviteId;
        }

        public csmp.models.Entities.Invite getInvite() {
            return invite;
        }

        public void setInvite(csmp.models.Entities.Invite invite) {
            this.invite = invite;
        }
    }

    public static class BotSentBotViewNotification extends Notification {
        private long complexId;
        private long roomId;
        private long botId;
        private String viewData;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public long getBotId() {
            return botId;
        }

        public void setBotId(long botId) {
            this.botId = botId;
        }

        public String getViewData() {
            return viewData;
        }

        public void setViewData(String viewData) {
            this.viewData = viewData;
        }
    }

    public static class BotUpdatedBotViewNotification extends Notification {
        private long complexId;
        private long roomId;
        private long botId;
        private String updateData;
        private boolean batchData;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public long getBotId() {
            return botId;
        }

        public void setBotId(long botId) {
            this.botId = botId;
        }

        public String getUpdateData() {
            return updateData;
        }

        public void setUpdateData(String updateData) {
            this.updateData = updateData;
        }

        public boolean isBatchData() {
            return batchData;
        }

        public void setBatchData(boolean batchData) {
            this.batchData = batchData;
        }
    }

    public static class BotAnimatedBotViewNotification extends Notification {
        private long complexId;
        private long roomId;
        private long botId;
        private String animData;
        private boolean batchData;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public long getBotId() {
            return botId;
        }

        public void setBotId(long botId) {
            this.botId = botId;
        }

        public String getAnimData() {
            return animData;
        }

        public void setAnimData(String animData) {
            this.animData = animData;
        }

        public boolean isBatchData() {
            return batchData;
        }

        public void setBatchData(boolean batchData) {
            this.batchData = batchData;
        }
    }

    public static class BotRanCommandsOnBotViewNotification extends Notification {
        private long complexId;
        private long roomId;
        private long botId;
        private String commandsData;
        private boolean batchData;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public long getBotId() {
            return botId;
        }

        public void setBotId(long botId) {
            this.botId = botId;
        }

        public String getCommandsData() {
            return commandsData;
        }

        public void setCommandsData(String commandsData) {
            this.commandsData = commandsData;
        }

        public boolean isBatchData() {
            return batchData;
        }

        public void setBatchData(boolean batchData) {
            this.batchData = batchData;
        }
    }

    public static class ContactCreationNotification extends Notification {

        private long contactId;
        private csmp.models.Entities.Contact contact;
        private csmp.models.Entities.ComplexSecret complexSecret;
        private csmp.models.Entities.ServiceMessage message;

        public long getContactId() {
            return contactId;
        }

        public void setContactId(long contactId) {
            this.contactId = contactId;
        }

        public csmp.models.Entities.Contact getContact() {
            return contact;
        }

        public void setContact(csmp.models.Entities.Contact contact) {
            this.contact = contact;
        }

        public csmp.models.Entities.ComplexSecret getComplexSecret() {
            return complexSecret;
        }

        public void setComplexSecret(csmp.models.Entities.ComplexSecret complexSecret) {
            this.complexSecret = complexSecret;
        }

        public csmp.models.Entities.ServiceMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.ServiceMessage message) {
            this.message = message;
        }
    }

    public static class ComplexDeletionNotification extends Notification {
        private long complexId;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }
    }

    public static class RoomDeletionNotification extends Notification {
        private long complexId;
        private long roomId;

        public long getComplexId() {
            return complexId;
        }

        public void setComplexId(long complexId) {
            this.complexId = complexId;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }
    }

    public static class TextMessageNotification extends Notification {
        private csmp.models.Entities.TextMessage message;

        public csmp.models.Entities.TextMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.TextMessage message) {
            this.message = message;
        }
    }

    public static class PhotoMessageNotification extends Notification {
        private csmp.models.Entities.PhotoMessage message;

        public csmp.models.Entities.PhotoMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.PhotoMessage message) {
            this.message = message;
        }
    }

    public static class AudioMessageNotification extends Notification {
        private csmp.models.Entities.AudioMessage message;

        public csmp.models.Entities.AudioMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.AudioMessage message) {
            this.message = message;
        }
    }

    public static class VideoMessageNotification extends Notification {
        private csmp.models.Entities.VideoMessage message;

        public csmp.models.Entities.VideoMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.VideoMessage message) {
            this.message = message;
        }
    }

    public static class ServiceMessageNotification extends Notification {
        private csmp.models.Entities.ServiceMessage message;

        public csmp.models.Entities.ServiceMessage getMessage() {
            return message;
        }

        public void setMessage(csmp.models.Entities.ServiceMessage message) {
            this.message = message;
        }
    }

    public static class UserJointComplexNotification extends Notification {
        private long membershipId;
        private csmp.models.Entities.Membership membership;
        private csmp.models.Entities.ServiceMessage message;

        public long getMembershipId() {
            return membershipId;
        }

        public void setMembershipId(long membershipId) {
            this.membershipId = membershipId;
        }

        public csmp.models.Entities.Membership getMembership() {
            return membership;
        }

        public void setMembership(csmp.models.Entities.Membership membership) {
            this.membership = membership;
        }

        public csmp.models.Entities.ServiceMessage getMessage() {
            return message;
        }

        public void setMessage(Entities.ServiceMessage message) {
            this.message = message;
        }
    }
}