//当服务器通过 session.sendMessage 方法发送消息时，前端的 onmessage 事件被触发，
// 你可以在事件处理函数中获取到服务器发送的消息。
const socket = new WebSocket('ws://127.1.1.0:8080/ws');
//event指事件对象本身，封装了事件的相关信息
socket.onopen = function(event) {
    console.log('WebSocket connection opened:', event);
};

//关闭时控制台打印
socket.onclose = function(event) {
    console.log('WebSocket connection closed:', event);
};
//错误时控制台打印
socket.onerror = function(errorEvent) {
    console.error('WebSocket error:', errorEvent);
};

socket.onmessage = function(event) {
    //在 WebSocket 中，实际的消息数据通常存储在 data 属性中。
    const message = event.data;
    console.log('Received message from server:', message);
    location.reload()
    // 处理接收到的消息
};



