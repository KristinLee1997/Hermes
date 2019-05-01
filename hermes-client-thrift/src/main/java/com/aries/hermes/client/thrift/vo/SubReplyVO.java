package com.aries.hermes.client.thrift.vo;

public class SubReplyVO {
    private long id;
    private long replyId;
    private long senderGaeaId;
    private long receiverGaeaId;
    private String content;
    private String insertTime;

    public long getId() {
        return id;
    }

    public long getReplyId() {
        return replyId;
    }

    public long getSenderGaeaId() {
        return senderGaeaId;
    }

    public long getReceiverGaeaId() {
        return receiverGaeaId;
    }

    public String getContent() {
        return content;
    }

    public String getInsertTime() {
        return insertTime;
    }


    public static final class SubReplyVOBuilder {
        private long replyId;
        private long senderGaeaId;
        private long receiverGaeaId;
        private String content;

        private SubReplyVOBuilder() {
        }

        public static SubReplyVOBuilder aSubReplyVO() {
            return new SubReplyVOBuilder();
        }

        public SubReplyVOBuilder replyId(long replyId) {
            this.replyId = replyId;
            return this;
        }

        public SubReplyVOBuilder senderGaeaId(long senderGaeaId) {
            this.senderGaeaId = senderGaeaId;
            return this;
        }

        public SubReplyVOBuilder receiverGaeaId(long receiverGaeaId) {
            this.receiverGaeaId = receiverGaeaId;
            return this;
        }

        public SubReplyVOBuilder content(String content) {
            this.content = content;
            return this;
        }

        public SubReplyVO build() {
            SubReplyVO subReplyVO = new SubReplyVO();
            subReplyVO.senderGaeaId = this.senderGaeaId;
            subReplyVO.receiverGaeaId = this.receiverGaeaId;
            subReplyVO.replyId = this.replyId;
            subReplyVO.content = this.content;
            return subReplyVO;
        }
    }
}
