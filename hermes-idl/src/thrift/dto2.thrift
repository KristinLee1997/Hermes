namespace java com.aries.hermes.idl.dto


struct CompanyDTO {
    1: string name,
    2: string password,
    3: string keyword
}

struct ReplyDTO {
    1: i64 id,
    2: i64 topicId,
    3: i64 gaeaId,
    4: string content,
    5: string insertTime,
    6: string updateTime,
    7: bool anonymousSend,
}

struct CategoryDTO {
    1: i64 id,
    2: string name,
}

struct SubReplyDTO {
    1: i64 id,
    2: i64 replyId,
    3: i64 senderGaeaId,
    4: i64 receiverGaeaId,
    5: string content,
    6: string insertTime,
}



