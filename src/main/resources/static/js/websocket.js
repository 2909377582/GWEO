const socket = new WebSocket('ws://127.1.1.0:8080/ws');

socket.onopen = function(event) {
    console.log('WebSocket connection opened:', event);
};

socket.onmessage = function(event) {
    const message = event.data;
    console.log('Received message:', message);
    // 处理接收到的消息
};

socket.onclose = function(event) {
    console.log('WebSocket connection closed:', event);
};

socket.onerror = function(errorEvent) {
    console.error('WebSocket error:', errorEvent);
};

socket.onmessage = function(event) {
    const message = event.data;
    console.log('Received message from server:', message);
    // 处理接收到的消息
};



