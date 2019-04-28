namespace java com.aries.hermes.idl.service
include 'dto.thrift'

service TopicServer{
    string ping();
    dto.ThriftResponse addTopic(1:dto.CompanyDTO companyDTO, 2:dto.TopicDTO topicDto);
    dto.TopicThriftResponse selectTopics(1:dto.CompanyDTO companyDTO, 2:dto.TopicDTO topicDto);
    dto.TopicThriftResponse selectAllTopics(1:dto.CompanyDTO companyDTO);
    dto.TopicThriftResponse batchQueryTopics(1:dto.CompanyDTO companyDTO, 2:i32 page, 3:i64 pagesize);
    dto.ThriftResponse deleteById(1:dto.CompanyDTO companyDTO, 2:i64 id);
    dto.ThriftResponse updateById(1:dto.CompanyDTO companyDTO,2:dto.TopicDTO topicDto);
}
