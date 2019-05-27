namespace java com.aries.hermes.idl.service
include 'dto.thrift'

service TopicServer{
    string ping();
    dto.ThriftResponse addTopic(1:dto.CompanyDTO companyDTO, 2:dto.TopicDTO topicDto);
    dto.TopicThriftResponse selectTopics(1:dto.CompanyDTO companyDTO, 2:dto.TopicDTO topicDto);
    dto.TopicThriftResponse selectById(1:dto.CompanyDTO companyDTO, 2:i64 id);
    dto.TopicThriftResponse selectAllTopics(1:dto.CompanyDTO companyDTO);
    dto.TopicThriftResponse batchQueryTopics(1:dto.CompanyDTO companyDTO, 2:i32 page, 3:i32 pagesize);
    dto.ThriftResponse deleteById(1:dto.CompanyDTO companyDTO, 2:i64 id);
    dto.ThriftResponse updateById(1:dto.CompanyDTO companyDTO, 2:i64 id, 3:dto.TopicDTO topicDto);
    i64 getTopicCount(1:dto.CompanyDTO companyDTO, 2:i64 categoryId);
}

service ReplyServer{
    string ping(),
    dto.ThriftResponse addReply(1:dto.CompanyDTO companyDTO, 2:dto.ReplyDTO replyDTO),
    dto.ReplyDTO queryFirst(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
    dto.ReplyDTO queryById(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    dto.ReplyDTO queryNext(1:dto.CompanyDTO companyDTO, 2:i64 topicId, 3:i64 lastReplyId),
    list<dto.ReplyDTO> queryAllByTopicId(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
    list<dto.ReplyDTO> batchQueryByTopicId(1:dto.CompanyDTO companyDTO, 2:i64 topicId, 3:i32 page, 4:i32 pageSize),
    dto.ThriftResponse updateContent(1:dto.CompanyDTO companyDTO, 2:i64 replyId, 3:string content),
    dto.ThriftResponse deleteByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    dto.ThriftResponse batchDeleteByTopicId(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
    i64 getReplyCount(1:dto.CompanyDTO companyDTO, 2:i64 topicId),
}

service SubReplyServer{
    string ping(),
    dto.ThriftResponse addSubReply(1:dto.CompanyDTO companyDTO, 2:dto.SubReplyDTO subReplyDTO),
    dto.SubReplyDTO queryFirst(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    dto.SubReplyDTO queryById(1:dto.CompanyDTO companyDTO, 2:i64 subReplyId),
    dto.SubReplyDTO queryNext(1:dto.CompanyDTO companyDTO, 2:i64 replyId, 3:i64 lastReplyId),
    list<dto.SubReplyDTO> queryAllByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    list<dto.SubReplyDTO> batchQueryByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId, 3:i32 page, 4:i32 pageSize),
    dto.ThriftResponse updateContent(1:dto.CompanyDTO companyDTO, 2:i64 subReplyId, 3:string content),
    dto.ThriftResponse deleteBySubReplyId(1:dto.CompanyDTO companyDTO, 2:i64 subReplyId),
    dto.ThriftResponse batchDeleteByReplyId(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
    i64 getSubReplyCount(1:dto.CompanyDTO companyDTO, 2:i64 replyId),
}

service CategoryServer{
    string ping(),
    dto.ThriftResponse addCategory(1:dto.CompanyDTO companyDTO, 2:string categoryName),
    dto.CategoryDTO queryNextCategory(1:dto.CompanyDTO companyDTO, 2:i64 id),
    list<dto.CategoryDTO> queryAllCategorys(1:dto.CompanyDTO companyDTO),
    list<dto.CategoryDTO> batchQueryCategorys(1:dto.CompanyDTO companyDTO, 2:i32 page, 3:i32 pageSize),
    dto.ThriftResponse updateCategoryNameById(1:dto.CompanyDTO companyDTO, 2:i64 id, 3:string categoryName),
}