var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
        $("#chat").show();
    } else {
        $("#conversation").hide();
        $("#chat").hide();
    }
    $("#greetings").html("");
}

function connect() {
    if (!$("#name").val()) {
        return;
    }
    var socket = new SockJS('/chat');//和 endpoint 建立连结
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        stompClient.subscribe('/topic/greetings', function (greeting) {  //订阅服务端发送回来的消息，并展现出来
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
}

function sendName() {
    stompClient.send("/app/hello",
        {},
        JSON.stringify({'name': $("#name").val(), 'content': $("#content").val()}));
}

function showGreeting(message) {
    $("#greetings")
        .append("<div>" + message.name + ":" + message.content + "</div>");
}

$(function () {
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});