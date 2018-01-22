package com.frontendapp;


public class MessageDTO {
    Integer msgId;
    String message;

    private MessageDTO(Builder builder) {
        setMsgId(builder.msgId);
        setMessage(builder.message);
    }

    public static Builder newMessageDTO() {
        return new Builder();
    }

    public static Builder newMessageDTO(MessageDTO copy) {
        Builder builder = new Builder();
        builder.msgId = copy.msgId;
        builder.message = copy.message;
        return builder;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "MessageDTO{" +
                "msgId=" + msgId +
                ", message='" + message + '\'' +
                '}';
    }

    public static final class Builder {
        private Integer msgId;
        private String message;

        private Builder() {
        }

        public Builder withMsgId(Integer val) {
            msgId = val;
            return this;
        }

        public Builder withMessage(String val) {
            message = val;
            return this;
        }

        public MessageDTO build() {
            return new MessageDTO(this);
        }
    }
}
