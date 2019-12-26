var ws = require("nodejs-websocket")  //node

// Scream server example: "hi" -> "HI!!!"
var PORT = 8002

var clientCount = 0

var server = ws.createServer(function (conn) {
    console.log("New connection")
    clientCount++
    conn.nickName = 'user' + clientCount
    broadcast(conn.nickName + 'come in')
    conn.on("text", function (str) {
        console.log("Received " + str)
        broadcast(str)
    })
    conn.on("close", function (code, reason) {  //客户端关闭时进行广播
        console.log("Connection closed")
        broadcast(conn.nickName + 'left')
    })
    conn.on("error", function (err) {
        console.log("handle err");
        console.log(err);
    })
}).listen(PORT)

function broadcast(str) {  //对每个客户端进行广播消息
    server.connections.forEach(function (connection) {
        connection.send(str)
    })
}

console.log("websocket server listening on port " + PORT)