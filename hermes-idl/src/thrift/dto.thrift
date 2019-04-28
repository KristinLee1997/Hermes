namespace java com.aries.hermes.idl.dto

struct ThriftResponse{
//    1000：成功生效
//    1001：成功但无变化
//
//    2000：未知参数错误
//    2001：参数非法（参数不全，参数格式错误等）
//    2002：参数为null
//
//    3000：系统内部未知异常
//    3001：调用其他系统异常
//    3002：数据库异常
//
//    4000：
//    4001: 希望调用方重试
    1:required i32 code,
    2:required string message,
}

enum ResponseCode{
    SUCCESS = 1000,             // 1000：成功生效
    NOT_CHANGED = 1001,         // 1001：成功但无变化
    PARAM_ERROR = 2000,         // 2000：未知参数错误
    PARAM_ILLEGAL = 2001,       // 2001：参数非法（参数不全，参数格式错误等）
    PARAM_NULL = 2002,          // 2002：参数为null
    SYSTEM_ERROR = 3000,        // 3000：系统内部未知异常
    OTHERS_SYSTEM_ERROR = 3001, // 3001：调用其他系统异常
    PERMISSION_FAIL = 3002,     // 3002: 权限异常
    HOPE_RETRY = 4001,          // 4001: 希望调用方重试
}
struct CompanyDTO {
    1: string name,
    2: string password,
    3: string keyword,
}

struct TopicDTO{
    1:i64 id,
    2:string theme,
    3:string content,
    4:i64 gaeaId,
    5:bool anonymousSend,
    6:bool anonymousReply,
    7:i64 categoryId,
    8:string updateTime,
    9:string insertTime,
}

struct TopicThriftResponse{
    1:i32 code,
    2:string message,
    3:list<TopicDTO> topicDTO,
}



