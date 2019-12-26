var ws = require("nodejs-websocket")

// Scream server example: "hi" -> "HI!!!"
var PORT = 8002

var clientCount = 0

var server = ws.createServer(function (conn) {
    console.log("New connection")
    clientCount++
    conn.nickName = 'user' + clientCount
    var mes = {}
    mes.type = "enter"
    mes.data = conn.nickName + 'comes in'
    broadcast(JSON.stringify(mes))

    conn.on("text", function (str) {
        console.log("Received " + str)
        var mes = {}
        mes.type = "message"
        mes.data = conn.nickName + 'says:' + str
        broadcast(JSON.stringify(mes))
    })
    conn.on("close", function (code, reason) {
        console.log("Connection closed")
        var mes = {}
        mes.type = "leave"
        mes.data = conn.nickName + 'left'
        broadcast(JSON.stringify(mes))
    })
    conn.on("error", function (err) {
        console.log("handle err");
        console.log(err);
    })
}).listen(PORT)

function broadcast(str) {
    server.connections.forEach(function (connection) {
        connection.send(str)
    })
}

console.log("websocket server listening on port " + PORT)