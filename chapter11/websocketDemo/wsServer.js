var ws = require("nodejs-websocket")  //node wsServer.js 开启  ctrl+c 关闭

const url = require('url');     //引入模块

// Scream server example: "hi" -> "HI!!!"
var PORT = 8002
var server = ws.createServer(function (conn) { //客户端连结到服务器的回调函数
    console.log("New connection")
    conn.on("text", function (str) {  //消息放在str 里
        console.log("Received " + str)
        conn.sendText(str.toUpperCase() + "!!!")
    })
    conn.on("close", function (code, reason) {
        console.log("Connection closed")
    })
    conn.on("error", function (err) {
        console.log("handle err");
        console.log(err);
    })
}).listen(PORT)

console.log("websocket server listening on port " + PORT)