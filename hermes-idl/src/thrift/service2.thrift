namespace java com.aries.hermes.idl.service
include 'dto.thrift'
include 'dto2.thrift'
service ReplyServer{
    string ping(),
    dto.ThriftResponse addReply(1:dto.CompanyDTO companyDTO, 2:dto2.ReplyDTO replyDTO),
    dto2.ReplyDTO queryFirst(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
    dto2.ReplyDTO queryById(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    dto2.ReplyDTO queryNext(1:dto.CompanyDTO companyDTO, 2:i64 topicId, 3:i64 lastReplyId),
    list<dto2.ReplyDTO> queryAllByTopicId(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
    list<dto2.ReplyDTO> batchQueryByTopicId(1:dto.CompanyDTO companyDTO, 2:i64 topicId, 3:i32 page, 4:i32 pageSize),
    dto.ThriftResponse updateContent(1:dto.CompanyDTO companyDTO, 2:i64 replyId, 3:string content),
    dto.ThriftResponse deleteByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    dto.ThriftResponse batchDeleteByTopicId(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
}

service SubReplyServer{
    string ping(),
    dto.ThriftResponse addSubReply(1:dto.CompanyDTO companyDTO, 2:dto2.SubReplyDTO subReplyDTO),
    dto2.SubReplyDTO queryFirst(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    dto2.SubReplyDTO queryById(1:dto.CompanyDTO companyDTO, 2:i64 subReplyId),
    dto2.SubReplyDTO queryNext(1:dto.CompanyDTO companyDTO, 2:i64 replyId, 3:i64 lastReplyId),
    list<dto2.SubReplyDTO> queryAllByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    list<dto2.SubReplyDTO> batchQueryByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId, 3:i32 page, 4:i32 pageSize),
    dto.ThriftResponse updateContent(1:dto.CompanyDTO companyDTO, 2:i64 subReplyId, 3:string content),
    dto.ThriftResponse deleteBySubReplyId(1:dto.CompanyDTO companyDTO, 2:i64 subReplyId),
    dto.ThriftResponse batchDeleteByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
}

service CategoryServer{
    string ping(),
    dto.ThriftResponse addCategory(1:dto.CompanyDTO companyDTO, 2:string categoryName),
    dto2.CategoryDTO queryNextCategory(1:dto.CompanyDTO companyDTO, 2:i64 id),
    list<dto2.CategoryDTO> queryAllCategorys(1:dto.CompanyDTO companyDTO),
    list<dto2.CategoryDTO> batchQueryCategorys(1:dto.CompanyDTO companyDTO, 2:i32 page, 3:i32 pageSize),
    dto.ThriftResponse updateCategoryNameById(1:dto.CompanyDTO companyDTO, 2:i64 id, 3:string categoryName),
}