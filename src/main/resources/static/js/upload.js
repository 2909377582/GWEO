document.addEventListener("DOMContentLoaded", () => {

    const submit_btn = document.getElementById("submit-btn");
    const exp_input = document.getElementById("exp-input");
    const dropdown = document.getElementById("box-dropdown-icon");

    const message_container = document.getElementById('message-container')
    var currentDate = moment();
    var formattedTime = currentDate.format('YYYY-MM-DD HH:mm:ss');
    var fresh_datas = []
    fetchData()
    //把传回的数据加载到页面上（第一次传回，第二次传回...）
    //写一个方法用于渲染
    function fetchData() {
        fetch('/api/data')
            .then(response => response.json())
            .then(data => {
                data.forEach(function(element) {
                    var one = element.upload_domain;
                    var two = element.load_Content;
                    var three = element.upload_time
                    var four = three + ':  user上传了' + one + '领域的' + two
                    fresh_datas.push(four)
                });

                fresh_datas.forEach(message_text => {

                    const message_element = document.createElement('div')
                    message_element.classList.add('message')
                    message_element.textContent = message_text
                    //处理这个元素，安排在屏幕上的位置
                    message_container.appendChild(message_element)
                });
            })
            .catch(error => console.error('Error fetching data:', error));
        console.log(fresh_datas)
        fresh_datas.length = 0
    }

    function requestOpload(){
        var dropdown_textContent=dropdown.textContent
        var exp_input_value = exp_input.value
        var data_no={
            upload_domain:dropdown_textContent,
            load_Content:exp_input_value,
            upload_time:formattedTime,
        }
        // 配置请求选项
        var json_data = JSON.stringify(data_no)
        var requestOptions = {
            body:json_data,
            method: "POST", // 使用 POST 方法
            headers: {
                "Content-Type": "application/json" // 设置请求头
            },
        };
        // 发送数据到数据库
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

        //发送到websocket
        socket.send(json_data);
        console.log('我发完了')
    }
    submit_btn.addEventListener("click", function(){
        message_container.innerHTML=''
        requestOpload()
        location.reload(true)
})
    document.addEventListener('fetch',()=>{
        location.reload()
    })
})
