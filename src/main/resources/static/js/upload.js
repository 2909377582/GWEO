document.addEventListener("DOMContentLoaded", () => {

    const submit_btn = document.getElementById("submit-btn");
    const exp_input = document.getElementById("exp-input");
    const dropdown = document.getElementById("box-dropdown-icon");

    submit_btn.addEventListener("click", function(){


        var dropdown_textContent=dropdown.textContent
        var exp_input_value = exp_input.value
        var data={
            upload_domain:dropdown_textContent,
            load_Content:exp_input_value
        }

    // 配置请求选项
    var requestOptions = {
        body:JSON.stringify(data),
        method: "POST", // 使用 POST 方法
        headers: {
            "Content-Type": "application/json" // 设置请求头
        },
    };


    // 发送数据到服务器
    fetch("/api/receiveData", requestOptions)
        .then(response => {
            if (response.ok) {
                // 请求成功，可以执行相应操作
                console.log("数据上传成功");
                // 继续写业务代码，例如更新页面状态
                //向服务器请求数据

                //第一个.then(response => response.json())是在成功获取到服务器响应后，将响应转换为JSON格式。
                // response.json()返回一个Promise，该Promise在成功时解析为从服务器获取的JSON数据.
                // 第二个.then(data => {...})是在第一个.then()中的Promise解析成功后，处理实际的JSON数据。这是将数据传递给处理函数的阶段。
                fetch('/api/data')
                    .then(response => response.json())
                    .then(data => {
                        // 处理从后端返回的数据
                        console.log(data);
                        // 获取页面上的元素，并更新其内容
                        document.getElementById('load_content').innerText = data.load_Content;
                        document.getElementById('upload_domain').innerText = data.upload_domain;

                    })
                    .catch(error => console.error('Error:', error));
            } else {
                // 请求失败，处理错误情况
                console.error("数据上传失败");
            }
        })
        .catch(error => {
            // 捕获网络错误
            console.error("网络错误:", error);
        });

    socket.send(exp_input_value);


})
})
