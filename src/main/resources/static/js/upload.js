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
            } else {
                // 请求失败，处理错误情况
                console.error("数据上传失败");
            }
        })
        .catch(error => {
            // 捕获网络错误
            console.error("网络错误:", error);
        });
})
})
