### SSODemo
按照环信客服官方文档集成单点登录 [官网地址](https://docs.easemob.com/cs/400systemintegration/sso)

#### 配置：
1.使用自定义域名访问系统，管理员-设置-扩展与集成-单点登录  
https://taoxic.kefu.easemob.com  
2.设置远程登录地址为：http://{本系统域名}/taoxic/sso，保存共享密钥，打开开关，并保存配置  
3.将共享密钥到配置到本系统配置文件：{easemob.sso.jwt.secret}，启动服务  

#### 验证
1.访问自定义域名，会跳转到本系统"SSO登录系统"页面  
https://taoxic.kefu.easemob.com  
2.输入账号：taoxic，密码：1234，点击登录  
3.成功跳转并登录客服系统  