namespace java com.aries.hermes.idl.dto

struct ThriftResponse{
//    1000：成功生效
//    1001：成功但无变化
//
//    2000：未知参数错误
//    2001：参数非法（参数不全，参数格式错误等）
//    2002：参数为空
//
//    3000：系统内部未知异常
//    3001：调用其他系统异常
//    3002：数据库异常
//
//    4000：
//    4001: 希望调用方重试
    1:required i32 code,
    2:required string message
}





