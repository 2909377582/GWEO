document.addEventListener("DOMContentLoaded", async () => {

    const submit_btn = document.getElementById("submit-btn");
    const exp_input = document.getElementById("exp-input");
    const dropdown = document.getElementById("box-dropdown-icon");
    const message_container = document.getElementById('message-container');
    var currentDate = moment();
    var formattedTime = currentDate.format('YYYY-MM-DD HH:mm:ss');

    const fetchData = async function() {
        try {
            const response = await fetch('/api/data');
            const data = await response.json();
            data.forEach(function(element) {
                var one = element.upload_domain;
                var two = element.load_Content;
                var three = element.upload_time;
                var four = three + ':  user上传了' + one + '领域的' + two;
                createMessageElement(four);
            });
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }

    const requestOpload = async function() {
        var dropdown_textContent = dropdown.textContent;
        var exp_input_value = exp_input.value;
        var data_no = {
            upload_domain: dropdown_textContent,
            load_Content: exp_input_value,
            upload_time: formattedTime,
        };

        var json_data = JSON.stringify(data_no);
        var requestOptions = {
            body: json_data,
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
        };

        try {
            const response = await fetch("/api/receiveData", requestOptions);
            if (response.ok) {
                console.log("数据上传成功");
            } else {
                console.error("数据上传失败");
            }
        } catch (error) {
            console.error("网络错误:", error);
        }
        socket.send(json_data);
        console.log('我发完了');
    }

    const createMessageElement = function(message_text) {
        const message_element = document.createElement('div');
        message_element.classList.add('message');
        message_element.textContent = message_text;
        message_container.appendChild(message_element);
    }

    submit_btn.addEventListener("click", async function(){
        await requestOpload();
        await fetchData();
    });

    await fetchData();
});
