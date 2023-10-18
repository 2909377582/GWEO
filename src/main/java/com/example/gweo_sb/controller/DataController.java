package com.example.gweo_sb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1")
public class DataController {

    @PostMapping("/receiveData")
    // 接收一个HTTP请求，其中包含一个 Data 对象的数据，并将其转换为Java对象。
    // 然后，该方法可以对该对象进行处理，并返回一个ResponseEntity，通常包含字符串数据，作为HTTP响应的一部分。
    // 这在Web应用程序中常用于处理客户端发送的数据和返回相应的结果。
    public String createComment(@RequestBody Data data) {

        String upload_domain = data.getUpload_domain();
        String load_Content = data.getLoad_Content();

        return ("上载领域：" + upload_domain + ",上载内容：" + load_Content);
    }

}


