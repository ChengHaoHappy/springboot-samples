const Koa = require('koa');

const websocket = require('./websocket');

const app = new Koa();

let server = app.listen(8801);  //开启http服务

app.wss = websocket(server);

global.wss = app.wss;

console.log('app started at port 8801...');   //这是一个注释A
