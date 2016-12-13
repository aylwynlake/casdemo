SSO-with-CAS-example
====================

参考https://github.com/piotrekfus91/SSO-with-CAS-example修改, 里面使用的是波兰语, 感谢piotrekfus91

app user使用InMemoryUserDetailsManager以简化, 减去ldap的配置. 并且支持logout登出后跳转回当前服务


SSO implementation using CAS (as server) and Spring MVC (as clients).

To check it in action, you have to have a certified tomcat (sample certificate you can find in main directory - the name of the service is "localhost").
http://www.mkyong.com/tomcat/how-to-configure-tomcat-to-support-ssl-or-https/

Add to your hosts file entry which points to 127.0.0.1 and name "tomcat".

Build and run application. Checkout:
https://localhost:8443/app1/home
https://localhost:8443/app2/home
https://localhost:8443/cas/

