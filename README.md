### TranslateDemo

1.启动服务  
2.浏览器访问：http://localhost:8081/qwen/translate  
3.在 "SourceText 需要翻译的内容" 输入框中输入需要翻译的内容，点击 "翻译" 按钮
，即可在 "翻译结果" 中看到翻译后的内容    
4.点击 "清空" 按钮，即可清空全部内容 

注：  
仅支持中文翻译

#### 准备 docker 镜像


    $ cd /path/to/SSODemo/
    $ sh build-docker-image.sh

#### 启动服务

    $ docker run -d -it --name translate-container -p 8081:8080 translate/build

